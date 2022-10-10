package file;

import java.io.File;

public class FilePractice {
    public static void main(String[] args) {
        File file = new File("./demo.txt");
        String name = file.getName();
        long lo = file.length();
        System.out.println(name);
        System.out.println(lo);
    }
}
