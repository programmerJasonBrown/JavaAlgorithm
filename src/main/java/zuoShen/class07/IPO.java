package zuoShen.class07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static class Node {
        int cost;
        int priority;

        Node(int cost, int priority) {
            this.cost = cost;
            this.priority = priority;
        }
    }

    public static class MinCostCompartor implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }

    public static class MaxPriorityComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.priority - o1.priority;
        }
    }

    public static int findMaximizedCaptital(int k, int w, int[] profits, int[] cost) {
//        k：最多进行的项目数，w初始资金，一次最多执行一个项目
        PriorityQueue<Node> minCostHeap = new PriorityQueue<>(new MinCostCompartor());
        PriorityQueue<Node> maxPriorityHeap = new PriorityQueue<>(new MaxPriorityComparator());
//        先都加入小根堆（按cost大小排序）
        for (int i = 0; i < cost.length; i++) {
            minCostHeap.add(new Node(cost[i], profits[i]));
        }
        for (int i = 0; i < k; i++) {
            while (!minCostHeap.isEmpty()) {
                if (minCostHeap.peek().cost < w)
                    maxPriorityHeap.add(minCostHeap.poll());
            }
            if (!maxPriorityHeap.isEmpty())
                w += maxPriorityHeap.poll().priority;
            else
                break;
        }
        return w;
    }

    public static void main(String[] args) {


    }
}
