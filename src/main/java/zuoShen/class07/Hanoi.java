package zuoShen.class07;

public class Hanoi {
    //    N：表示处理N个数 借助help实现搬移
    public static void process(int N, String from, String to, String help) {
        if (N == 1) {
//            只有一个数的时候
            System.out.println("move 1 form " + from + " to " + to);
        } else {
//          分为三步
//            step1：把上面的N-1个数借助to搬移到help
            process(N - 1, from, help, to);
//            step2：把最下面的数直接搬移到to
            System.out.println("move " + N + " form " + from + " to " + to);
//            step3：把N-1个数从help借助form搬移到to
            process(N - 1, help, to, from);
        }
    }

    public static void main(String[] args) {
        process(3,"左","中","右");
    }


}
