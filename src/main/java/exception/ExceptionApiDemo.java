package exception;

/**
 * 异常常用方法
 */
public class ExceptionApiDemo {
    public static void main(String[] args) {
        System.out.println("Start!");
        try {
            String line = "abc";
            System.out.println(Integer.parseInt(line));
        } catch (NumberFormatException e) {
            e.printStackTrace(); // 打印堆栈跟踪(打印错误信息)
            /*
            获取错误信息，一般用于记录日志或提示给用户使用
             */
            String message = e.getMessage(); // 获取错误消息
            System.out.println(message);
        }
        System.out.println("Programmer end!");
    }
}
