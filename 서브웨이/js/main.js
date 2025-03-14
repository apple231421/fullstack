$(function () {
    $('.main_slider').bxSlider({
        auto: true,
        controls: false,
        mode: 'fade',
        pause: 3000, // 속도
        onSlideAfter: function ($slideElement, oldIndex, newIndex) {
            $(".bx-pager a").removeClass("active-custom"); // 기존 스타일 제거

        }
    });
});

$(function () {
    var slider = $('.sub_1').bxSlider({
        pager: false,  // 페이지네이션 비활성화
        infiniteLoop: false,  // 무한 반복 비활성화
        moveSlides: 4, // 한번에 슬라이드되는 수
        minSlides: 4,  // 첫 번째 슬라이드에서 4개
        maxSlides: 4,  // 첫 번째 슬라이드에서 4개
        slideWidth: 260, // 슬라이드 너비
        slideMargin: 40, // 슬라이드 간의 여백
        touchEnabled: false,  // 터치 스와이프 비활성화
        // controls: false,  // 이전/다음 버튼 비활성화
    });
});
$(function () {
    var slider = $('.sub_2').bxSlider({
        pager: false,  // 페이지네이션 비활성화
        infiniteLoop: false,  // 무한 반복 비활성화
        moveSlides: 4, // 한번에 슬라이드되는 수
        minSlides: 4,  // 첫 번째 슬라이드에서 4개
        maxSlides: 4,  // 첫 번째 슬라이드에서 4개
        slideWidth: 260, // 슬라이드 너비
        slideMargin: 40, // 슬라이드 간의 여백
        touchEnabled: false,  // 터치 스와이프 비활성화
        controls: false,  // 이전/다음 버튼 비활성화
    });
});
$(function () {
    var slider = $('.sub_3').bxSlider({
        pager: false,  // 페이지네이션 비활성화
        infiniteLoop: false,  // 무한 반복 비활성화
        moveSlides: 4, // 한번에 슬라이드되는 수
        minSlides: 4,  // 첫 번째 슬라이드에서 4개
        maxSlides: 4,  // 첫 번째 슬라이드에서 4개
        slideWidth: 260, // 슬라이드 너비
        slideMargin: 40, // 슬라이드 간의 여백
        touchEnabled: false,  // 터치 스와이프 비활성화
        controls: false,  // 이전/다음 버튼 비활성화
    });
});
$(function () {
    var slider = $('.sub_4').bxSlider({
        pager: false,  // 페이지네이션 비활성화
        infiniteLoop: false,  // 무한 반복 비활성화
        moveSlides: 4, // 한번에 슬라이드되는 수
        minSlides: 4,  // 첫 번째 슬라이드에서 4개
        maxSlides: 4,  // 첫 번째 슬라이드에서 4개
        slideWidth: 260, // 슬라이드 너비
        slideMargin: 40, // 슬라이드 간의 여백
        touchEnabled: false,  // 터치 스와이프 비활성화
        controls: false,  // 이전/다음 버튼 비활성화
    });
});


//  사진 사라지게하는법
$(function () {
    $('.cf').css("display", "none");
    $('.cf').eq(0).css("display", "block");
    $('.tab ul li').click(function () {

        var i = $(this).index();

        $('.cf').css("display", "none");
        $('.cf').eq(i).css("display", "block");
        $('.tab ul li').removeClass('on');
        $('.tab ul li').eq(i).addClass('on');

        return false;
    });

});

$(function () {
    var slider = $('.rb_pic').bxSlider({
        auto: true,
        controls: false,
        mode: 'fade',
        pause: 3000, // 속도
        moveSlides: 1, // 한번에 슬라이드되는 수
        minSlides: 1,  // 첫 번째 슬라이드에서 4개
        maxSlides: 1,  // 첫 번째 슬라이드에서 4개
        slideWidth: 300, // 슬라이드 너비
        touchEnabled: false,  // 터치 스와이프 비활성화

    });

});




$(function () {
    // 팝업창 이동 가능 (jQuery UI 필요)
    $("#notice_wrap").draggable();

    // 쿠키가 존재하면 팝업 숨김
    if ($.cookie('popup') === 'none') {
        $('#notice_wrap').hide();
    }

    // 닫기 버튼 이벤트 추가
    $('.closebtn').on('click', function () {
        if ($("#chk").is(":checked")) { 
            $.cookie('popup', 'none', { expires: 3, path: '/' }); // 3일 유지
        }
        $('#notice_wrap').fadeOut("fast");
    });
});
