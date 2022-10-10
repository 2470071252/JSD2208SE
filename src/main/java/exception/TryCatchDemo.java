package exception;

/**
 * java异常处理机制
 * java中所有的异常的顶级超类：Throwable
 * Throwable下面派生了两个子类型：Error Exception
 * Error是描述系统错误的，是不可能被处理的，一旦出现Error意味着程序会结束
 * Exception描述的是程序异常，是可以被捕获处理的
 * <p>
 * 异常处理机制中：try-catch
 * 语法：
 * try{
 * 可能出现异常的代码片段
 * }catch(XXXException e){
 * 当try中出现XXXException后解决代码
 * }
 * <p>
 * 注：try语句块不能单独是有，后面要么跟catch语句块，要么跟finally语句块
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序执行！");
        try {
//            String line = null;
//            String line = "";
            String line = "abc";
            System.out.println(line.length());
            System.out.println(line.charAt(0));
            System.out.println(Integer.parseInt(line)); // NumberFormatException
        /*
        }catch (NullPointerException e){
            System.out.println("出现了空指针异常需要处理！！");
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("出现了字符串下标越界异常需要进行处理！！");
        }
        */
            // 当多个异常使用同一种解决办法时，可以合并在一个catch处理(JDK1.7+特性)
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {
            System.out.println("空指针或字符串下标越界异常的统一处理！");
        } catch (Exception e){
            System.out.println("反正就是出了个错！");
        }
        System.out.println("程序结束了");
    }
}
