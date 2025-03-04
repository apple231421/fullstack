const targetLink = document.querySelectorAll('.tab_menu li a'); // 탭버튼
const tabContent = document.querySelectorAll('#tabContent > div'); // 탭내용

targetLink.forEach(function (link) {
    // 1번  let orgTarget = e.target.getAttribute('href');  #tab1, #tab2, #tab3 값을 가지고옴
    // 2번  let tabTarget = orgTarget.replace("#", ""); #값을 ""을 사용해서 #을 제거
    // 3번  tabContent.forEach(function (content) {  
    // content.style.display = "none"; }); //   모든 텝 글을 display none 해서 안보이게하고
    // document.getElementById(tabTarget).style.display = "block"; 내가 보고싶은 텝메뉴를 누르면 그 메뉴만 블록 처리해서 보이게한다
    link.addEventListener("click", function (e) {
        e.preventDefault(); // 링크금지 a태그와 관련있으면 써야됨
        let orgTarget = e.target.getAttribute('href');
        // 클릭한놈 e.target - this로 변경가능
        // getAttribute는 href.src 속성값을 읽어옴
        // alert(orgTarget); #tab1, #tab2, #tab3값이 나옴
        let tabTarget = orgTarget.replace("#", "");
        // #tab1 에서 #을 빈문자열로 대체 --> #이 사라진 tab1, tab2, tab3  값이 나옴

        tabContent.forEach(function (content) {
            content.style.display = "none";
        });
        // 클릭한 텝만 보이게 설정
        document.getElementById(tabTarget).style.display = "block";
        
        targetLink.forEach(function (link2) {
            link2.classList.remove('active');
        })
        e.target.classList.add('active');
    })
})