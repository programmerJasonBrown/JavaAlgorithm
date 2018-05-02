package yuanjing;

public class Problem1Method2 {

    //  随机生成集合
    public static boolean[] getSet() {
        //存放随机生成的集合
        boolean[] set = new boolean[10];
//        集合元素个数SetNum
        int setNum = (int) (Math.random() * 10) + 1;

//       由于集合元素不重复的性质，需要去重，对应小标为true，表示集合中有值等于下标的元素
        for (int i = 0; i < setNum; ) {
            int merber = (int) (Math.random() * 10);
            if (set[merber] == false) {
                set[merber] = true;
                i++;
            }
        }
        return set;
    }

    //获得两集合的交集
    public static boolean[] getIntersection(boolean[] setA, boolean[] setB) {
        boolean[] res = new boolean[setA.length];
        for (int i = 0; i < res.length; i++) {
            if (setA[i] && setB[i])
//                setA和setB都拥有元素i
                res[i] = true;
        }
        return res;
    }

    //获得两集合的并集
    public static boolean[] getUnion(boolean[] setA, boolean[] setB) {
        boolean[] res = new boolean[setA.length];
        for (int i = 0; i < res.length; i++) {
            if (setA[i] || setB[i])
//                setA或setB都拥有元素i
                res[i] = true;
        }
        return res;
    }

    public static void print(boolean[] set) {
        boolean isSetEmpty = true;
        for (int i = 0; i < set.length; i++) {
            if (set[i]) {
                System.out.print(i + " ");
                isSetEmpty = false;
            }
        }
        if (isSetEmpty)
            System.out.println("Null");
        else
            System.out.println();
    }

//    测试方法
    public static void main(String[] args) {
        //        随机生成集合A
        boolean[] setA = getSet();
        System.out.print("集合A：");
        print(setA);

//        随机生成集合B
        boolean[] setB = getSet();
        System.out.print("集合B：");
        print(setB);

//        获得并集
        boolean[] union = getUnion(setA, setB);
        System.out.print("并集：");
        print(union);

//        获得交集
        boolean[] intersection = getIntersection(setA, setB);
        System.out.print("交集：");
        print(intersection);
    }
}
