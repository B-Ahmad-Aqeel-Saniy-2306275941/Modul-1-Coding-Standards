package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    private int nextId = 1;

    public Product create(Product product) {
        if (product.getProductId() == null || product.getProductId().isEmpty()) {
            product.setProductId(String.valueOf(nextId++));
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

    public Product update(Product updated) {
        Product existing = findById(updated.getProductId());
        if (existing == null) return null;

        existing.setProductName(updated.getProductName());
        existing.setProductQuantity(updated.getProductQuantity());
        return existing;
    }

    public boolean deleteById(String productId) {
        Product existing = findById(productId);
        if (existing == null) return false;

        productData.remove(existing);
        return true;
    }


}
