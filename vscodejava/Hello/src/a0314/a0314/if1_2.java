package a0314;

import java.util.Scanner;

public class if1_2 {
    public static void main(String[] args) {
        int age = 18;
        String status;
        if (age >= 18)
            status = "성인";
        else
            status = "미성년자";

        String a = (age >= 18) ? "성인" : "미성년자";
        System.out.println("age = " + age + " status = " + status);
        System.out.println(a);
    }
}