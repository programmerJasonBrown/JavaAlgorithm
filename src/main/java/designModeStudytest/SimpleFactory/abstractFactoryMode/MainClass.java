package designModeStudytest.SimpleFactory.abstractFactoryMode;

import designModeStudytest.SimpleFactory.abstractFactoryMode.factory.FruitFactory;
import designModeStudytest.SimpleFactory.abstractFactoryMode.factory.NorthFruitFatory;
import designModeStudytest.SimpleFactory.abstractFactoryMode.product.Fruit;

public class MainClass {
    public static void main(String[] args) {
        FruitFactory ff = new NorthFruitFatory();
        Fruit northApple = ff.getApple();
        northApple.get();

    }
}
