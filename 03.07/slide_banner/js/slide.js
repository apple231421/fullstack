var visual; // 큰사진
var btn; // pager 버튼
var current = 0; // 현재의 인덱스 번호를 기억
var i = 0; // 내가 누를 인덱스 번호를 기억
var id;

$(function () {
    visual = $("#brandVisual > ul > li"); // 큰사진
    btn = $("#buttonList > li"); // pager 버튼

    // 버튼 클릭 시
    btn.click(function () {
        i = $(this).index(); // 클릭한 버튼의 인덱스 번호
        btn.removeClass('on');
        btn.eq(i).addClass('on');
        move(); // 슬라이드 이동
        return false;
    });

    // 자동 슬라이드 시작
    timer(); // 타이머 함수 실행
});

function timer() {
    id = setInterval(function () {
        var n = current + 1;
        if (n === 3) // 3을 visual.length로 수정가능
            n = 0;
        btn.eq(n).trigger('click'); // n번째 버튼을 2초마다 강제로 클릭
    }, 2000);
}

function move() {
    if (current === i) return; // 현재 활성화된 버튼(current)과 클릭한 버튼(i)이 같으면 빠져나감

    var cu = visual.eq(current); // 현재 사진
    var ne = visual.eq(i); // 슬라이드되서 들어올 사진

    cu.css('left', '0').stop().animate({ 'left': '-100%' }, 500); // 현재 사진을 왼쪽으로 슬라이드
    ne.css('left', '100%').stop().animate({ 'left': '0%' }, 500); // 새 사진을 오른쪽에서 왼쪽으로 슬라이드

    current = i; // 현재 인덱스 업데이트
}
