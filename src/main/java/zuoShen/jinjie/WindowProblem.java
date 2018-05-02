package zuoShen.jinjie;

import java.util.LinkedList;

public class WindowProblem {

    public static void windowRightAdd(int[] arr, int index, LinkedList<Integer> queue) {
        while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[index]) {
            queue.pollLast();
        }
        queue.addLast(index);

    }

    public static void windowLeftAdd(int[] arr, int index, LinkedList<Integer> queue) {
        while (!queue.isEmpty() && index == queue.peekFirst()) {
            queue.pollFirst();
        }
    }

    //     返回窗口最大值数组
    public static int[] process(int[] arr, int w) {
        int[] res = new int[arr.length - w + 1]; //记录结果
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            windowRightAdd(arr, i, queue);
            if (i >= w - 1) {
                windowLeftAdd(arr, i - w, queue);
                res[i - w + 1] = arr[queue.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        int[] res = process(arr, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }


}
