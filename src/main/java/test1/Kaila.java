package test1;

public class Kaila {

    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        arr[5] = 6;
        int index = 1;
        System.arraycopy(arr, index, arr, index + 1, arr.length - 1 - index);
        System.out.println(arr);
    }
}
