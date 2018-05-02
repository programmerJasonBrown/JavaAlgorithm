package Huawei.xlei;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rest = scanner.nextInt();
        scanner.nextLine();
        String secondLine = scanner.nextLine();
        String[] strings = secondLine.split("\\s+");
        int appNum = strings.length;
        int[] apps = new int[appNum];
        for (int i = 0; i < appNum; i++) {
            apps[i] = Integer.valueOf(strings[i]);
        }
        int[] values = new int[appNum];
        for (int i = 0; i < appNum; i++) {
            values[i] = scanner.nextInt();
        }
        int mycc[] = new int[rest + 1];
        StringBuilder[] stringBuilder = new StringBuilder[rest + 1];
        for (int i = 0; i < rest + 1; i++) {
            stringBuilder[i] = new StringBuilder("");
        }

        for (int i = 0; i < appNum; i++) { //3
            for (int j = rest; j >= apps[i]; j--) {
                if (mycc[j] < mycc[j - apps[i]] + values[i]) {
                    mycc[j] = mycc[j - apps[i]] + values[i];
                    stringBuilder[j] = new StringBuilder("").append(stringBuilder[j - apps[i]]).append(String.valueOf(i)).append(" ");
                }
            }
        }


        String lastchoose = stringBuilder[rest].toString();
        String[] split = lastchoose.split("\\s+");
        for (int i = 0; i < split.length ; i++) {
            System.out.print(Integer.valueOf(split[i])+1);
            if (i != split.length-1)
                System.out.print(" ");
        }

    }
}
