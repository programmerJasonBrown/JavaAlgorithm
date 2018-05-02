package aiQiyi;

import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer();
        char max = s.charAt(s.length() - 1);
        for (int i = s.length() - 1; i >= 0; i--) {
          if (max <= s.charAt(i)){
              max = s.charAt(i);
              stringBuffer.append(max);
          }
        }

        for (int i = stringBuffer.length() -1; i >= 0; i--) {
            System.out.print(stringBuffer.charAt(i));
        }
    }
}
