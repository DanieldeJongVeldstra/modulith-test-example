package nl.daniel.dejong.inventorymanagement.application.product;

import nl.daniel.dejong.common.AbstractService;
import nl.daniel.dejong.common.Factory;
import nl.daniel.dejong.inventorymanagement.domain.product.definition.ProductDefinition;
import nl.daniel.dejong.inventorymanagement.domain.product.definition.ProductDefinitionFactory;
import org.jmolecules.ddd.annotation.Service;

import java.util.List;

@Service
public class ProductDefinitionService extends AbstractService<ProductDefinitionPersistence, ProductDefinition, ProductDefinitionFactory.ProductDefinitionData> implements nl.daniel.dejong.inventorymanagement.ProductDefinitionService {
    public ProductDefinitionService(ProductDefinitionPersistence persistence, Factory<ProductDefinition, ProductDefinitionFactory.ProductDefinitionData> factory) {
        super(persistence, factory);
    }

    @Override
    public List<ProductDefinition> getAll() {
        return this.persistence.findAll();
    }
}
