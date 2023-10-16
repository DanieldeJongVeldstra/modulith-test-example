package nl.daniel.dejong.inventorymanagement;

import nl.daniel.dejong.inventorymanagement.domain.product.definition.ProductDefinition;

import java.util.List;

public interface ProductDefinitionService {

    public List<ProductDefinition> getAll();
}
