// 배너 리스트 요소 가져오기
var list = document.getElementById('banner');

// 배너 안의 모든 li 요소 가져오기
var listLi = document.querySelectorAll('#banner li');

// 배너에 포함된 이미지의 총 개수
var total = listLi.length;

// 개별 이미지의 너비 (px 단위)
var li_width = 1200;

// 첫 번째 이미지를 복사하여 맨 뒤에 추가 (무한 루프 효과를 위해)
var copyObj = listLi[0].cloneNode(true);
list.append(copyObj);

// 현재 배너 위치를 추적할 변수
var num = 0;

// 왼쪽(prev) 버튼 클릭 시 실행되는 함수
document.querySelector('.prev').addEventListener('click', function (e) {
    e.preventDefault(); // a 태그의 기본 이벤트(링크 이동) 방지

    // 첫 번째 이미지에서 왼쪽으로 이동하려 할 때, 마지막 이미지로 순간 이동 후 애니메이션 실행
    if (num === 0) {
        num = 3; // 마지막(복사된) 이미지 위치로 이동
        list.style.transition = 'none'; // 애니메이션 효과 제거
        list.style.marginLeft = -li_width * num + "px";
    }

    // setTimeout을 사용해 브라우저가 위치 변경을 인식하도록 유도한 후 애니메이션 실행
    setTimeout(function () {
        num--; // 이전 이미지로 이동
        list.style.transition = 'margin-left 0.5s'; // 부드럽게 이동하는 애니메이션 효과 추가
        list.style.marginLeft = -li_width * num + "px";
    }, 50);
});

// 오른쪽(next) 버튼 클릭 시 실행되는 함수
document.querySelector('.next').addEventListener('click', function (e) {
    e.preventDefault(); // a 태그의 기본 이벤트 방지

    // 마지막 이미지에서 오른쪽으로 이동하려 할 때, 첫 번째 이미지로 순간 이동 후 애니메이션 실행
    if (num === 3) {
        num = 0; // 첫 번째 이미지로 위치 변경
        list.style.transition = 'none'; // 애니메이션 효과 제거
        list.style.marginLeft = 0;
    }

    // setTimeout을 사용해 브라우저가 위치 변경을 인식하도록 유도한 후 애니메이션 실행
    setTimeout(function () {
        num++; // 다음 이미지로 이동
        list.style.transition = 'margin-left 0.5s'; // 부드러운 애니메이션 효과 추가
        list.style.marginLeft = -li_width * num + "px";
    }, 50);
});

// 자동으로 슬라이드가 넘어가는 함수
function autoplay() {
    // 마지막 이미지에서 다시 처음으로 돌아가야 할 경우
    if (num === 3) {
        num = 0; // 첫 번째 이미지로 이동
        list.style.transition = 'none'; // 애니메이션 효과 제거
        list.style.marginLeft = 0;
    }

    // setTimeout을 사용해 자연스럽게 슬라이드가 이동하도록 처리
    setTimeout(function () {
        num++; // 다음 이미지로 이동
        list.style.transition = 'margin-left 0.5s'; // 부드러운 애니메이션 효과 추가
        list.style.marginLeft = -li_width * num + "px";
    }, 50);
}

// 3초마다 자동으로 배너가 넘어가도록 설정
setInterval(autoplay, 2000);
