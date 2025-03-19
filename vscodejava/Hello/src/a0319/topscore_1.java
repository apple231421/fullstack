package a0319;

public class topscore_1 {
    public static void main(String[] args) {
        // 사람 이름과 점수를 저장한 배열
        String[] name = { "Elena", "Suzie", "John", "Emily", "Neda", "Kate", "Alex", "Daniel", "Sam" };
        int[] score = { 65, 74, 23, 75, 68, 96, 88, 98, 54 };

        // 최대 점수를 추적하기 위한 변수, 첫 번째 점수로 초기화
        // topindex 메서드를 호출하여 최고 점수의 인덱스를 얻음
        int i = topindex(score);

        // 최고 점수의 사람 이름과 점수 출력
        System.out.printf("1등 : %s(%d점)", name[i], score[i]);
    }

    // 최고 점수의 인덱스를 찾는 메서드
    private static int topindex(int[] arr) {
        int topidx = 0; // 가장 큰 점수를 가진 사람의 인덱스 초기화 (초기값: 0번 인덱스)

        // 배열을 순차적으로 돌면서 점수를 비교
        for (int i = 0; i < arr.length; i++) {
            // 현재 점수가 이전에 기록된 최대 점수보다 크면
            if (arr[topidx] < arr[i]) {
                topidx = i; // 최대 점수의 인덱스를 갱신
            }
        }

        // 최고 점수의 인덱스 번호 반환
        return topidx;
    }
}
