package a0403.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//컬렉션
//1. 데이터를 효율적으로 저장
//2. 배열보다 유연하게 크기변경가능
//3. 자료구조: List, Map , Set
//4. ArrayList<String> - 제네릭지원으로 타입 안정성 제공
//5. 다양한 구현체 제공 : 성능과 특징에 맞게 선태가능

//리스트 (순서 O , 중복허용 )
// ArrayList 배열기반, 검색빠름, 삽입 ,삭제 
// LinkedList 연결리스트 기반 ,검색느림, 삽입삭제 빠름
//Vector ArrayList와 유사 스레드 안전
//Stack  LIFO(Last-In-First-Out) 구조 push()-삽입  pop()-삭제

//Set(순서 X , 중복허용 안함)
//HashSet   해시기반, 요소순서보장 X, 중복불가
// LinkedHashSet 입력순서유지, 중복 불가
//TreeSet 졍렬된 상태유지(오름차순)

//Queue(FIFO)

//Map(Key - value, 키 중복)
//HashMap  - 키 순서 보장 X, 빠른검색속도
//LinkedHashMap  입력순서 유지
//TreeMap  정렬된 상태 유지(키 기준)

public class Set2 {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();

        // 중복된 값이 있는 리스트
        items.add("apple");
        items.add("banana");
        items.add("orange");
        items.add("apple");
        items.add("grape");

        //Hashset을 사용해 중복제거
        Set<String> uniqueItems = new HashSet<>(items);
        System.out.println("중복 제거 후 리스트 : " + uniqueItems);
    }
}
