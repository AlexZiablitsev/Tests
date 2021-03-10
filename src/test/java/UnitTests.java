import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {
    // a > 0 , b > 0, проверить a + b
    @Test
    public void sumTest1() {
        Calculate calc = new Calculate();
        Assert.assertEquals(calc.sum(2, 3), 5, "Тестовый комментарий");
    }

    // a < 0 , b < 0, проверить  a + b
    @Test
    public void sumTest2() {
        Calculate calc = new Calculate();
        Assert.assertEquals(calc.sum(-2, -3), -5);
    }

    //a > 0, b < 0, проверить a + b
    @Test

    public void sumTest3() {
        Calculate calc = new Calculate();
        Assert.assertEquals(calc.sum(2, -3), -1);
    }

    //a > 0, b > 0, проверить a / b
    @Test
    public void divTest1() {
        Calculate calc = new Calculate();
        Assert.assertEquals(calc.div(4, 2), 2);
    }

    //a > 0, b = 0, проверить a / b
    @Test
    public void divTest2() {
        Calculate calc = new Calculate();
        Assert.assertThrows(java.lang.ArithmeticException.class, () -> calc.div(4, 0));
    }

    @Test
    public void divTest3() {
        Calculate calculate = new Calculate();
        Assert.assertEquals(calculate.divFloat(4.5f, 5.5f), 0.8181818181818182f);
    }

    //a > 0, b = 0
    @Test
    public void divTest4() {
        Calculate calc = new Calculate();
        Assert.assertEquals(calc.divFloat(4.5f, 0), Float.POSITIVE_INFINITY);
    }

    //a < 0, b = 0
    @Test
    public void divTest5() {
        Calculate calc = new Calculate();
        Assert.assertEquals(calc.divFloat(-4.5f, 0), Float.NEGATIVE_INFINITY);
    }

    @Test
    public void sqrtTest1() {
        Calculate calculate = new Calculate();
        Assert.assertEquals(calculate.sqrt(10.5f), 3.240370273590088);
    }

    @Test
    public void sqrtTest2() {
        Calculate calculate = new Calculate();
        Assert.assertEquals(calculate.sqrt(-10.5f), Float.NaN);
    }
}
