package a0403.stream;

import java.util.ArrayList;
import java.util.List;

public class Stream8 {
    public static void main(String[] args) {
        // Create a list of Members
        List<Member> list = new ArrayList<>();
        Member m1 = new Member("박태호", Member.MALE, 30);
        Member m2 = new Member("김연경", Member.FEMALE, 29);
        Member m3 = new Member("손유일", Member.MALE, 32);
        Member m4 = new Member("안재홍", Member.MALE, 27);
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);

        int count = 0;
        double sum = 0;
        double ageAvg1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getGender() == Member.MALE) {
                sum = sum + list.get(i).getAge();
                count++;
            }
        }
        ageAvg1 = sum / count;
        System.out.println("남성 평균 나이 : " + ageAvg1);
        // 내부반복자

        double ageAvg = list.stream()
        .filter(m -> m.getGender() == Member.MALE)
        .mapToInt(Member::getAge)
        .average()
        .getAsDouble();
        System.out.println("남자 회원의 평균 나이 : " +ageAvg);
    }
}
