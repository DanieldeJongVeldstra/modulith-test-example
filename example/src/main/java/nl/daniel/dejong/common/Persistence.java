package nl.daniel.dejong.common;

import org.springframework.data.domain.AbstractAggregateRoot;

public interface Persistence<A extends AbstractAggregateRoot<A>> {
    A save(A aggregate);
}
