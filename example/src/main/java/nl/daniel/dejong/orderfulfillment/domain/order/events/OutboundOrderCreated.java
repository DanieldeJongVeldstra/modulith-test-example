package nl.daniel.dejong.orderfulfillment.domain.order.events;

import nl.daniel.dejong.orderfulfillment.domain.order.OutboundOrderProduct;
import nl.daniel.dejong.orderfulfillment.domain.order.valueobjects.OutboundOrderId;
import org.jmolecules.event.annotation.DomainEvent;

import java.util.Set;

@DomainEvent
public record OutboundOrderCreated (OutboundOrderId id, Set<OutboundOrderProduct> products) {
}
