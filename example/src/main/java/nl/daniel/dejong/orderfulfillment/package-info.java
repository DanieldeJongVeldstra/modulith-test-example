@ApplicationModule(
        displayName = "Order Fulfillment",
        allowedDependencies = {
                "inventorymanagement",
                "inventorymanagement::product-definition-value-objects",
                "common"
        }
)
package nl.daniel.dejong.orderfulfillment;

import org.springframework.modulith.ApplicationModule;