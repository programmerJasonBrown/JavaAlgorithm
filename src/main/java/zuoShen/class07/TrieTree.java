package zuoShen.class07;

public class TrieTree {
    Node root;

    public static class Node {
        int path;
        int end;
        Node[] next = new Node[26];
    }

    public TrieTree() {
        root = new Node();
    }

    public void insert(String str) {
//        往前缀树中插入字符串
        if (str == null) {
            return;
        }
        Node cur = root;
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            index = str.charAt(i) - 'a';
            if (cur.next[index] != null) {
                cur.next[index].path++;
            } else {
                cur.next[index] = new Node();
                cur.next[index].path++;
            }
            cur = cur.next[index];
        }
        cur.end++;
    }

    public int search(String str) {
//        在前缀树中搜索是否存在字符串str
        if (str == null)
            return 0;
        Node cur = root;
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            index = str.charAt(i) - 'a';
            cur = cur.next[index];
            if (cur == null)
                return 0;
        }
        return cur.end;
    }


    public void delete(String str) {
        if (str == null || search(str) == 0)
            return;

        Node cur = root;
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            index = str.charAt(i) - 'a';
            if (cur.next[index].path == 1) {
                cur.next[index] = null;
                return;
            } else
                cur.next[index].path--;
            cur = cur.next[index];
        }
        cur.end--;
    }

    public int prefixNumber(String pre) {
//        返回以该字符串为前缀的字符串的数量
        if (pre == null)
            return 0;
        int index = 0;
        Node cur = root;
        for (int i = 0; i < pre.length(); i++) {
            index = pre.charAt(i) - 'a';
            if (cur.next[index] == null)
                return 0;
            cur = cur.next[index];
        }
        return cur.path;
    }

    public static void main(String[] args) {
        TrieTree trie = new TrieTree();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");

        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));
    }
}
