package io;

import java.io.*;

/**
 * 对象流
 * java.io.ObjectOutputStream和ObjectInputStream
 */
public class OOSDemo {
    public static void main(String[] args) throws IOException {
        // 将一个Person对象写入文件person.obj
        String name = "刘桑";
        int age = 55;
        String gender = "男";
        String[] otherInfo = {"技术好","拍片好","大家的启蒙老师"};
        Person person = new Person(name, age, gender, otherInfo);

        FileOutputStream fos = new FileOutputStream("person.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // 在序列化对象之前，需要序列化的类必须实现Serializable接口
        oos.writeObject(person);
        System.out.println("对象写出完毕");
        oos.close();
    }
}
