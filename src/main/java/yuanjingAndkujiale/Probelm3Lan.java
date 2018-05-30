package yuanjingAndkujiale;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Probelm3Lan {
    static class MyMinCompartor implements Comparator<Node> {
//        按名次大小比较的比较器
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.parseInt(o1.rank) - Integer.parseInt(o2.rank);
        }
    }

    static class Node {
        //姓名, 名次，学号，年龄
        String name;
        String rank;
        String id;
        String age;
        Node(String name, String rank, String id, String age) {
            this.name = name;
            this.rank = rank;
            this.id = id;
            this.age = age;
        }
    }

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new File("a.txt"));
            String s = scanner.nextLine();//  从文件a.txt中读取一行数据


            ArrayList<Node> lists = new ArrayList<>();
            while (scanner.hasNextLine()) {
//               扫描文件，将所有成员都封装到Node类中，并添加到List
                String line = scanner.nextLine();
                String[] strings = line.split(",");
                lists.add(new Node(strings[3], strings[0], strings[1], strings[2]));
            }
//            问题1
            process1(lists);
//            问题2
            process2(lists);

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //打印出名次列和姓名列，把其它列过滤掉，保存到新文件b.csv。
    public static void process1(ArrayList<Node> lists) throws IOException {
        FileWriter writer = new FileWriter("b.csv");
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("内容" + "\r\n");

        bw.close();
    }


    //请把姓名列调换到第1列，并按名次排序，保存到新文件c.csv。
    public static void process2(ArrayList<Node> lists) throws IOException {
        FileWriter writer = new FileWriter("c.csv");
        BufferedWriter bw = new BufferedWriter(writer);
//      按名次排序
        lists.sort(new MyMinCompartor());
        for (Node x : lists) {
//      保存到新文件c.csv
            bw.write(x.name + "," + x.rank + "," + x.id + "," + x.age + "\r\n");
        }
        bw.close();
    }
}
