package a0328.book;

import java.util.ArrayList;
import java.util.Scanner;

import a0317.break1;

public class bookDAO {

    private ArrayList<bookDTO> booklist; // 책 정보를 저장하는 ArrayList
    Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체
    FileClass file = new FileClass("Library", "book"); // 파일 작업을 위한 FileClass 객체

    public bookDAO() {
        // 초기 책 목록 설정
        booklist = new ArrayList<bookDTO>();
        bookDTO b1 = new bookDTO("자바의정석", "남궁성", "12345", 32000);
        bookDTO b2 = new bookDTO("Effective Java", "Joshua Bloch", "54321", 45000);
        bookDTO b3 = new bookDTO("밥", "돼지", "1234", 45000);
        booklist.add(b1); // 첫 번째 책 추가
        booklist.add(b2); // 두 번째 책 추가
        booklist.add(b3); // 세 번째 책 추가
    }

    // 책을 추가하는 메서드
    private void insert(bookDTO b) {
        booklist.add(b); // 책 목록에 책 추가
    }

    // 책을 삭제하는 메서드
    private void delete(int index) {
        booklist.remove(index); // 해당 인덱스의 책 삭제
    }

    // 책을 검색하는 메서드 (인덱스로 책을 반환)
    private bookDTO search(int index) {
        return booklist.get(index); // 해당 인덱스의 책 반환
    }

    // 책 정보를 수정하는 메서드
    private void updata(int index, bookDTO b) {
        booklist.set(index, b); // 해당 인덱스의 책을 수정된 책으로 교체
    }

    // 1번. 책을 추가하는 기능을 사용자에게 제공하는 메서드
    public void bookInsert() {
        bookDTO b = new bookDTO(); // 새로운 bookDTO 객체 생성
        System.out.println("<📚책 추가하기📚>");
        System.out.print("책 제목 : ");
        b.setTitle(sc.next()); // 책 제목 입력
        System.out.print("저자 : ");
        b.setAuthor(sc.next()); // 저자 입력
        System.out.print("ISBN : ");
        b.setISBN(sc.next()); // ISBN 입력
        System.out.print("가격 : ");
        b.setPrice(sc.nextInt()); // 가격 입력
        insert(b); // 입력된 책을 리스트에 추가
        System.out.println("책이 추가되었습니다.");
    }

    // 2번. 책을 삭제하는 기능을 사용자에게 제공하는 메서드
    public void bookDelete() {
        System.out.println("<책 정보 삭제>");
        int index = searchIndex(); // 삭제할 책의 인덱스를 찾기
        if (index == -1) {
            System.out.println("찾는 책이 없습니다.");
        } else {
            String title = booklist.get(index).getISBN(); // 삭제된 책의 ISBN
            delete(index); // 해당 책을 삭제
            System.out.println(title + " 책 정보를 삭제했습니다.");
        }
    }

    // 3. ISBN을 통해 책의 인덱스를 찾는 메서드
    private int searchIndex() {
        int index = -1; // 기본값으로 -1 설정 (찾을 수 없을 경우)
        System.out.println("ISBN을 입력해주세요");
        System.out.print(">> ");
        String ISBN = sc.next(); // 사용자로부터 ISBN 입력 받음
        System.out.println("도서 제목을 입력해주세요");
        System.out.print(">> ");
        String Title = sc.next(); // 사용자로부터 ISBN 입력 받음

        for (int i = 0; i < booklist.size(); i++) {
            // ISBN이 맞는지 확인
            if (booklist.get(i).getISBN().equalsIgnoreCase(ISBN)) {
                // 제목이 맞는지 확인
                if (booklist.get(i).getTitle().equalsIgnoreCase(Title)) {
                    index = i; // 해당 인덱스를 저장
                    break; // 두 조건이 모두 맞으면 루프 종료
                } else {
                    // 제목이 맞지 않으면
                    System.out.println("제목이 없습니다.다시입력해주세요");
                    continue;
                }
            } else {
                // ISBN이 맞지 않으면
                System.out.println("ISBN이 없습니다.다시입력해주세요");
                continue;
            }
        }

        return index; // 찾은 인덱스 반환

    }

    // 책 정보를 검색하는 기능을 사용자에게 제공하는 메서드
    public void bookSearch() {
        System.out.println("<도서 정보 검색>");
        int index = searchIndex(); // 검색할 책의 인덱스를 찾기
        if (index == -1) {
            System.out.println("찾는 도서가 없습니다.");
        } else {
            // 책 정보 출력
            System.out.println("제목\t 저자\t ISBN\t 가격\n" +
                    "--------------------------------\n");
            bookDTO b = search(index); // 책 객체 검색
            System.out.println(b); // 책 정보 출력
        }
    }

    // 책 정보를 수정하는 기능을 사용자에게 제공하는 메서드
    public void bookUpdata() {
        System.out.println("<도서 정보 수정>");
        int index = searchIndex(); // 수정할 책의 인덱스를 찾기
        if (index == -1) {
            System.out.println("찾는 도서가 없습니다.");
        } else {
            // 기존 책 정보 가져오기
            bookDTO b = new bookDTO();
            b.setTitle(booklist.get(index).getTitle());
            b.setAuthor(booklist.get(index).getAuthor());
            b.setISBN(booklist.get(index).getISBN());
            b.setPrice(booklist.get(index).getPrice());
            System.out.println(booklist.get(index).getTitle() + " 도서 정보 수정");
            // 책 정보를 수정
            System.out.print("책 제목 : ");
            b.setTitle(sc.next());
            System.out.print("저자 : ");
            b.setAuthor(sc.next());
            System.out.print("ISBN : ");
            b.setISBN(sc.next());
            System.out.print("가격 : ");
            b.setPrice(sc.nextInt());
            updata(index, b); // 수정된 책 정보로 교체
        }
    }

    // 모든 책 목록을 출력하는 메서드
    public void lookAll() {
        // 책 목록 출력 헤더
        System.out.println("제목\t 저자\t ISBN\t 가격\n" +
                "--------------------------------\n");
        for (int i = 0; i < booklist.size(); i++) {
            // 각 책의 정보를 출력
            System.out.println((booklist.get(i).toString() + "\n"));
        }
    }

    // 책 목록을 파일에 저장하는 메서드
    public void dataSave() throws Exception {
        file.create(); // 파일 생성
        String str = "제목\t 저자\t ISBN\t 가격\n" +
                "--------------------------------\n";
        for (int i = 0; i < booklist.size(); i++) {
            str += booklist.get(i).toString() + "\n"; // 각 책의 정보를 문자열로 변환하여 추가
        }
        file.write(str); // 파일에 저장
    }

    // 파일에서 책 정보를 불러오는 메서드
    public void bookLoad() {
        try {
            file.read(); // 파일에서 데이터 읽기
        } catch (Exception e) {
            System.out.println("읽을 파일이 없습니다.");
        }
    }
}
