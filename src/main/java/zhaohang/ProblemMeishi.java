package zhaohang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemMeishi {
    //i:dish的下标、list 结果集
    public static boolean process(int n, List<Integer> dish, List<Integer> beforeDish,
                                  int[] beforeDishNum, int i, List<Integer> list, List<Integer> processList) {
        if (processList.contains(beforeDish.get(i)))
//            如果成环了，就直接返回false
            return false;
        if (list.contains(beforeDish.get(i))) {
//          如果当前菜肴未吃，但前置菜肴已吃
            if (beforeDishNum[dish.get(i)] == 1){
//                表示前置菜肴只需要1个
                list.add(dish.get(i));
            }
            else
//                表示前置菜肴需要多个
                beforeDishNum[dish.get(i)]--;
            return true;
        } else {
            processList.add(dish.get(i));
            if (process(n, dish, beforeDish, beforeDishNum, dish.indexOf(beforeDish.get(i)), list, processList)){
//                不成环，表示能吃完，做进一步处理
                processList.remove(dish.get(i));
//                前置菜肴吃完，继续来吃这道菜
                process(n, dish, beforeDish, beforeDishNum, i, list, processList);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        原始美味总数n
        int n = sc.nextInt();
//        前置菜肴范式总数m
        int m = sc.nextInt();
//        第一列待吃菜肴编号，下标无用
        List<Integer> dish = new ArrayList<>();
//        第二列前置菜肴编号，下标无用
        List<Integer> beforeDish = new ArrayList<>();


//        每种菜需要的前置菜个数，下标对应着菜肴标号
        int[] beforeDishNum = new int[n];
        for (int i = 0; i < m; i++) {
            dish.add(sc.nextInt());
            beforeDish.add(sc.nextInt());
            beforeDishNum[dish.get(i)]++;
        }
//        for (int i = 0; i < m; i++) {
////            如果前置菜肴是自己 则不可能吃完
//            if (dish.get(i) == beforeDish.get(i)) {
//                System.out.println("None");
//                return;
//            }
//        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (beforeDishNum[i] == 0) {
//                如果不需要前置菜肴，直接吃，记录到list里
                list.add(i);
            }
        }
//        防止成环
        List<Integer> processList = new ArrayList<>();

//          m个菜肴都是需要前置菜肴的
        for (int i = 0; i < m; i++) {
            if (list.contains(dish.get(i)))
//                如果菜肴已在递归中吃过，则跳过该菜肴
                continue;
            process(n, dish, beforeDish, beforeDishNum, i, list, processList);
        }

//        打印
        if (list.size() == n) {
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i) + ",");
            }
            System.out.print(list.get(list.size() - 1));
        } else
            System.out.println("None");
    }
}
