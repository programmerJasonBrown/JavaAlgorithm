package lintCodeProblem.convertStringToInt.num134LRUCache;

/*
* 为最近最少使用（LRU）缓存策略设计一个数据结构，它应该支持以下操作：
* 获取数据（get）和写入数据（set）。

获取数据get(key)：如果缓存中存在key，则获取其数据值（通常是正数），否则返回-1。

写入数据set(key, value)：如果key还没有在缓存中，则写入其数据值。当缓存达到上限，
它应该在写入新数据之前删除最近最少使用的数据用来腾出空闲位置。
*
*
* */
public class LRUCache {
    /*
     * @param capacity: An integer
     */
    private class Node {
        private int key;
        private int value;
        Node next;
    }

    private Node head;
    private int capacity;
    private int length;
    public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        head = new Node();
        head.next = null;
        length = 0;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (head.next == null)
            return -1;
        Node temp = head.next;
        Node temppre = head;
        while (temp != null) {
            if (temp.key == key) {
                temppre.next = temp.next;
                temp.next = head.next;
                head.next = temp;
                return temp.value;
            }
            temppre = temp;
            temp = temp.next;
        }
        return -1;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (get(key)!=-1){
            head.next.value = value;
            return;
        }
        Node node = new Node();
        node.key = key;
        node.value = value;
        if (length >= capacity) {
            //删除链表末尾的数据
            Node temp = head;
            //这里没有考虑容量只有1的情况
            while(temp.next.next!=null){
                temp = temp.next;
            }
            temp.next = null;
            length --;
        }
        node.next = head.next;
        head.next = node;
        length++;

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2,1);
        lruCache.set(1, 1);
        System.out.println(lruCache.get(2));
        lruCache.set(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
