package a0324.book1;

import java.util.ArrayList;
import java.util.Scanner;

import a0317.break1;

public class librarymanager {
    private ArrayList<library> librarys; // library를 객체를 리스트(묶음으로 저장할 수 있는 배열종류)
    private ArrayList<library> booklocation; // library를 객체중 대여한 객체를 저장하는 리스트

    public librarymanager() {
        librarys = new ArrayList<>(); // 전체 책
        booklocation = new ArrayList<>(); // 대출한 목록리스트
        librarys.add(new library("this is java", "shin", "Section A", "979-11-691-229-8"));
        librarys.add(new library("First Encounter with React", "Lee", "Section B", "979-11-6921-169-7"));
        librarys.add(new library("The Principles of Web Standards", "Ko", "Section C", "979-11-6303-622-7"));
    }

    // 2번 도서 대출하기
    public void alllibrary() {
        System.out.println("대출 가능한 도서보기");
        for (library library : librarys) {
            if (library.isAvailable()) {
                System.out.println(library);
            }
        }

        // for (int i = 0; i < librarys.size(); i++) {
        // library library = librarys.get(i);
        // if (library.isAvailable()) {
        // System.out.println(library);
        // }
        // }
    }

    // 3번 대출 가능여부
    public boolean booklocations(String libraryname) {
        for (library library : librarys) {
            if (library.getTitle().equalsIgnoreCase(libraryname) && library.isAvailable()) {
                library.book(); // 대출 불가능 Available에 = false 넣어주는 메서드
                booklocation.add(library); // 대출한 도서를 booklocation 리스트에 추가
                return true;
            }
        }
        return false;
    }

    // 대출 목록 보관
    public void booklocation() {
        for (library borrowbook : booklocation) {
            System.out.println(borrowbook);
        }
    }

    // 4번 도서추가한거를 보관
    public void addlibrary(String newtitle, String newAuthor, String newlocation, String newIsbn) {
        librarys.add(new library(newtitle, newAuthor, newlocation, newIsbn));
    }

    // 5번 도서 삭제
    public void delibrary(String dname) {
        boolean result = false;
        for (library library : librarys) {
            if (library.getTitle().equalsIgnoreCase(dname)) {
                if (library.isAvailable()) { // 대여중이 아닐때(대여가능할때)
                    librarys.remove(library);
                    result = true;
                    break;
                } else {
                    result = false;
                    break;
                }
            }
        }
        if (result) {
            System.out.println("삭제됨");
        } else {
            System.out.println("삭제안됨");
        }
    }

    // 6번 도서 정보 수정
    public void updatelibrary(String uname) {
        int index = -1;
        int menu = -1;
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        library newa = new library(); // 빈 라이브러리 객체를 하나 만든다
        System.out.println(uname);

        for (int i = 0; i < librarys.size(); i++) {
            library a = librarys.get(i);
            if (a.getTitle().equals(uname)) {
                index = i;
                newa = a;
            }
        }

        if (index != -1) {
            while (flag) {
                System.out.println("뭘 수정할건데?");
                System.out.println("1.도서 이름 \t 2.도서 저자 \t 3.도서 위치 \t 4.도서ISBN");
                System.out.print(">> ");
                menu = sc.nextInt();
                sc.nextLine();

                switch (menu) {
                    case 1:
                        System.out.println("수정할 도서 이름을 적으세요");
                        newa.setTitle(sc.nextLine());
                        librarys.set(index, newa);
                        flag = false;
                        break;
                    case 2:
                        System.out.println("수정할 도서 저자를 적으세요");
                        newa.setAuthor(sc.nextLine());
                        librarys.set(index, newa);
                        flag = false;
                        break;
                    case 3:
                        System.out.println("수정할 도서 위치를 적으세요");
                        newa.setLocation(sc.nextLine());
                        librarys.set(index, newa);
                        flag = false;
                        break;
                    case 4:
                        System.out.println("수정할 도서 ISBN을 적으세요");
                        newa.setIsbn(sc.nextLine());
                        librarys.set(index, newa);
                        flag = false;
                        break;
                    default:
                        System.out.println("잘못된 번호입니다. 다시입력해주세요");
                        break;
                }
            }
        } else {
            System.out.println("해당 도서를 찾을 수 없습니다.");
        }
    }

    // 7번
    public void showlibrary(String sname) {
        for (library a : librarys) {
            if (a.getTitle().equalsIgnoreCase(sname)) {
                System.out.println(a.toString());
            }
        }
    }




    
}
