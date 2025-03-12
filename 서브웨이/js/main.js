$(function () {
    $('.main_slider').bxSlider({
        auto: true,
        controls: false,
        mode: 'fade',
        pause: 3000,//속도
    })
})
$(function () {
    var slider = $('.subway_menu_slider').bxSlider({
        moveSlides: 4, // 한번에 슬라이드되는 수
        minSlides: 4,  // 첫 번째 슬라이드에서 4개
        maxSlides: 4,  // 첫 번째 슬라이드에서 4개
        slideWidth: 260, // 슬라이드 너비
        slideMargin: 40, // 슬라이드 간의 여백
    })
});
