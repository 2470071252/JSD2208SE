package exception;

/**
 * 异常抛出
 */
public class ThrowDemo {
    public static void main(String[] args) {
        Person person = new Person();
        // 满足语法不满足业务场景
        try {
            /*
            当我们调用一个含有throws声明异常抛出的方法时，编译器
            要求我们必须写处理方法，否则编译不通过
            处理办法有两种：
            1.可以在当前方法上继续使用throws将异常抛出，永远不要再main()上声明throws
            2.使用try-catch捕获并处理该异常
             */
            person.setAge(10000);
        } catch (IllegelAgeException e) {
            e.printStackTrace();
        }
        System.out.println("此人年龄"+person.getAge()+"岁");

    }
}
