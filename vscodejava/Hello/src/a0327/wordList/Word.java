package a0327.wordList;

import java.util.Scanner;

public class Word {
    public static void main(String[] args) {
        Brain book = new Brain();
        while (true) {
            book.Menu();
            Scanner sc = new Scanner(System.in);
            String select = sc.nextLine();
            if (select.equals("1")) {
                book.AddWord();
            } else if (select.equals("2")) {
                book.WordSearch();
            } else if (select.equals("3")) {
                book.DeleteWord();
            } else if (select.equals("4")) {
                book.Test();
            } else if (select.equals("5")) {
                book.wordList();
            } else if (select.equals("6")) {
                book.Exit();
                break;
            } else {
                System.out.println("1~6 사이의 숫자만을 입력해주세요");
            }

        }
    }
}
