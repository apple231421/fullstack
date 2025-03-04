// 1번 탭 버튼을 할당할 함수만듬
// 2번 탭내용을 할당할 함수만듬
// 3번 foreach문으로  탭버튼을 클릭시 이벤트 작성
// 4번 탭버튼을 클릭시 링크화 금지
// 5번 모든 클래스에 active 제거 후 내가 누를 버튼에 맞는 번호에 active추가
// 6번 모든 클래스에 on 제거 후 내가 누를 버튼에 맞는 번호에 on추가

// 1번 탭 버튼을 할당할 함수만듬
const tabBtn = document.querySelectorAll('.tab_menu li');

// 2번 탭내용 을 할당할 함수만듬
const tabMain = document.querySelectorAll('#tabContent >div');

// 3번 foreach문으로  탭버튼을 클릭시 이벤트 작성

tabBtn.forEach(function (menu, i) {
    menu.addEventListener('click', function (e) {
        e.preventDefault();  // 4번 탭버튼을 클릭시 링크화 금지


        // 5번 모든 탭 버튼 클래스에 active 제거 후 내가 누를 버튼에 맞는 번호에 active추가
        tabBtn.forEach(function (menu2) {
            menu2.classList.remove('active')
            tabBtn[i].classList.add('active')
        })

        // 6번 모든 클래스에 on 제거 후 내가 누를 버튼에 맞는 번호에 on추가
        tabMain.forEach(function (main) {
            main.classList.remove('on')
        })
        tabMain[i].classList.add('on')
    })
})