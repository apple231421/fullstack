$(function () {
    $(window).scroll(function () {
        var scl = $(this).scrollTop();
        $('.s_top').text(scl)
        if (scl >= 450 && scl <= 1000) {
            $('.left1').addClass('on')
        } else {
            $('.left1').removeClass('on')
        }


        if (scl >= 1200 && scl <= 1800) {
            $('.right1').addClass('on')
        } else {
            $('.right1').removeClass('on')
        }

        if (scl >= 2500 && scl <= 2900) {
            $('.s4_1').addClass('active')
            setTimeout(function () {
                $('.s4_2').addClass('active')
            }, 400)
            setTimeout(function () {
                $('.s4_3').addClass('active')
            }, 800)
            setTimeout(function () {
                $('.s4_4').addClass('active')
            }, 1200)
        } else {
            $('.s4_1,.s4_2,.s4_3,.s4_4').removeClass('active')
        }

    })

})