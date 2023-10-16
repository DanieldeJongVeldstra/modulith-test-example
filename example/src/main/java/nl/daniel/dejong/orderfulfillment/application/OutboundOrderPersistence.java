package nl.daniel.dejong.orderfulfillment.application;

import nl.daniel.dejong.common.Persistence;
import nl.daniel.dejong.orderfulfillment.domain.order.OutboundOrder;
import org.jmolecules.architecture.hexagonal.Port;

@Port
public interface OutboundOrderPersistence extends Persistence<OutboundOrder> {
}
