package Test51CreditCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
//        正常输入： expect actual  即字符串空格字符串
        if (x==null || x.length()==0) {
            //输入检测
            System.out.println(false);
            return;
        }
        x.trim();
        String[] split = x.split("\\s+");
        if (split.length<2){
            System.out.println(false);
            return;
        }

        String expect = split[0];
        String[] expects = expect.split("\\|");
        String actual = split[1];
        String[] actuals = actual.split("\\|");


        List<int[]> expectIntList = new ArrayList<>();
        List<int[]> actualIntList = new ArrayList<>();

        for (int i = 0; i < expects.length; i++) {
            String[] expectSplits = expects[i].split(",");
            int[] temp = new int[expectSplits.length];
            for (int j = 0; j < expectSplits.length; j++) {
                temp[j] = Integer.parseInt(expectSplits[j]);
            }
            expectIntList.add(temp);
        }

        for (int i = 0; i < actuals.length; i++) {
            String[] actualSplits = actuals[i].split(",");
            int[] temp = new int[actualSplits.length];
            for (int j = 0; j < actualSplits.length; j++) {
                temp[j] = Integer.parseInt(actualSplits[j]);
            }
            actualIntList.add(temp);
        }
        System.out.println(process(expectIntList, actualIntList));
    }

    public static boolean process(List<int[]> expectIntList, List<int[]> actualIntList) {
        if (expectIntList.size()!=actualIntList.size())
            return false;
        for (int i = 0; i < expectIntList.size(); i++) {
            int[] expect = expectIntList.get(i);
            int[] actual = actualIntList.get(i);
//            if (expect.length != actual.length)
//                return false;
//            for (int j = 0; j < expect.length; j++) {
//                if (expect[j] != actual[j])
//                    return false;
//            }
            if (!Arrays.equals(expect,actual))
                return false;
        }
        return true;
    }
}
