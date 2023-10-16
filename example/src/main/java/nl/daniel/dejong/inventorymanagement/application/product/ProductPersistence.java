package nl.daniel.dejong.inventorymanagement.application.product;

import nl.daniel.dejong.common.Persistence;
import nl.daniel.dejong.inventorymanagement.domain.product.Product;
import org.jmolecules.architecture.hexagonal.Port;

@Port
public interface ProductPersistence extends Persistence<Product> {
}
