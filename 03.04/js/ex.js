// 1. 탭 버튼 요소 선택
// 2. 탭 콘텐츠 요소 선택
// 3. 탭 버튼 클릭 이벤트 추가
// 4. 탭 버튼을 클릭 시 기본 링크 기능 제거
// 5. 모든 탭 버튼에서 'active' 클래스 제거 후 선택된 버튼에 추가
// 6. 모든 탭 콘텐츠에서 'on' 클래스 제거 후 선택된 콘텐츠에 추가

// 1. 탭 버튼 요소 선택
const tabBtn = document.querySelectorAll('.tab_menu li');

// 2. 탭 콘텐츠 요소 선택
const tabMain = document.querySelectorAll('#tabContent > div');

//      3. 탭 버튼 클릭 이벤트 추가
//      tabBtn.forEach(function (menu, i) {
//      menu.addEventListener('click', function (e) {
//      e.preventDefault();

// 4. 탭 버튼을 클릭 시 기본 링크 기능 제거
tabBtn.forEach((menu, i) => {
    menu.addEventListener('click', (e) => {
        e.preventDefault();


        // 5. 모든 탭 버튼에서 'active' 클래스 제거 후 선택된 버튼에 추가
        // tabBtn.forEach(function (menu2) {
        // menu2.classList.remove('active')
        // tabBtn[i].classList.add('active')
        // })

        tabBtn.forEach((menu2) => menu2.classList.remove('active'));
        tabBtn[i].classList.add('active');



        // 6. 모든 탭 콘텐츠에서 'on' 클래스 제거 후 선택된 콘텐츠에 추가
        // tabMain.forEach(function (main) {
        // main.classList.remove('on')
        // })
        // tabMain[i].classList.add('on')
        // })

        tabMain.forEach((main) => main.classList.remove('on'));
        tabMain[i].classList.add('on');
    });
});
