package nl.daniel.dejong.orderfulfillment.infrastructure.persistence;


import nl.daniel.dejong.orderfulfillment.application.OutboundOrderPersistence;
import nl.daniel.dejong.orderfulfillment.domain.order.OutboundOrder;
import nl.daniel.dejong.orderfulfillment.domain.order.valueobjects.OutboundOrderId;
import org.jmolecules.architecture.hexagonal.Adapter;
import org.jmolecules.ddd.annotation.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Adapter
@Repository
public interface OutboundOrderJpaPersistence extends OutboundOrderPersistence, JpaRepository<OutboundOrder, OutboundOrderId> {
}
