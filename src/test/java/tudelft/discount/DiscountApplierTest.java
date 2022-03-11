package tudelft.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class DiscountApplierTest {
    private ProductDao dao;

    @BeforeEach
    void setUp() {
        this.dao = Mockito.mock(ProductDao.class);
    }

    @Test
    public void productWithDiscountedPrice(){
        Product p1 = new Product("PC", 1999.99, "HOME");
        Product p2 = new Product("LAPTOP", 2999.99, "OTHER");

        List<Product> products = Arrays.asList(p1, p2);
        Mockito.when(dao.all()).thenReturn(products);

        DiscountApplier discountApplier = new DiscountApplier(dao);
        discountApplier.setNewPrices();
        List<Product> newPrices = dao.all();

        Assertions.assertEquals(1799.991, newPrices.get(0).getPrice(), "Product should be discounted");
        Assertions.assertEquals(2999.99, newPrices.get(1).getPrice(), "Product should be normal priced");
    }

    @Test
    public void productWithRaisedPrice(){
        Product p1 = new Product("PC", 1999.99, "OTHER");
        Product p2 = new Product("LAPTOP", 2999.99, "BUSINESS");

        List<Product> products = Arrays.asList(p1, p2);
        Mockito.when(dao.all()).thenReturn(products);

        DiscountApplier discountApplier = new DiscountApplier(dao);
        discountApplier.setNewPrices();
        List<Product> newPrices = dao.all();

        Assertions.assertEquals(1999.99, newPrices.get(0).getPrice(), "Product should be normal priced");
        Assertions.assertEquals(3299.989, newPrices.get(1).getPrice(), "Product should have raised price");
    }

}
