//스크롤 애니메이션
$(function(){
    $('.animate').scrolla({
        mobile: true,//모바일버전시 활성화
        once: false //스크롤시 딱 한번만 하고싶을땐 true
    });
});


//헤더이벤트
var scrollValue = 0;
scrollValue = $(document).scrollTop(); 
fixHeader();

$(window).on('scroll resize', function(){
   scrollValue = $(document).scrollTop(); 
   fixHeader();
});

function fixHeader(){
    if(scrollValue > 200) {
        $('header').addClass('on');
    }else {$('header').removeClass('on');}
}

//슬라이드 걸기
$(function(){
    $('.visual .slide').slick({
        arrows: false, //화살표 사용안함
        dots: true, //닷츠
        autoplay: true, //자동재생
        fade: true, //페이드인 효과 
        autoplaySpeed:5000, //재생시간 5초
        pauseOnHover:false,//마우스 오버시 슬라이드 멈춤 해제
        pauseOnFocus:false //포커스시 슬라이드 멈춤 해제
    });
});

/*모바일 네비 스크립트 작성*/
$(function(){
    $('header .open').on('click', function(){
        $('body').css({'overflow':'hidden'});
        $('header .bg').css({'display': 'block'});
        $('header nav').addClass('on');
    });
    $('header .close, header .bg').on('click', function(){
        $('body').css({'overflow':'auto'});
        $('header .bg').css({'display':'none'});
        $('header nav').removeClass('on');
    });
});










