package nl.daniel.dejong.orderfulfillment.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.daniel.dejong.common.Factory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class OutboundOrderFactory implements Factory<OutboundOrder, OutboundOrderFactory.OutboundOrderData> {

    @Override
    public OutboundOrder createNew(OutboundOrderData data) {
        return new OutboundOrder(Set.copyOf(data.products));
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static final class OutboundOrderData {
        private List<OutboundOrderProduct> products = new ArrayList<>();
    }
}
