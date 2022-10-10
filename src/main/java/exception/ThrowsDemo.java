package exception;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 子类重写超类含有throws声明异常抛出的方法时，对throws的重写规则
 */
public class ThrowsDemo {
    public void dosome()throws IOException, AWTException{}
}

class SubClass extends ThrowsDemo{
    // public void dosome() throws IOException, AWTException { }

    // 允许子类方法仅抛出异常超类
    // public void dosome() throws IOException{}

    // 允许不在抛出任何异常
    // public void dosome(){}

    // 允许抛出超类方法抛出异常的子类型异常
    //  FileNotFoundException extends IOException
    // public void dosome() throws FileNotFoundException { }

    // ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    // 不允许抛出额外异常(超类方法没有声明抛出，且声明抛出的异常灭有继承关系)
    // public void dosome() throws SQLException{}

    // 不允许抛出超类方法抛出异常的超类型异常
    // public void dosome() throws Exception {}
}
