package com.pms.servicetest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pms.model.Product;
import com.pms.repository.ProductRepository;
import com.pms.service.ProductService;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    void init() {
        product = Product.builder().productName("shoe").description("Size- 9, color-black")
              .price(900.0).quantity(5).status("In Stock").productType("Men's shoe").build();
    }

    @Test
    @DisplayName("Testing create Product method")
    void testcreateProduct() {
        when(productRepository.save(product)).thenReturn(product);
        
     // Call the createProduct() method and assert the result
        assertThat(productService.SaveProduct(product)).isEqualTo(product);
       
    }

    
    @Test
    @DisplayName("Testing Save Product method")
    void testSaveProduct() {
        Product product = new Product();
        product.setId(1);
        product.setProductName("Watch");
        product.setDescription("Size-9, color - red, brand- fire bolt");
        product.setPrice(1500.0);
        product.setQuantity(10);
        product.setStatus("In stock");
        product.setProductType("Electronic device");

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.SaveProduct(product);

        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getProductName()).isEqualTo("Watch");
        assertThat(result.getDescription()).isEqualTo("Size-9, color - red, brand- fire bolt");
        assertThat(result.getPrice()).isEqualTo(1500.0);
        assertThat(result.getQuantity()).isEqualTo(10);
        assertThat(result.getStatus()).isEqualTo("In stock");
        assertThat(result.getProductType()).isEqualTo("Electronic device");
    }

    @Test
    @DisplayName("Testing get product by id method")
    void testGetProductById() {
        Optional<Product> optionalProduct = Optional.of(product);

        when(productRepository.findById(product.getId())).thenReturn(optionalProduct);

        assertThat(productService.getProductById(product.getId()).getProductName())
                .isEqualTo("shoe");
    }

    @Test
    @DisplayName("Negative test case")
    void testNegativeGetProductById() {
        Optional<Product> optionalProduct = Optional.of(product);

        when(productRepository.findById(product.getId())).thenReturn(optionalProduct);

        assertThat(productService.getProductById(product.getId()).getProductName())
                .isNotEqualTo(product.getProductName());
    }

}
