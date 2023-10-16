package nl.daniel.dejong.inventorymanagement.infrastructure.persistence;

import nl.daniel.dejong.inventorymanagement.application.product.ProductDefinitionPersistence;
import nl.daniel.dejong.inventorymanagement.domain.product.definition.ProductDefinition;
import nl.daniel.dejong.inventorymanagement.domain.product.definition.valueobjects.ProductDefinitionId;
import org.jmolecules.architecture.hexagonal.Adapter;
import org.jmolecules.ddd.annotation.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Adapter
@Repository
public interface ProductDefinitionJpaPersistence extends ProductDefinitionPersistence, JpaRepository<ProductDefinition, ProductDefinitionId> {
}
