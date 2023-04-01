import org.example.Basket;
import org.example.Food;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

class BasketTest {
    @Test
    public void testLoadFromTxtWhenFileNotExist() {
        Assertions.assertThrows(FileNotFoundException.class,
                () -> Basket.loadFromJsonFile(new File("src/test//testBask.json"))
        );
    }

    @Test
    public void addToCart() {
        Food[] products = {
                new Food("Тушёнка(упаковка-12шт)", 2000),
                new Food("Крупа гречневая(мешок-20кг)", 1600),
                new Food("Сгущеное молоко(жб-10л)", 3000)};
        Basket basket = new Basket(products);

        basket.addToCart(2, 8);
        basket.addToCart(0, 5);

        int[] actual = new int[products.length];

        for (int i = 0; i < products.length; i++) {
            actual[i] = products[i].getQuantity();
        }

            int[] expected = {5, 0, 8};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void loadFromJsonFile() throws IOException, ParseException {
        Basket basket = Basket.loadFromJsonFile(new File("src/test/testBasket.json"));

        int expectedSumProducts = 32400;
        int actualSumProducts = basket.getSumProducts();
        Assertions.assertEquals(expectedSumProducts, actualSumProducts);
    }

}