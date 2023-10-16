package nl.daniel.dejong.inventorymanagement.application.product;

import nl.daniel.dejong.common.Persistence;
import nl.daniel.dejong.inventorymanagement.domain.product.definition.ProductDefinition;
import org.jmolecules.architecture.hexagonal.Port;

import java.util.List;

@Port
public interface ProductDefinitionPersistence extends Persistence<ProductDefinition> {

    List<ProductDefinition> findAll();
}
