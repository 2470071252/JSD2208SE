package reflect;

/**
 * 使用当前测试类
 */
public class Person {
    private String name = "zhangsan";
    private int age = 22;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void sayHello() {
        System.out.println(name + "Hello!");
    }

    public void sayHi() {
        System.out.println(name + "Hi!");
    }

    public void say(String info) {
        System.out.println(name + ":" + info);
    }

    public void say(String info, int count) {
        for ( int i = 0; i < count; i++ ) {
            System.out.println(name + ":" + info);
        }
    }
    public void watchTV(){
        System.out.println(name+"看电视");
    }

    public void palyGame(){
        System.out.println(name+"打游戏");
    }

    public void justDoIt(){
        System.out.println(name+"只管干！");
    }

    public void  eat(){
        System.out.println(name+"干饭！");
    }

    public void sleep(){
        System.out.println(name+"睡觉");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
