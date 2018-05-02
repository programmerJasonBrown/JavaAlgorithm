package yuanjing;

import java.util.HashSet;

public class Probelm1method1 {

    //  随机生成集合
    public static HashSet<Integer> getSet() {
//        存放随机生成的集合
        HashSet<Integer> res = new HashSet<>();
//        集合元素个数SetNum
        int setNum = (int) (Math.random() * 10) + 1;
//        由于集合元素不重复的性质，需要去重
        for (int i = 0; i < setNum; ) {
            int merber = (int) (Math.random() * 10);
            if (!res.contains(merber)) {
                res.add(merber);
                i++;
            }
        }
        return res;
    }

    //获得两集合的交集
    public static HashSet<Integer> getIntersection(HashSet<Integer> setA, HashSet<Integer> setB) {
        HashSet<Integer> res = new HashSet<>();
        res.addAll(setA);
        res.retainAll(setB);
        return res;
    }

    //获得两集合的并集
    public static HashSet<Integer> getUnion(HashSet<Integer> setA, HashSet<Integer> setB) {
        HashSet<Integer> res = new HashSet<>();
        res.addAll(setA);
        res.addAll(setB);
        return res;
    }

    public static void print(HashSet<Integer> set) {
        if (set.isEmpty()){
            System.out.println("Null");
            return;
        }
        for (Integer x : set) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        随机生成集合A
        HashSet<Integer> setA = getSet();
        System.out.print("集合A：");
        print(setA);

//        随机生成集合B
        HashSet<Integer> setB = getSet();
        System.out.print("集合B：");
        print(setB);

//        获得并集
        HashSet<Integer> union = getUnion(setA, setB);
        System.out.print("并集：");
        print(union);

//        获得交集
        HashSet<Integer> intersection = getIntersection(setA, setB);
        System.out.print("交集：");
        print(intersection);

    }

}
