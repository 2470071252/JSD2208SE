package exception;

/**
 * 自定义异常
 * 通常用来说明那些满足语法但是不满足业务场景的异常问题
 * 自定义异常通常要做到以下几点：
 * 1.类名要做到见名知意
 * 2.继承自Exception(直接或间接)
 * 3.提供超类异常提供的所有构造器
 */
public class IllegelAgeException extends Exception {
    public IllegelAgeException() {
    }

    public IllegelAgeException(String message) {
        super(message);
    }

    public IllegelAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegelAgeException(Throwable cause) {
        super(cause);
    }

    public IllegelAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
