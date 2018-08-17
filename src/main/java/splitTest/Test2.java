package splitTest;

public class Test2 {
    public String reverseWords(String s) {
        // 转义字符是以 \\ 开始的
        // \\s+: 表示一个或多个空格  输出结果： blue is sky the
        // \\s*: 表示0个或多个空格   输出结果： e u l b  s i  y k s  e h t
        String[] split = s.trim().split("\\s+");
        String out = "";
        for (int i = split.length - 1; i > 0; i--) {
            out += split[i] + " ";
        }
        return out + split[0];
    }


    public String reverseWords11(String s) {
        String[] split = s.trim().split("\\s+");
        String reverseS = "";
        for (int i = split.length - 1; i > 0; i--) {
            reverseS = reverseS + split[i] + " ";
        }
        return reverseS + split[0];
    }
}
