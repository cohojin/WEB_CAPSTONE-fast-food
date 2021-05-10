$(function(){
    var lnb = $("#category_wrap").offset().top;
    $(window).scroll(function() {
        var window = $(this).scrollTop();
        if(lnb<=window){
            $("#category_wrap").addClass("fixed");
        }else{
            $("#category_wrap").removeClass("fixed");
        }
    })
});
