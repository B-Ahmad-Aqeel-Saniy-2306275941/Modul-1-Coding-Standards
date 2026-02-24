package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;
    private Product sampleProduct;
    private final String SAMPLE_ID = "eb558e9f-1c39-460e-8860-71af6af63bd6";

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();

        sampleProduct = new Product();
        sampleProduct.setProductId(SAMPLE_ID);
        sampleProduct.setProductName("Sample Product");
        sampleProduct.setProductQuantity(50);
    }

    @Test
    void testCreateProductPage() throws Exception {
        mockMvc.perform(get("/product/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("createProduct"))
                .andExpect(model().attributeExists("product"));

        verifyNoInteractions(productService);
    }

    @Test
    void testCreateProductPost() throws Exception {
        when(productService.create(any(Product.class))).thenAnswer(i -> i.getArgument(0));

        mockMvc.perform(post("/product/create")
                        .param("productName", "New Product")
                        .param("productQuantity", "100"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("list"));

        verify(productService, times(1)).create(any(Product.class));
    }

    @Test
    void testProductListPage() throws Exception {
        List<Product> productList = List.of(sampleProduct);

        when(productService.findAll()).thenReturn(productList);

        mockMvc.perform(get("/product/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("productList"))
                .andExpect(model().attributeExists("products"))
                .andExpect(model().attribute("products", productList));

        verify(productService, times(1)).findAll();
    }

    @Test
    void testEditProductPage_WithValidId() throws Exception {
        when(productService.findById(SAMPLE_ID)).thenReturn(sampleProduct);

        mockMvc.perform(get("/product/edit/{id}", SAMPLE_ID))
                .andExpect(status().isOk())
                .andExpect(view().name("editProduct"))
                .andExpect(model().attributeExists("product"))
                .andExpect(model().attribute("product", sampleProduct));

        verify(productService, times(1)).findById(SAMPLE_ID);
    }

    @Test
    void testEditProductPage_WithInvalidId() throws Exception {
        String invalidId = "invalid-id";
        when(productService.findById(invalidId)).thenReturn(null);

        mockMvc.perform(get("/product/edit/{id}", invalidId))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/product/list"));

        verify(productService, times(1)).findById(invalidId);
    }

    @Test
    void testEditProductPost() throws Exception {
        when(productService.update(any(Product.class))).thenAnswer(i -> i.getArgument(0));

        mockMvc.perform(post("/product/edit")
                        .param("productId", SAMPLE_ID)
                        .param("productName", "Updated Product"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/product/list"));

        verify(productService, times(1)).update(any(Product.class));
    }


    @Test
    void testDeleteProductPost() throws Exception {
        when(productService.deleteById(SAMPLE_ID)).thenAnswer(i -> null);

        mockMvc.perform(post("/product/delete/{id}", SAMPLE_ID))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/product/list"));

        verify(productService, times(1)).deleteById(SAMPLE_ID);
    }
}