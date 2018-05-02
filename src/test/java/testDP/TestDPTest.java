package testDP;

import org.junit.Before;
import org.junit.Test;

public class TestDPTest {
    @Test
    public void lISProblem() {
        testDP.lISProblem();
    }

    @Test
    public void dPMaxSum() {
        testDP.dPMaxSum();
    }

    private TestDP testDP;

    @Before
    public void beforeStart() {
        testDP = new TestDP();
    }

    @Test
    public void moneyProblem() {
        testDP.moneyProblem();
    }

    @Test
    public void recursionMaxSum() {
        int maxSum = testDP.recursionMaxSum(0, 0, 4);
        System.out.println(maxSum);
    }

}