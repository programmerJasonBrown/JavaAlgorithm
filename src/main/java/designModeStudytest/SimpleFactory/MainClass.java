package designModeStudytest.SimpleFactory;

public class MainClass {
    public static void main(String[] args) {
        try {
            Fruit apple = FruitFactory.getFruit("designModeStudytest.SimpleFactory.Apple");
            Fruit banana = FruitFactory.getFruit("designModeStudytest.SimpleFactory.Banana");
            apple.get();
            banana.get();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
