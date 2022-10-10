package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * 设计一个User类，表示用户信息
 * 有4个属性：username password nickname age
 * age为int 其他未String
 *
 * 程序启动后，要求用户在控制台上陆续输入用户名,密码，昵称，年龄
 * 然后将该用户信息以一个User对象形式序列化到文件中
 * 文件名格式：用户名.obj
 *
 */
public class Test5 {
    public static void main(String[] args) throws IOException {
        String username;
        String password;
        String nickname;
        int age ;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名：");
        username = scanner.nextLine();
        System.out.println("请输入密码：");
        password = scanner.nextLine();
        System.out.println("请输入昵称：");
        nickname = scanner.nextLine();
        System.out.println("请输入年龄：");
        age = scanner.nextInt();

        User user = new User(username,password,nickname,age);

        FileOutputStream fos = new FileOutputStream(username + ".obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(user);
        System.out.println("对象序列化完毕！");
        oos.close();

    }
}
