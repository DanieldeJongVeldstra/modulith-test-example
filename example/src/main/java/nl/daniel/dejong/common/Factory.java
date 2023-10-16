package nl.daniel.dejong.common;

public interface Factory<A, D> {
    A createNew(D data);
}
