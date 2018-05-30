package yuanjingAndkujiale;

public class problem2Method2 {

//    测试方法
    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        char[] res = process(chars, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static char[] process(char[] chars, int n) {
//        辅助空间O(N)，N：chars 数组长度
//        时间复杂度O（N），N：chars数组长度
        char[] res = new char[chars.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = chars[(i + n) % res.length];
        }
        return res;
    }

}
