package nl.daniel.dejong.inventorymanagement.domain.product.definition.valueobjects;

import lombok.EqualsAndHashCode;
import lombok.Value;
import nl.daniel.dejong.common.URN;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@Value
@EqualsAndHashCode(callSuper = true)
public class ProductDefinitionId extends URN<String> {
    public final static String NAMESPACE = "product-definition";
    public ProductDefinitionId(String value) {
        super(value, NAMESPACE);
    }

    public ProductDefinitionId() {
        super(null, NAMESPACE);
    }

    public String toString() {
        return super.toString();
    }
}
