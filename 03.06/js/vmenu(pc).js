$(function () {
    // $('.m_menu li ul').css('dispaly','none') .sub 랑 .m_menu li ul 같은 경로
    $('.sub').hide()

    $('.m_menu li ul').eq(0).show()

    $('.m_menu li a').click(function () {
        var i = $(this).next('.sub').css('display');
        // 클릭a 다음에 .sub의 display 상태 none인지 block인지 알수가잇음
        // alert(i)
        if(i == "none"){
            $('.sub').slideUp(); //모든슬라이드를 닫음
            $(this).next('.sub').slideDown();
            // 방금 클릭한 다음에 .sub를 보여줌
        }

        return false
    })
})