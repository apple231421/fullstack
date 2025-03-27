package a0327.Member;

import java.util.ArrayList;

public class MemberMager {
    private ArrayList<Member> members;

    public MemberMager() {
        members = new ArrayList<>(); // 회원 전체 목록
    }

    // 1번: 회원 추가
    public void addMember(Member newMember) {
        members.add(newMember);
    }

    // 2번: 회원 검색
    public Member findMember(String name) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null; // 회원이 없으면 null 반환
    }

    // 3번: 회원 정보 수정
    public void updateMember(String updateName, int newAge, String newEmail) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getName().equals(updateName)) {
                members.set(i, new Member(updateName, newAge, newEmail));
                return;
            }
        }
        System.out.println("회원을 찾을수 없습니다.");
    }

    // if (member != null) {
    // // 회원 정보 수정
    // member.setName(newname);
    // member.setAge(newage);
    // member.setEmail(newemail);
    // System.out.println("회원 정보가 수정되었습니다.");
    // } else {
    // System.out.println("회원을 찾을 수 없습니다.");
    // }

    // 4번: 회원 삭제
    public void deMember(String name) {
        Member member = findMember(name);

        if (member != null) {
            members.remove(member); // 회원 목록에서 해당 회원 삭제
            System.out.println("회원 " + name + "가 삭제되었습니다.");
        } else {
            System.out.println("삭제할 회원을 찾을 수 없습니다.");
        }
    }

    // 5번: 전체 회원 목록 출력
    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("등록된 회원이 없습니다.");
        } else {
            System.out.println("==== 등록된 회원 목록 ====");
            for (Member m : members) {
                System.out.println(m.toString());
            }
        }
    }
}
