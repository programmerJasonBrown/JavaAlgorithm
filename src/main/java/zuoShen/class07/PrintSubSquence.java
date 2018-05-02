package zuoShen.class07;

public class PrintSubSquence {
    public static void process(String str, int i, String res){
//        i: 当前处理到字符串第几位了
//        res:处理结果
        if (i == str.length()){
            System.out.println(res);
            return;
        }
        process(str,i+1,res);
        process(str,i+1,res+str.charAt(i));
    }

    public static void main(String[] args) {
        String str = "abc";
        String res = "";
        process(str,0,res);
    }
}
