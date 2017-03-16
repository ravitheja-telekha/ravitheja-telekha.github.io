$(function(){
    $('.navbar a[href*=#]').click(function() {return smoothScroll(this)});
});

function smoothScroll(linkItem) {

    if (location.pathname.replace(/^\//,'') == linkItem.pathname.replace(/^\//,'')
    && location.hostname == linkItem.hostname) {

        var $target = $(linkItem.hash);
        $target = $target.length && $target || $('[name=' + linkItem.hash.slice(1) +']');
        var dropdown = linkItem.closest('.dropdown');

        if ($target.length) {
        if (dropdown) $(dropdown).toggleClass('open');
        var targetOffset = $target.offset().top;
        $('html,body').animate({scrollTop: targetOffset}, 500);
        return false;
        }
    }
}
