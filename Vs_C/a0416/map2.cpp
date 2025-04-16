#include <iostream>
#include <map>

using namespace std;

int main()
{
    map<string, int> score;

    // 학생 이름과 점수 삽입
    score["Alice"] = 95;
    score["Bob"] = 82;
    score["Charlie"] = 88;

    // 전체 학생 점수 출력
    // cout << "학생 점수 목록: " << endl;
    // for (map<string, int>::iterator it = score.begin(); it != score.end(); ++it)
    // {
    //     cout << it->first << " : " << it->second << endl;
    // }
    cout << "학생 점수 목록: " << endl;
    for (auto it = score.begin(); it != score.end(); ++it)
    {
        cout << it->first << " : " << it->second << endl;
    }

    // it->first 키
    // it->second 값

    // 특정 값찾기
    string name = "Bob";
    if (score.find(name) != score.end())
    {
        cout << name << "의 점수는 " << score[name] << endl;
    }
    else
    {
        cout << name << "의 점수는 존재하지 않습니다" << endl;
    }

    // 삭제
    score.erase("Charlie");
    cout << "삭제후 남은 학생 목록" << endl;
    // for (auto it = score.begin(); it != score.end(); ++it)
    // {
    //     cout << it->first << " : " << it->second << endl;
    // }

    for (const auto &pair : score)
    {
        cout << pair.first << " : " << pair.second << endl;
    }
    // const auto&pair :socre - score 라는 map의 각 key-value 쌍으로 pair라는 이름으로 하나씩 가져옴
    //: score - score 대상으로 순회 하겠다
    // pair.first - 현재 순회중인 key
    // pair.second - 현재 순회중인 value

    return 0;
}