package javaTestClassReflect;

public class Worker {
    private int age;
    private String name;
    public Worker(){
        age = 24;
        name = "Jason";
    }
    public Worker(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
