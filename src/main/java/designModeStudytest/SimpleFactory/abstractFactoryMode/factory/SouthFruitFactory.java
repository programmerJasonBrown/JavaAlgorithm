package designModeStudytest.SimpleFactory.abstractFactoryMode.factory;

import designModeStudytest.SimpleFactory.abstractFactoryMode.product.Fruit;
import designModeStudytest.SimpleFactory.abstractFactoryMode.product.SouthApple;

public class SouthFruitFactory implements FruitFactory {

    @Override
    public Fruit getApple() {
        return new SouthApple();
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

