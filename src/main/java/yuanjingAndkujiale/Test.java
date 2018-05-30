package yuanjingAndkujiale;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("staff.txt");
        if (file.exists())
            file.delete();
        while (true) {
            String command = scanner.nextLine();
//      按空格切分输入 splits[0]为命令类型
            String[] splits = command.split("\\s+");
            if (splits[0].equals("input"))
                System.out.println(inputUser(splits));
            else if (splits[0].equals("list")) {
                List<String> strings = listUser(splits); // 列出最近n条数据；
                for (String x : strings) { //将得到的每条数据打出
                    System.out.println(x);
                }
            } else if (splits[0].equals("del"))
                System.out.println(delUser(splits));
            else
                System.out.println("输入错误，请重新输入！");
        }
    }

    public static String inputUser(String[] splits) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String record = ++count + "_" + splits[1] + "_" + splits[2] + "_" + splits[3]
                + "_" + df.format(System.currentTimeMillis());
        inputUser(record.trim(), true);
        return record;
    }

    public static List<String> listUser(String[] splits) {
        List<String> list = new ArrayList<>();//将n条记录add到list
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("staff.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < Math.min(Integer.parseInt(splits[2]), count); i++) {
            list.add(scanner.nextLine());
        }
        scanner.close();
        return list;
    }

    private static void inputUser(String string, boolean isAdd) {
//        需要输入到文件的字符串，是否追加到文件末尾，false表示新建一个文件在输入数据，true表示在原文件末尾追加
        FileWriter writer = null;
        try {
            writer = new FileWriter("staff.txt", isAdd);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(string + "\r\n");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String delUser(String[] splits) {
//        成功返回成功，失败返回原因。
//        原因可以分为文件中没有对应用户，或者用户的某个数据错误等等，最后以中文字符串返回就行
        String res = "找不到该用户！";
        String[] strings = {"list", " -n ", String.valueOf(3)};
        List<String> lists = listUser(strings);
        for (String x : lists) {
            String[] split = x.split("_");
            if (Integer.parseInt(split[0]) == Integer.parseInt(splits[1])) {
                lists.remove(x);
                res = "成功！";
                count--;
                break;
            }
        }
        for (int i = 0; i < lists.size(); i++) {
            if (i == 0)
                inputUser(lists.get(i), false);
            else
                inputUser(lists.get(i), true);
        }

        return res;
    }

}
