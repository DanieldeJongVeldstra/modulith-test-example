package nl.daniel.dejong.common;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

@RequiredArgsConstructor
public class AbstractService <P extends Persistence<A>, A extends AbstractAggregateRoot<A>, D> {
    protected final P persistence;
    private final Factory<A, D> factory;

    public void create(D data) {
        A aggregate = factory.createNew(data);
        persistence.save(aggregate);
    }
}
