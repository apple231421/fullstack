package a0327.wordList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Brain implements Interface {
    static HashMap<String, String> word = new HashMap<>();

    public Brain() {
        word.put("peach", "복숭아");
        word.put("Plum", "자두");
        word.put("Pomegranate", "석류");
        word.put("Persimmon", "감");
    }

    @Override
    public void Menu() {
        System.out.println();
        System.out.println("---- 선택 해주세요. ----");
        System.out.println(" 1. 단어 등록 ");
        System.out.println(" 2. 단어 조회 ");
        System.out.println(" 3. 단어 삭제 ");
        System.out.println(" 4. 테스트 ");
        System.out.println(" 5. 단어 목록 보기");
        System.out.println(" 6. 종료 ");
        System.out.println("-----------------------");
        System.out.println();
    }

    // 1번 - 단어 등록
    @Override
    public void AddWord() {
        Scanner sc = new Scanner(System.in);
        String eng, kor;
        while (true) {
            System.out.println("(목록으로 돌아가려면 Menu입력)\n등록할 영단어를 입력하세요: ");
            eng = sc.nextLine();

            if (eng.equalsIgnoreCase("menu")) {
                break;
            } else {
                if (word.containsKey(eng)) {
                    System.out.println();
                    System.out.println("이미 입력된 단어입니다.\n수정을 원하시면 삭제 후 다시 입력해주세요");
                } else {
                    System.out.println();
                    System.out.println("뜻을 입력해 주세요 : ");
                    kor = sc.nextLine();
                    word.put(eng, kor);
                    System.out.println();
                    System.out.println("단어가 등록되었습니다.");
                }
            }
        }
    }

    // 2번 - 단어 조회
    @Override
    public void WordSearch() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("(목록으로 돌아가려면 Menu입력)\n조회하고 싶은 영어 단어를 입력하세요:");
            String eng = sc.nextLine();

            if (eng.equalsIgnoreCase("menu")) {
                break;
            } else {
                if (word.containsKey(eng)) { // 단어가 존재하는지 확인
                    System.out.println();
                    System.out.println("단어의 의미: " + word.get(eng)); // 단어에 대한 의미 출력
                } else {
                    System.out.println();
                    System.out.println("등록되지 않은 단어입니다.");
                }
            }
        }
    }

    // 3번 - 단어 삭제
    @Override
    public void DeleteWord() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==== 단어 목록 ====");
            if (word.isEmpty()) {
                System.out.println("등록된 단어가 없습니다.");
            } else {
                for (Map.Entry<String, String> entry : word.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }
            }
            System.out.println("=====================");
            System.out.println();
            System.out.println("(목록으로 돌아가려면 Menu입력)\n삭제하고 싶은 단어를 입력하세요:");
            String del = sc.nextLine().trim();

            if (del.equalsIgnoreCase("menu")) {
                System.out.println("메뉴로 돌아갑니다.");
                break;
            }
            if (word.containsKey(del)) {
                System.out.println("입력한 단어 " + del + " : " + word.remove(del) + "이 삭제됨");
                System.out.println();
            }
        }
    }

    // 4번 - 테스트
    @Override
    public void Test() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. 시작하기");
            System.out.println("2. 종료하기");
            System.out.print("번호를 입력하세요");
            if (!sc.hasNextInt()) { // 숫자 입력이 아닌 경우 예외 처리
                System.out.println("숫자를 입력하세요.");
                sc.next(); // 잘못된 입력 제거
                continue;
            }

            int a = sc.nextInt();
            sc.nextLine(); // 입력 버퍼 문제 방지

            if (a == 1) {
                int correctcount = 0;
                int totelcount = 0;
                System.out.println("===== 뜻에 맞는 영단어를 입력하세요=====");
                for (Map.Entry<String, String> entry : word.entrySet()) {
                    System.out.println(entry.getValue());
                    System.out.println("답 입력: ");
                    System.out.println();
                    String answer = sc.nextLine().trim();
                    if (answer.equalsIgnoreCase(entry.getKey())) {
                        System.out.println("정답입니다.");
                        correctcount++; // 정답 숫자 누적
                    } else {
                        System.out.println("틀림 (정답 : " + entry.getKey() + ")\n");
                    }
                    totelcount++; // 총 문제수 누적
                }
                System.out.println("총 " + totelcount + "개 중에 " + correctcount + "개 맞추셨습니다");
                break;
            } else if (a == 2) {
                System.out.println("프로그램을 종료합니다");
                break;
            }else{
                System.out.println("숫자를 다시 입력해주세요");
            }
        }

    }

    // 5번 - 단어 목록 보기
    @Override
    public void wordList() {
        System.out.println("==== 단어 목록 =====");
        if (word.isEmpty()) {
            System.out.println("저장된 단어가 없어요");
        } else {
            for (Map.Entry<String, String> entry : word.entrySet()) {
                System.out.println("※   " + entry.getKey() + " : " + entry.getValue());
            }
            System.out.println("================");
        }
        System.out.println("등록된 단어 수 : " + word.size());
    }

    // 6번 - 종료
    @Override
    public void Exit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0); // 프로그램 종료
    }
}
