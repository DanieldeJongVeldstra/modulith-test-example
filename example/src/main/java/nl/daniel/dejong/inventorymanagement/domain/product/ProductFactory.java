package nl.daniel.dejong.inventorymanagement.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.daniel.dejong.common.Factory;
import nl.daniel.dejong.inventorymanagement.domain.product.definition.valueobjects.ProductDefinitionId;
import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductBarcode;
import org.springframework.stereotype.Component;

@Component
public class ProductFactory implements Factory<Product, ProductFactory.ProductData> {

    @Override
    public Product createNew(ProductData data) {
        return new Product(data.productDefinitionId, data.productBarcode, data.stock);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static final class ProductData {
        private ProductDefinitionId productDefinitionId;
        private ProductBarcode productBarcode;
        private int stock;

    }
}
