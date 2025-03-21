package a0321.bank;

import java.util.Scanner;

public class bookapp {

    private static book[] bookArray = new book[100]; // bookArray 책들의 정보를 저장
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            System.out.println("------------------------------------------------------------");
            System.out.println("1.책 추가 | 2.책 목록 조회 | 3.책 대출 | 4.책 반납 | 5.종료");
            System.out.println("------------------------------------------------------------");
            System.out.print("선택>");
            int selnumber = Integer.parseInt(sc.nextLine()); // 번호를

            if (selnumber == 1) {
                addbook(); // 책 추가
            } else if (selnumber == 2) {
                listbooks(); // 책 목록 조회
            } else if (selnumber == 3) {
                borrowbook(); // 책 대출
            } else if (selnumber == 4) {
                returnbook(); // 책 반납
            } else if (selnumber == 5) {
                run = false; // 종료
            } else {
                System.out.println("잘못된 번호입니다 다시입력해주세요");
            }

        }
        System.out.println("프로그램을 종료합니다");
    }

    // 책 찾는거
    private static book findbook(String title) {
        for (int i = 0; i < bookArray.length; i++) {
            book book = bookArray[i];
            if (book != null && book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    // 책추가
    private static void addbook() {
        System.out.println("============================================================");
        System.out.println("                          책 추가");
        System.out.println("============================================================");

        System.out.print("책 제목 : ");
        String title = sc.nextLine();

        if (findbook(title) != null) {
            System.out.println("이미 존재하는 책입니다.");
            return;
        }

        System.out.print("저자 : ");
        String author = sc.nextLine();

        System.out.print("대출 가능 여부 (0: 가능, 1: 대출 중) : ");
        int status = Integer.parseInt(sc.nextLine());
        if (status != 0 && status != 1) {
            System.out.println("(0 또는 1) 번호를 다시 입력해주세요");
            return;
        }

        book newbook = new book(title, author, status);
        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i] == null) {
                bookArray[i] = newbook;
                System.out.println("책이 추가되었습니다.");
                break;
            }
        }
    }

    // 책 목록 조회
    private static void listbooks() {
        System.out.println("============================================================");
        System.out.println("                       |책 목록 조회|");
        System.out.println("============================================================");
        System.out.println("  제목                     저자                 대출여부");
        System.out.println("============================================================");

        for (book book : bookArray) {
            if (book != null) {
                System.out.println("   "+book.getTitle() + "                     " + book.getAuthor() + "          "
                        + (book.getStatus() == 0 ? "       대출 가능\n"
                                : "       대출 중\n"
                                        + "============================================================"));
            }
        }
    }

    // 책 대출
    private static void borrowbook() {
        System.out.print("대출할 책 제목: ");
        String title = sc.nextLine();
        book book = findbook(title);

        if (book == null) {
            System.out.println("책 이름을 입력해주세요");
        } else if (book.getStatus() == 1) {
            System.out.println("이미 대출 중인 책입니다");
        } else {
            book.setStatus(1);
            System.out.println("책이 대출되었습니다");
        }
    }

    // 책 반납
    private static void returnbook() {
        System.out.print("반납할 책 제목: ");
        String title = sc.nextLine();
        book book = findbook(title);

        if (book == null) {
            System.out.println("책 이름을 입력해주세요");
        } else if (book.getStatus() == 0) {
            System.out.println("이미 반납된 책입니다.");
        } else {
            book.setStatus(0);
            System.out.println("책이 반납되었습니다.");
        }
    }
}
