package nl.daniel.dejong.inventorymanagement.application.product;

import nl.daniel.dejong.common.AbstractService;
import nl.daniel.dejong.common.Factory;
import nl.daniel.dejong.inventorymanagement.domain.product.Product;
import nl.daniel.dejong.inventorymanagement.domain.product.ProductFactory;
import org.jmolecules.ddd.annotation.Service;

@Service
public class ProductService extends AbstractService<ProductPersistence, Product, ProductFactory.ProductData> {
    public ProductService(ProductPersistence persistence, Factory<Product, ProductFactory.ProductData> factory) {
        super(persistence, factory);
    }
}
