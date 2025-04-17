#include <stdio.h>

// Student 구조체 정의
struct student {
    char name[20];   // 이름 (최대 20자)
    int studentid;   // 학번
    char grade;      // 학점
};

int main() {
    struct student s;  // Student 구조체 변수 선언

    // 사용자 입력 받기
    printf("이름을 입력해주세요(최대 20자): ");
    scanf("%s", s.name);  // 문자열 입력

    printf("학번을 입력해주세요: ");
    scanf("%d", &s.studentid);  // 정수 입력

    printf("학점을 입력해주세요: ");
    getchar();  // 입력 버퍼에 남은 \n 제거
    s.grade = getchar(); // 학점 입력

    // 저장된 학생 정보 출력
    printf("\n------ 학생 정보 -------\n");
    printf("이름  : %s\n", s.name);
    printf("학번  : %d\n", s.studentid);
    printf("학점  : %c\n", s.grade);

    return 0;
}