package designModeStudytest.SimpleFactory;

public class FruitFactory {
    public static Fruit getFruit(String arg) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        Class fruitClass = Class.forName(arg);
        return (Fruit) fruitClass.newInstance();
    }
}
