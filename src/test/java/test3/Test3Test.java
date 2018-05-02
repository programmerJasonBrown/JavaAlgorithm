package test3;

import org.junit.Before;
import org.junit.Test;

public class Test3Test {

    Test3 test3;
    @Before
    public void startWith(){
        test3 = new Test3();

    }
    @Test
    public void myMethod() {
        int []nums ={2,3,-2,4};
        System.out.println(test3.myMethod(nums));
    }

    @Test
    public void maxProduct() {
        int []nums ={2,3,-2,4};
        System.out.println(test3.maxProduct(nums));
    }

}