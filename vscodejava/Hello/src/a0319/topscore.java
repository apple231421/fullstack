package a0319;

public class topscore {
    public static void main(String[] args) {
        // 사람 이름과 점수를 저장한 배열
        String[] name = { "Elena", "Suzie", "John", "Emily", "Neda", "Kate", "Alex", "Daniel", "Sam" };
        int[] score = { 65, 74, 23, 75, 68, 96, 88, 98, 54 };

        // 최대 점수를 추적하기 위한 변수, 첫 번째 점수로 초기화
        int max = 0;
        int maxIndex = 0; // 최대 점수의 인덱스를 저장할 변수

        // 사람들의 점수를 비교하여 최대 점수를 찾는 반복문
        for (int i = 0; i < name.length; i++) {
            // 현재 점수가 기존 최대 점수보다 크면
            if (score[i] > max) {
                max = score[i]; // 최대 점수를 갱신
                maxIndex = i; // 최대 점수의 인덱스를 갱신
                continue;
            }
        }

        // 최대 점수를 받은 사람의 이름과 점수를 출력
        
        // System.out.println(maxIndex);
    }
}
