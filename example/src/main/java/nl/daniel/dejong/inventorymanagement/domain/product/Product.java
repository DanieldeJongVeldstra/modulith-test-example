package nl.daniel.dejong.inventorymanagement.domain.product;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import lombok.Getter;
import nl.daniel.dejong.inventorymanagement.domain.product.definition.valueobjects.ProductDefinitionId;
import nl.daniel.dejong.inventorymanagement.domain.product.events.ProductCreated;
import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductBarcode;
import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductId;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;
import org.springframework.data.domain.AbstractAggregateRoot;

@AggregateRoot
@Getter
public class Product extends AbstractAggregateRoot<Product> {
    @Identity
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private final ProductId id;
    @AttributeOverride(name = "value", column = @Column(name = "product_definition_id"))
    private ProductDefinitionId productDefinitionId;
    private ProductBarcode productBarcode;
    private int stock;

    public Product(ProductDefinitionId productDefinitionId, ProductBarcode productBarcode, int stock) {
        this.id = ProductId.random();
        this.productDefinitionId = productDefinitionId;
        this.productBarcode = productBarcode;
        this.stock = stock;

        registerEvent(new ProductCreated(id, productDefinitionId, productBarcode, stock));
    }


}
