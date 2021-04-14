var category_wrap = $("#category_wrap").offset().top;

$(window).scroll(function() {
    var window = $(this).scrollTop();
    if(category_wrap<=window){
        $("#category_wrap").addClass("fixed");
    }else{
        $("#category_wrap").removeClass("fixed");
    }
})
