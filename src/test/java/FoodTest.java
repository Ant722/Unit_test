import org.example.Food;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FoodTest {

    @Test
    public void setQuantity() {
        Food[] products = {
                new Food("Тушёнка(упаковка-12шт)", 2000),
                new Food("Крупа гречневая(мешок-20кг)", 1600),
                new Food("Сгущеное молоко(жб-10л)", 3000)};

        products[2].setQuantity(13);
        products[1].setQuantity(1);

        int actual = 13;
        int expected = products[2].getQuantity();

        int actual1 = 1;
        int expected1 = products[1].getQuantity();

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected1, actual1);
    }

}