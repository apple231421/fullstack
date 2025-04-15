#include <stdio.h>
#include <string.h>

// 구조체 정의
struct Member
{
    char name[20];
    char gender[10];
    int age;
};

// 생성자처럼 구조체를 초기화하는 함수
struct Member createMember(const char *name, const char *gender, int age)
{
    struct Member m;
    strcpy(m.name, name);
    strcpy(m.gender, gender);
    m.age = age;
    return m;
}

int main()
{
    struct Member mobj1 = createMember("홍길동", "남성", 19);
    struct Member mobj2 = createMember("아이유", "여성", 18);

    printf("%s %s %d\n", mobj1.name, mobj1.gender, mobj1.age);
    printf("%s %s %d\n", mobj2.name, mobj2.gender, mobj2.age);

    return 0;
}
