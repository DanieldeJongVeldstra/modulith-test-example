package nl.daniel.dejong.inventorymanagement.domain.product.events;

import nl.daniel.dejong.inventorymanagement.domain.product.definition.valueobjects.ProductDefinitionId;
import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductBarcode;
import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductId;
import org.jmolecules.event.annotation.DomainEvent;

@DomainEvent
public record ProductCreated(ProductId id, ProductDefinitionId productDefinitionId, ProductBarcode productBarcode, int stock) {
}
