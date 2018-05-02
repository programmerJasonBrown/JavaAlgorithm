package lintCodeProblem.convertStringToInt;

/*
问题描述：

实现atoi这个函数，将一个字符串转换为整数。如果没有合法的整数，返回0。如果整数超出了32位整数的范围，返回INT_MAX(2147483647)如果是正整数，或者INT_MIN(-2147483648)如果是负整数。

样例

"10" =>10

"-1" => -1

"123123123123123" => 2147483647

"1.0" => 1
（一）.""的话返回0。

（二）.字符串两边有空格自动屏蔽，有小数点小数点后面的内容舍弃。

（三）."+123"和"123"效果一样。

（四）."a...","-h..."这种，除了符号位只要非数字打头，返回0。

（五）."123gdah3423","-123ff777"这种返回123，-123。

（六）.超了范围之后，判断正负性。
* */
public class ConvertStringToIntLearnFromNet {
    public int atoi(String str) {
        String str1 = null;
        StringBuilder sb = new StringBuilder();
        if (str.contains("."))
            str1 = str.substring(0, str.indexOf(".")).trim();
        else
            str1 = str.trim();
        if ("".equals(str1))
            return 0;
        try {
            return Integer.parseInt(str1);
        } catch (NumberFormatException e) {
            if (str1.charAt(0) != '+' && str1.charAt(0) != '-') {  // 字符串前面没有+ 也没有 -
                processData(0, sb, str1);
                if (sb.length() == 0) //第一个字符不是数字
                    return 0;
                else if (sb.length() < str1.length())  //后面存在非数字
                    return atoi(sb.toString());
                return Integer.MAX_VALUE;          //因为超过了32位而报的错
            } else if (str1.charAt(0) == '+') {  //字符串以+开头
                processData(1,sb,str1);
                if (sb.length()==0)
                    return 0;
                else if (sb.length() < str1.length()-1)
                    return atoi(sb.toString());
                return Integer.MAX_VALUE;
            } else {   //字符串以-开头
                sb.append('-');
                processData(1,sb,str1);
                if (sb.length() == 1)
                    return 0;
                else if (sb.length() < str1.length())
                    return atoi(sb.toString());
                return Integer.MIN_VALUE;
            }
        }
    }

    public void processData(int start, StringBuilder sb, String str) {
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                break;
            sb.append(str.charAt(i));
        }
    }

    public static void main(String[] args) {
        ConvertStringToIntLearnFromNet c = new ConvertStringToIntLearnFromNet();
        String str = "111111111111111kkk";
        System.out.println(c.atoi(str));
    }
}
