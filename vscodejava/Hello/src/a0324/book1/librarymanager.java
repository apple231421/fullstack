package a0324.book1;

import java.util.ArrayList;

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

    // 1번 도서 대출하기
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

    // 2번 대출 가능여부
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

    // 3번 도서추가한거를 보관
    public void addlibrary(String newtitle, String newAuthor, String newlocation, String newIsbn) {
        librarys.add(new library(newtitle, newAuthor, newlocation, newIsbn));
    }

}
