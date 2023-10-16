package nl.daniel.dejong.inventorymanagement;

import lombok.RequiredArgsConstructor;
import nl.daniel.dejong.inventorymanagement.application.product.ProductDefinitionService;
import nl.daniel.dejong.inventorymanagement.application.product.ProductService;
import nl.daniel.dejong.inventorymanagement.domain.product.ProductFactory;
import nl.daniel.dejong.inventorymanagement.domain.product.definition.ProductDefinitionFactory;
import nl.daniel.dejong.inventorymanagement.domain.product.definition.events.ProductDefinitionCreated;
import nl.daniel.dejong.inventorymanagement.domain.product.definition.valueobjects.ProductDefinitionId;
import nl.daniel.dejong.inventorymanagement.domain.product.events.ProductCreated;
import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductBarcode;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

@ApplicationModuleTest
@RequiredArgsConstructor
class ProductIntegrationTest {
    private static final String PRODUCT_DEFINITION_NAME = "Product 1";
    private static final String PRODUCT_BARCODE = "1234567890123";
    private static final int STOCK = 10;

    private final ProductDefinitionService productDefinitionService;
    private final ProductService productService;

    @Test
    public void createProductDefinition(Scenario scenario) {
        var createProductDefinition = new ProductDefinitionFactory.ProductDefinitionData();
        createProductDefinition.setName(PRODUCT_DEFINITION_NAME);

        scenario.stimulate(() -> productDefinitionService.create(createProductDefinition))
                .andWaitForEventOfType(ProductDefinitionCreated.class)
                .matchingMappedValue(ProductDefinitionCreated::name, PRODUCT_DEFINITION_NAME);
    }

    @Test
    public void createProduct(Scenario scenario) {
        var productDefinitionId = new ProductDefinitionId(PRODUCT_DEFINITION_NAME);
        var productBarCode = new ProductBarcode(PRODUCT_BARCODE);

        var createProduct = new ProductFactory.ProductData(productDefinitionId, productBarCode, STOCK);

        scenario.stimulate(() -> productService.create(createProduct))
                .andWaitForEventOfType(ProductCreated.class)
                .matchingMappedValue(ProductCreated::productDefinitionId, productDefinitionId)
                .matchingMappedValue(ProductCreated::productBarcode, productBarCode);
    }
}
