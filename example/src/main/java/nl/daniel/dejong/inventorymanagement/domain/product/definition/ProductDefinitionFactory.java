package nl.daniel.dejong.inventorymanagement.domain.product.definition;

import lombok.Data;
import nl.daniel.dejong.common.Factory;
import org.springframework.stereotype.Component;

@Component
public class ProductDefinitionFactory implements Factory<ProductDefinition, ProductDefinitionFactory.ProductDefinitionData> {
    public ProductDefinition createNew(ProductDefinitionData data) {
        return new ProductDefinition(data.name);
    }

    @Data
    public static class ProductDefinitionData {
        private String name;
    }
}
