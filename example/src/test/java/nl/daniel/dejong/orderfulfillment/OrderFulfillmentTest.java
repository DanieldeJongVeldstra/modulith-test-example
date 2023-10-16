package nl.daniel.dejong.orderfulfillment;

import lombok.RequiredArgsConstructor;
import nl.daniel.dejong.inventorymanagement.domain.product.definition.valueobjects.ProductDefinitionId;
import nl.daniel.dejong.orderfulfillment.application.OutboundOrderService;
import nl.daniel.dejong.orderfulfillment.domain.order.OutboundOrderFactory;
import nl.daniel.dejong.orderfulfillment.domain.order.OutboundOrderProduct;
import nl.daniel.dejong.orderfulfillment.domain.order.events.OutboundOrderCreated;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.util.List;

@ApplicationModuleTest(ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
@RequiredArgsConstructor
public class OrderFulfillmentTest {
    private static final String PRODUCT_DEFINITION_NAME = "Product 1";

    private final OutboundOrderService outboundOrderService;

    @Test
    public void createOutboundOrder(Scenario scenario) {
        var productDefinitionId = new ProductDefinitionId(PRODUCT_DEFINITION_NAME);

        var outboundOrderProduct = new OutboundOrderProduct(productDefinitionId, 10);
        var createOutboundOrder = new OutboundOrderFactory.OutboundOrderData(List.of(outboundOrderProduct));


        scenario.stimulate(() -> outboundOrderService.create(createOutboundOrder))
                .andWaitForEventOfType(OutboundOrderCreated.class)
                .matchingMappedValue(OutboundOrderCreated::products, List.of(outboundOrderProduct));
    }

}
