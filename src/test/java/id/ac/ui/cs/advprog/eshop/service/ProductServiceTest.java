package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Test Product");
        product.setProductQuantity(10);
    }


    @Test
    void testCreateReturnsProduct() {
        when(productRepository.create(product)).thenReturn(product);

        Product result = productService.create(product);

        assertNotNull(result);
        assertEquals(product.getProductId(), result.getProductId());
        assertEquals(product.getProductName(), result.getProductName());
        verify(productRepository, times(1)).create(product);
    }


    @Test
    void testFindAllReturnsAllProducts() {
        Product product2 = new Product();
        product2.setProductId("another-id");
        product2.setProductName("Another Product");
        product2.setProductQuantity(5);

        Iterator<Product> iterator = Arrays.asList(product, product2).iterator();
        when(productRepository.findAll()).thenReturn(iterator);

        List<Product> result = productService.findAll();

        assertEquals(2, result.size());
        assertEquals("Test Product", result.get(0).getProductName());
        assertEquals("Another Product", result.get(1).getProductName());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testFindAllWhenEmptyList() {
        Iterator<Product> emptyIterator = java.util.Collections.emptyIterator();
        when(productRepository.findAll()).thenReturn(emptyIterator);

        List<Product> result = productService.findAll();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(productRepository, times(1)).findAll();
    }


    @Test
    void testFindByIdReturnsFoundProduct() {
        when(productRepository.findById(product.getProductId())).thenReturn(product);

        Product result = productService.findById(product.getProductId());

        assertNotNull(result);
        assertEquals(product.getProductId(), result.getProductId());
        verify(productRepository, times(1)).findById(product.getProductId());
    }

    @Test
    void testFindByIdWhenProductNotFound() {
        when(productRepository.findById("invalid-id")).thenReturn(null);

        Product result = productService.findById("invalid-id");

        assertNull(result);
        verify(productRepository, times(1)).findById("invalid-id");
    }


    @Test
    void testUpdateReturnsUpdatedProduct() {
        product.setProductName("Updated Product");
        when(productRepository.update(product)).thenReturn(product);

        Product result = productService.update(product);

        assertNotNull(result);
        assertEquals("Updated Product", result.getProductName());
        verify(productRepository, times(1)).update(product);
    }

    @Test
    void testUpdateWhenProductNotFoundWillReturnsNull() {
        when(productRepository.update(product)).thenReturn(null);

        Product result = productService.update(product);

        assertNull(result);
        verify(productRepository, times(1)).update(product);
    }


    @Test
    void testDeleteById() {
        when(productRepository.deleteById(product.getProductId())).thenReturn(true);

        boolean result = productService.deleteById(product.getProductId());

        assertTrue(result);
        verify(productRepository, times(1)).deleteById(product.getProductId());
    }

    @Test
    void testDeleteByIdIfProductNotFound() {
        when(productRepository.deleteById("invalid-id")).thenReturn(false);

        boolean result = productService.deleteById("invalid-id");

        assertFalse(result);
        verify(productRepository, times(1)).deleteById("invalid-id");
    }
}