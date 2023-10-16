package nl.daniel.dejong.orderfulfillment.application;

import nl.daniel.dejong.common.AbstractService;
import nl.daniel.dejong.orderfulfillment.domain.order.OutboundOrder;
import nl.daniel.dejong.orderfulfillment.domain.order.OutboundOrderFactory;
import org.jmolecules.ddd.annotation.Service;

@Service
public class OutboundOrderService extends AbstractService<OutboundOrderPersistence, OutboundOrder, OutboundOrderFactory.OutboundOrderData> {
    public OutboundOrderService(OutboundOrderPersistence persistence, OutboundOrderFactory factory) {
        super(persistence, factory);
    }
}
