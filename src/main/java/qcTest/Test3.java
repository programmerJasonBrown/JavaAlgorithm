package qcTest;

import java.util.Arrays;

public class Test3 {
    static class node{
        int x;

        public node(int x) {
            this.x = x;
        }
    }
    public static void main(String[] args) {
        node[] x =  new node[3];
        x[0] = new node(1);
        x[1] = new node(2);
        x[2] = new node(3);

        node[] b = Arrays.copyOf(x,3);
        b[1]= new node(4);
        System.out.println();

    }
}
