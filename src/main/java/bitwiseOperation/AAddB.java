package bitwiseOperation;

//用为运算实现A+B
public class AAddB {
    public static int add(int a, int b) {
        int carryOverPre = (a & b) << 1;
        int carryOverNow = 0;
        int addWithoutCarryOver = a ^ b;
        while (carryOverPre != 0) {
            //if has carry-over
            //更新无进位的和
            carryOverNow = (carryOverPre & addWithoutCarryOver) << 1;
            addWithoutCarryOver = addWithoutCarryOver ^ carryOverPre;
            carryOverPre = carryOverNow;
            //更新进位
        }
        return addWithoutCarryOver;
    }

    public static void main(String[] args) {
        System.out.println(AAddB.add(111,111));
    }
}
