package javaTestClassReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassReflectTest {

    public static void main(String[] args) {
        String className = "javaTestClassReflect.Worker";
        Class clazz1 = null;
        try {
            clazz1 = Class.forName(className);
            /*反射不带参数的构造函数*/
            Object object1 = clazz1.newInstance();
            System.out.println("object1.toString() " + object1.toString());

            /*反射单参数的构造函数*/
            Constructor constructor = clazz1.getConstructor(int.class, String.class);
            Object object2 = constructor.newInstance(22, "Brown");
            System.out.println("object2.toString() " + object2.toString());

            Method method = clazz1.getMethod("toString");
            System.out.println(method.invoke(object1));
            System.out.println(method.invoke(object2));
            Method method2 = clazz1.getMethod("setName", String.class);
            method2.invoke(object1, "qc");
            System.out.println(method.invoke(object1));


            Field ageField = clazz1.getDeclaredField("age");
            System.out.println("ageField: " + ageField);
            /*获取和更改某个对象的私有字段，即模拟get set方法*/
//            取消访问私有字段的合法性检查
            ageField.setAccessible(true);
//            获取对象的私有字段
            Object ageObject = ageField.get(object1);
            System.out.println("ageObject: " + ageObject);
            ageField.set(object1,23);
            System.out.println("没有重新获取对象字段：ageObject: " + ageObject);
//            重新获取对象字段
            Object ageObject2 = ageField.get(object1);
            System.out.println("重新获取对象字段：ageObject2: " + ageObject2);




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
