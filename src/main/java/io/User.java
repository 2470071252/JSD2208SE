package io;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String nicknam;
    private int age;

    public User(String username, String password, String nicknam, int age) {
        this.username = username;
        this.password = password;
        this.nicknam = nicknam;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNicknam() {
        return nicknam;
    }

    public void setNicknam(String nicknam) {
        this.nicknam = nicknam;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nicknam='" + nicknam + '\'' +
                ", age=" + age +
                '}';
    }
}
