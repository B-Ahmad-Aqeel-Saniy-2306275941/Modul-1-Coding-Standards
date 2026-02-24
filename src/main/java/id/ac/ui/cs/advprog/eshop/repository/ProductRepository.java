package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();


    public Product create(Product product) {
        if (product.getProductId() == null || product.getProductId().isBlank()) {
            product.setProductId(UUID.randomUUID().toString());
        }
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String productId) {
        for (Product product : productData) {
            if (product.getProductId() != null && product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public Product update(Product updatedProduct) {
        Product existingProduct = findById(updatedProduct.getProductId());
        if (existingProduct == null) return null;

        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setProductQuantity(updatedProduct.getProductQuantity());
        return existingProduct;
    }

    public boolean deleteById(String productId) {
        Product existingProduct = findById(productId);
        if (existingProduct == null) return false;

        productData.remove(existingProduct);
        return true;
    }


}
