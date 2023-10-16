package nl.daniel.dejong.inventorymanagement.domain.product.definition;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import lombok.Getter;
import nl.daniel.dejong.inventorymanagement.domain.product.definition.events.ProductDefinitionCreated;
import nl.daniel.dejong.inventorymanagement.domain.product.definition.valueobjects.ProductDefinitionId;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;
import org.springframework.data.domain.AbstractAggregateRoot;

@AggregateRoot
@Getter
public class ProductDefinition extends AbstractAggregateRoot<ProductDefinition> {
    @Identity
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private final ProductDefinitionId id;
    private String name;

    public ProductDefinition(String name) {
        this.id = new ProductDefinitionId(name);
        this.name = name;
        registerEvent(new ProductDefinitionCreated(id, name));
    }
}
