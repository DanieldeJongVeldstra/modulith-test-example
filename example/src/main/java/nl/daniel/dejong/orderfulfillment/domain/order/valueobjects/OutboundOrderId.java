package nl.daniel.dejong.orderfulfillment.domain.order.valueobjects;

import lombok.Value;
import nl.daniel.dejong.common.URN;
import org.jmolecules.ddd.annotation.ValueObject;

import java.util.UUID;

@ValueObject
@Value
public class OutboundOrderId extends URN<UUID> {
    private final static String NAMESPACE = "outbound-order";
    public OutboundOrderId(UUID value, String namespace) {
        super(value, namespace);
    }

    public OutboundOrderId() {
        super(null, NAMESPACE);
    }

    public static OutboundOrderId random() {
        return new OutboundOrderId(UUID.randomUUID(), NAMESPACE);
    }

    public String toString() {
        return super.toString();
    }
}
