package exception;

/**
 * finally相关面试题
 * 1. 请说明:final, finally, finalize是什么？
 * final：参考克晶老师对于它的笔记
 * finally：参考FinallyDemo的笔记
 * finalize：是定义在Object中的一个方法。该方法是一个对象生命周期中的最后一个方法
 * 当GC发现一个对象没有引用时要将其回收释放资源，在释放器前的最后一刻会调用该方法，
 * 意味着该方法调用完毕后对象即被释放。
 * <p>
 * <p>
 * 2. 如代码所示
 */
public class FinallyDemo3 {
    public static void main(String[] args) {
        System.out.println(
                test("0") + "," + test("") + "," + test(null)
        ); // 3,3,3
        // 如果没有finally代码会返回0,1,2
        /*
        JVM特性，在调用方法时根据返回值类型会生成一个相应临时return变量，用于存储返回值
        在test()中，以test("0")为例，先执行return str.charAt(0) - '0';
        然后得到的return为0，然后赋值给临时的return变量
        然后再执行finally中的return 3;，然后赋值给临时的return变量
        所以最终的返回值为3
         */
    }

    public static int test(String str) {
        try {
            return str.charAt(0) - '0';
        } catch (StringIndexOutOfBoundsException e) {
            return 1;
        } catch (NullPointerException e) {
            return 2;
        } finally {
            return 3;
        }

    }
}
