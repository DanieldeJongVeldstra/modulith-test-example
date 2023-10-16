package nl.daniel.dejong.inventorymanagement.domain.product.definition.events;

import nl.daniel.dejong.inventorymanagement.domain.product.definition.valueobjects.ProductDefinitionId;
import org.jmolecules.event.annotation.DomainEvent;

@DomainEvent
public record ProductDefinitionCreated(ProductDefinitionId id, String name) {
}
