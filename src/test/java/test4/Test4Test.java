package test4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Test4Test {
    private Test4 test4;

    @Before
    public void startWith(){
        test4 = new Test4();
    }
    @Test
    public void myMethodFindMinTest() {
        int []nums = {3,4,5,6,0,1,2};
        int []nums2 = {2,1};
        System.out.println(test4.myMethodFindMin(nums2));
    }


}