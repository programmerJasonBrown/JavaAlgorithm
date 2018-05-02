package searchProblem.chapter3RedBlackTree;

import searchProblem.Key;
import searchProblem.Value;

public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;
        Value value;
        Node left, right;
        int N;
        boolean color;
        public Node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
        private boolean isRed(Node x){
            if (x == null)
                return false;
            return x.color == RED;
        }
    }



}
