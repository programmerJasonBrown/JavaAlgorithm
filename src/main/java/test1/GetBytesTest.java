package test1;

public class GetBytesTest {
    public static void main(String[] args) {
        String s = "1234";
        byte[] bs = s.getBytes();
        String ss = new String(bs);
        System.out.println(ss);
        byte b = 0x12;
        for (int i = 0; i < 4; i++) {
            int j = Integer.parseInt(String.valueOf(b));
            //System.out.format("%x ",b);
            System.out.println(String.valueOf(j));
        }

    }
}
