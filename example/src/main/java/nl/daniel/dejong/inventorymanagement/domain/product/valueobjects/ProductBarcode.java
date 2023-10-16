package nl.daniel.dejong.inventorymanagement.domain.product.valueobjects;

import lombok.Value;
import org.jmolecules.ddd.annotation.ValueObject;

@Value
@ValueObject
public class ProductBarcode {
    private final String barcode;

    public String toString() {
        return barcode;
    }
}
