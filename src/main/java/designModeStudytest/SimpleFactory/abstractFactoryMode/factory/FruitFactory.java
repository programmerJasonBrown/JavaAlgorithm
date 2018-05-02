package designModeStudytest.SimpleFactory.abstractFactoryMode.factory;

import designModeStudytest.SimpleFactory.abstractFactoryMode.product.Fruit;

public interface FruitFactory {
      Fruit getApple();
      Fruit getBanana();
      Fruit getPear();
}
