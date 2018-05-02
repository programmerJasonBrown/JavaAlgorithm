package lintCodeProblem.convertStringToInt.num40MinWindow;

public class MinWindow {
    public String minWindow(String source, String target) {
        if (source.length() < target.length())
            return "";
        for (int i = target.length(); i <= source.length(); i++) {
            for (int j = 0; j <= source.length() - i; j++) {
                String s = source.substring(j, j + i);
                StringBuilder sb = new StringBuilder(s);
                int count = 0;
                for (int k = 0; k < target.length(); k++) {
                    if (sb.indexOf(target.charAt(k) + "") != -1) {   //sb中存在target[k]
                        sb.deleteCharAt(sb.indexOf(target.charAt(k)+""));
                        count++;
                    } else
                        break;   //只要一个找不到 那这个子串肯定就不符合了。
                }
                if (count == target.length())
                    return s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("abc","abc"));
    }
}
