$(function () {
    setTimeout(function () {
        $('.slider li .text0').addClass('on');
        $('.slider li .atext0').addClass('on');
    }, 500);


    var bx = $('.slider').bxSlider({
        auto: true,
        controls: false,
        mode: 'fade',
        pager: false,
        pause: 5000,//속도
        onSlideBefore: function () { },
        onSlideAfter: function () {
            var k = bx.getCurrentSlide();//현재슬라이드번호
            $('.slider li').find('h2').removeClass('on');
            $('.slider li').find('p').removeClass('on');
            $('.slider li .text' + k).addClass('on');
            $('.slider li .atext' + k).addClass('on');

        }
    });

    var a1 = $(".s2_title img").offset().top;  // '/'
    var a2 = $('.s2_title h2').offset().top; // 제목
    var a3 = $('.s2_title p').offset().top; // 내용
    var a4 = $('.s2_table li').offset().top;


    var b1 = $(".s3_title img").offset().top;  // '/'
    var b2 = $('.s3_title h2').offset().top; // 제목
    var b3 = $('.s3_title p').offset().top; // 내용
    var b4 = $('.s3_table li').offset().top;

    var c1 = $(".s4_title img").offset().top;  // '/'
    var c2 = $('.s4_title h2').offset().top; // 제목
    var c3 = $('.s4_title p').offset().top; // 내용
    var c4 = $('.s4_table li').offset().top;


    var d1 = $('#s5').offset().top;
    var d2 = $('#s6').offset().top;
    console.log(a1, a2, a3);

    $(window).scroll(function () {
        var sct = $(this).scrollTop();
        if (a1 <= sct + 700) {
            $(".s2_title img").addClass('slide');
        }
        if (a2 < sct + 700) {
            $('.s2_title h2').addClass('slide');
        }
        if (a3 < sct + 700) {
            $('.s2_title p').addClass('slide');
        }
        if (a4 < sct + 700) {
            $('.s2_table li').eq(0).addClass('slide');
            setTimeout(function () {
                $('.s2_table li').eq(1).addClass('slide');
            }, 300);
            setTimeout(function () {
                $('.s2_table li').eq(2).addClass('slide');
            }, 600);
            setTimeout(function () {
                $('.s2_table li').eq(3).addClass('slide');
            }, 900);
        }

        if (b1 <= sct + 700) {
            $(".s3_title img").addClass('slide');
        }
        if (b2 < sct + 700) {
            $('.s3_title h2').addClass('slide');
        }
        if (b3 < sct + 700) {
            $('.s3_title p').addClass('slide');
        }
        if (b4 < sct + 700) {
            $('.s3_table li').eq(0).addClass('slide');
            setTimeout(function () {
                $('.s3_table li').eq(1).addClass('slide');
            }, 300);
            setTimeout(function () {
                $('.s3_table li').eq(2).addClass('slide');
            }, 600);
            setTimeout(function () {
                $('.s3_table li').eq(3).addClass('slide');
            }, 900);
            setTimeout(function () {
                $('.s3_table li').eq(4).addClass('slide');
            }, 1200);
        }

        var sct = $(this).scrollTop();
        if (c1 <= sct + 700) {
            $(".s4_title img").addClass('slide');
        }
        if (c2 < sct + 700) {
            $('.s4_title h2').addClass('slide');
        }
        if (c3 < sct + 700) {
            $('.s4_title p').addClass('slide');
        }
        if (c4 < sct + 700) {
            $('.s4_table li').eq(0).addClass('slide');
            setTimeout(function () {
                $('.s4_table li').eq(1).addClass('slide');
            }, 300);
            setTimeout(function () {
                $('.s4_table li').eq(2).addClass('slide');
            }, 600);
            setTimeout(function () {
                $('.s4_table li').eq(3).addClass('slide');
            }, 900);
        }


        if (d1 <= sct + 700) {
            $(".s5_inner").addClass('slide1');
        }
        if (d2 <= sct + 700) {
            $(".s6_noti, .s6_review").addClass('slide1');
        }



    })
    $(function () {
        var dtop = $('.fix_box').offset().top; // 400px
        $(window).scroll(function () {
            var scl = $(this).scrollTop();
            $('.fix_box').stop().animate({ top: dtop + scl }, 500)
        })

    });
});