package wangyi;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GotoCompany {

    public static class MyMinCompartor implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static int getShortestTime(int taxiNumber, int[] taxiXCoordinate, int[] taxiYCoordinate,
                                      int officeX, int officeY, int walkTime, int taxiTime) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new MyMinCompartor());
        for (int i = 0; i < taxiNumber; i++) {
            int sumTime = taxiTime * (Math.abs(officeX - taxiXCoordinate[i]) +
                    Math.abs(officeY - taxiYCoordinate[i]));

            sumTime += walkTime * (Math.abs(taxiXCoordinate[i]) + Math.abs(taxiYCoordinate[i]));

            pq.add(sumTime);
        }
        int walkSumTime = walkTime * (Math.abs(officeX) + Math.abs(officeY));

        return pq.peek() < walkSumTime ? pq.peek() : walkSumTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("周围打车点数");
        int taxiNumber = sc.nextInt();
        System.out.println("打车点横坐标");
        int[] taxiXCoordinate = new int[taxiNumber];
        for (int i = 0; i < taxiNumber; i++) {
            taxiXCoordinate[i] = sc.nextInt();
        }
        System.out.println("打车点纵坐标");
        int[] taxiYCoordinate = new int[taxiNumber];
        for (int i = 0; i < taxiNumber; i++) {
            taxiYCoordinate[i] = sc.nextInt();
        }
        System.out.println("办公室坐标");
        int officeX = sc.nextInt();
        int officeY = sc.nextInt();
        System.out.println("移动一条街走路时间");
        int walkTime = sc.nextInt();
        System.out.println("移动一条街坐车时间");
        int taxiTime = sc.nextInt();

        System.out.println(getShortestTime(taxiNumber,taxiXCoordinate,
                taxiYCoordinate,officeX,officeY,walkTime,taxiTime));

    }
}
