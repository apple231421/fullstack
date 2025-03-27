package a0327.Member;

import java.util.Scanner;

public class Membership {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberMager Mg = new MemberMager();

        while (true) {
            System.out.println("\n===== 회원 관리 프로그램 =====");
            System.out.println("1. 회원 추가");
            System.out.println("2. 회원 검색");
            System.out.println("3. 회원 수정");
            System.out.println("4. 회원 삭제");
            System.out.println("5. 전체 회원 목록 보기");
            System.out.println("6. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    // 회원 추가
                    System.out.println("회원을 추가합니다");

                    System.out.print("이름을 입력해주세요: ");
                    String name = sc.nextLine();

                    System.out.print("나이를 입력해주세요: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // 버퍼 비우기

                    System.out.print("이메일을 입력하세요: ");
                    String email = sc.nextLine();

                    Member newMember = new Member(name, age, email);
                    Mg.addMember(newMember);
                    break;

                case 2:
                    // 회원 검색
                    System.out.println("검색할 회원의 이름을 입력하시오 : ");
                    String searchname = sc.nextLine();
                    Member foundMember = Mg.findMember(searchname);
                    if (foundMember != null) {
                        System.out.println("회원정보 : " + foundMember);
                    } else {
                        System.out.println("등록된 회원이 없습니다.");
                    }
                    break;

                case 3:
                    // 회원 수정
                    System.out.println("수정할 회원의 이름을 입력하세요 : ");
                    String updatename = sc.nextLine();


                    System.out.println("새로운 나이를 입력해주세요: ");
                    int newage = sc.nextInt();
                    sc.nextLine(); // 버퍼 비우기

                    System.out.println("새로운 이메일을 입력하세요: ");
                    String newemail = sc.nextLine();
                    Mg.updateMember(updatename, newage, newemail);
                    break;

                case 4:
                    // 회원 삭제
                    System.out.println("회원 삭제 시작");
                    System.out.print("삭제하려는 회원 이름을 입력하세요: ");
                    String dname = sc.nextLine();
                    Mg.deMember(dname); // 회원 삭제 메서드 호출
                    break;

                case 5:
                    // 회원 목록 출력
                    System.out.println("회원 목록:");
                    Mg.displayAllMembers();
                    break;

                case 6:
                    // 종료
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                    break;
            }
        }
    }
}
