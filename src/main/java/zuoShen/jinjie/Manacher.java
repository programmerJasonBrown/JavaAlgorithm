package zuoShen.jinjie;

public class Manacher {
    public static int countSubstrings(String s) {
        String rs = "#";
        for(int c=0; c<s.length(); c++){
            rs = rs + s.charAt(c) + "#";
        }    //改造字符串

        int[] p = new int[rs.length()]; //初始化辅助数组
        int mid = 0;
        int maxLen = 0; //初始中心为第一个字符，半径为0
        for(int i=0;i<rs.length();i++){
            if(i < maxLen) p[i] = Math.min(p[2*mid-i], maxLen);
            else p[i] = 1;
            while(i-p[i]>=0 && i+p[i]<rs.length() && rs.charAt(i-p[i])==rs.charAt(i+p[i])){
                p[i]++;
            }
            if(i+p[i] > maxLen){
                mid = i;
                maxLen = i + p[i];
            }  // 当以第i个字符为中心的回文字符串的最右字符在maxLen右边，更新中心和半径
        }

        int max = p[0];
        for(int i=0;i<p.length;i++){
            System.out.println(p[i]);
            //max = Math.max(max, p[i]);
        } //寻找最大值

        return max-1; // 原回文字符串长度等于数组p中元素减一
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("ABA"));
    }
}
