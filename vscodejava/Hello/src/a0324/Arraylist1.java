package a0324;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Arraylist1 {
    public static void main(String[] args) {
        // 컬렉션
        ArrayList<Integer> arrlist = new ArrayList<Integer>();

        // add 메소드를 이용한 요소의 저장
        arrlist.add(40);
        arrlist.add(20);
        arrlist.add(30);
        arrlist.add(10);

        // for문 get()메소드를 이용한 요소의 출력
        for (int i = 0; i < arrlist.size(); i++) {
            System.out.print(arrlist.get(i) + " ");
        }

        System.out.println();

        // enhance for 향상된 for문
        for (int e : arrlist) {
            System.out.print(e + " ");
        }

        System.out.println();

        // Collections.sort() 메소드를 이용한 요소의 정렬
        Collections.sort(arrlist);

        // for (int e : arrlist) {
        // System.out.print(e + " ");
        // }

        // iterator() 메소드와 get() 메소드를 이용한 요소의 출력
        Iterator<Integer> iter = arrlist.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

        System.out.println();

        // set() 메소드를 이용한 요소의 변경
        arrlist.set(0, 20);

        for (int e : arrlist) {
            System.out.print(e + " ");
        }
        System.out.println();

        // remove();삭제 인덱스 1번을 삭제 0 2 3번이 출력됨
        arrlist.remove(1);
        for (int e : arrlist) {
            System.out.print(e + " ");
        }

        System.out.println();

        // 특정위치에 인덱스 요소 삽입
        arrlist.add(0, 10);
        for (int e : arrlist) {
            System.out.print(e + " ");


        // size() 메소드를 이용한 요소의 총 개수
        System.out.println("리스트의 크기 : "+ arrlist.size());
        }
    }
}
