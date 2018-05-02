package test1;

import java.util.Stack;

public class JieMa {
    public static void main(String[] args) {
        process("2[kB2[A]10[B]C]");
    }

    public static void process(String s) {
        Stack<String> resStack = new Stack<>();
        Stack<Integer> timeRepeat = new Stack<>();
        int curTimes = 0;
        String res = "";
        int i = 0;
        while(i<s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                while (Character.isDigit(s.charAt(i))) {
                    curTimes += curTimes * 10 + (s.charAt(i++) - '0');
                }
            } else if (s.charAt(i) == '[') {
                resStack.push(res);
                res = "";
                timeRepeat.push(curTimes);
                curTimes = 0;
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeat = timeRepeat.pop();
                for (int j = 0; j < repeat; j++) {
                    temp.append(res);
                }
                res = temp.toString();
                i++;
            } else {
                res += s.charAt(i++);
            }
        }
        System.out.println(res);
    }
}
