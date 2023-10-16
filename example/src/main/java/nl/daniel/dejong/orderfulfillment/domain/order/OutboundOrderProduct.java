package nl.daniel.dejong.orderfulfillment.domain.order;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.daniel.dejong.inventorymanagement.domain.product.definition.valueobjects.ProductDefinitionId;
import nl.daniel.dejong.orderfulfillment.domain.order.valueobjects.OutboundOrderId;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@IdClass(OutboundOrderProduct.OutboundOrderProductKey.class)
public class OutboundOrderProduct {
    @AttributeOverride(name = "value", column = @Column(name = "productDefinitionId"))
    ProductDefinitionId productDefinitionId;
    int quantity;

    void verify() {
        if (this.quantity <= 0) {
            throw new IllegalArgumentException("Outbound order product quantity must be greater than zero");
        }
    }

    @Embeddable
    public static class OutboundOrderProductKey {
        private OutboundOrderId outboundOrderId;
        private ProductDefinitionId productDefinitionId;
    }
}
