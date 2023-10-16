package nl.daniel.dejong.inventorymanagement.domain.product.valueobjects;

import lombok.Value;
import nl.daniel.dejong.common.URN;
import org.jmolecules.ddd.annotation.ValueObject;

import java.util.UUID;

@ValueObject
@Value
public class ProductId extends URN<UUID> {
    private final static String NAMESPACE = "product";

    public ProductId(UUID value) {
        super(value, NAMESPACE);
    }

    public ProductId() {
        super(null, NAMESPACE);
    }

    public static ProductId random() {
        return new ProductId(UUID.randomUUID());
    }

    public String toString() {
        return super.toString();
    }
}
