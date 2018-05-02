package designModeStudytest.SimpleFactory.abstractFactoryMode.factory;

import designModeStudytest.SimpleFactory.abstractFactoryMode.product.Fruit;
import designModeStudytest.SimpleFactory.abstractFactoryMode.product.NorthApple;

public class NorthFruitFatory implements FruitFactory{


    @Override
    public Fruit getApple() {
        return  new NorthApple();
    }

    @Override
    public Fruit getBanana() {
        return null;
    }

    @Override
    public Fruit getPear() {
        return null;
    }
}
