package nl.daniel.dejong.orderfulfillment.domain.order;

import jakarta.persistence.*;
import lombok.Getter;
import nl.daniel.dejong.orderfulfillment.domain.order.events.OutboundOrderCreated;
import nl.daniel.dejong.orderfulfillment.domain.order.valueobjects.OutboundOrderId;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Set;
import java.util.stream.Collectors;

@AggregateRoot
@Getter
public class OutboundOrder extends AbstractAggregateRoot<OutboundOrder> {
    @Identity
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private final OutboundOrderId id;

    @CollectionTable(name = "outbound_order_product", joinColumns = @JoinColumn(name = "outbound_order_id"))
    @ElementCollection
    private Set<OutboundOrderProduct> products;

    public OutboundOrder(Set<OutboundOrderProduct> products) {
        this.id = OutboundOrderId.random();
        this.products = products;

        this.verify();
        this.registerEvent(new OutboundOrderCreated(this.id, this.products));
    }

    private void verify() {
        if (this.products.isEmpty()) {
            throw new IllegalArgumentException("Outbound order must contain at least one product");
        }

        deDuplicateProducts();

        this.products.forEach(OutboundOrderProduct::verify);
    }

    private void deDuplicateProducts() {
        this.products = this.products.stream()
                .collect(Collectors.groupingBy(OutboundOrderProduct::getProductDefinitionId))
                .values()
                .stream()
                .map(outboundOrderProducts -> new OutboundOrderProduct(outboundOrderProducts.get(0).getProductDefinitionId(), outboundOrderProducts.stream().mapToInt(OutboundOrderProduct::getQuantity).sum()))
                .collect(Collectors.toSet());
    }
}
