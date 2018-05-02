package lintCodeProblem.convertStringToInt;
/*
* 错在题目表述不清，  但是代码有一定作用，也有可以改进的地方。
* Integer.parseInt() 在超过32位时也会报NumberFormatException 异常
* */
public class ConvertStringToInt {
    public int atoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        String[] removeSpace = str.split("\\s+|[^0-9,.,-]+");
        str = "";
        for (String x : removeSpace) {
            str += x;
        }
        if(str.length()==0)
            return 0;
        int sign = 1;
        //处理字符串
        String strInt;
        String[] splits = str.split("-|\\.");

        if (str.charAt(0) == '-') {
            sign = -1;
            strInt = splits[1];
        } else {
            strInt = splits[0];
        }
        //****处理结束****  strInt为一个正整数的字符串
        if (strInt.length() > 10) {
            if (sign == 1)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        } else if (strInt.length() == 10) {
            String intMax = Integer.toString(Integer.MAX_VALUE);
            for (int i = 0; i < 10; i++) {
                if (strInt.charAt(i) > intMax.charAt(i)) {
                    if (sign == 1)
                        return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                }

            }
        }
        return Integer.parseInt(strInt) * sign;
    }

    public static void main(String[] args) {
        String str = "    k-+11.0";
    /*    String str = "    k   a  i   i";
        String[] split = str.split("\\s+");
        String s = "";
        for (String x : split) {
            s += x;
        }*/
        ConvertStringToInt convertStringToInt = new ConvertStringToInt();
        System.out.println(convertStringToInt.atoi(str));
    }
}
