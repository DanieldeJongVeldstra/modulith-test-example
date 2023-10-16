package nl.daniel.dejong.inventorymanagement.infrastructure.persistence;

import nl.daniel.dejong.inventorymanagement.application.product.ProductPersistence;
import nl.daniel.dejong.inventorymanagement.domain.product.Product;
import nl.daniel.dejong.inventorymanagement.domain.product.valueobjects.ProductId;
import org.jmolecules.architecture.hexagonal.Adapter;
import org.jmolecules.ddd.annotation.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Adapter
@Repository
public interface ProductJpaPersistence extends ProductPersistence, JpaRepository<Product, ProductId> {
}
