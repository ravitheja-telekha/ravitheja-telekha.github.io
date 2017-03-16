$('.additional-menu').on('click','li', function(){
   $(this).addClass('active').siblings().removeClass('active');
});
  var modal = document.getElementById('myModal');


  // var span = document.getElementsByClassName("close")[0];
  // span.onclick = function() {
  //     modal.style.display = "none";
  //     $('body').css('overflow','scroll');
  // }

  var backButton = document.getElementById('bckBtn');
  var forwardButton = document.getElementById('fwdBtn');
  var images = document.getElementsByClassName('GalleryImg');
  var modalImg = document.getElementById("img01");
  backButton.onclick = function(bckBtn){
      ImageId = document.getElementById("mem").value.split("-");
      PreviousImage = parseInt(ImageId[1])-1;
      if(PreviousImage<0){PreviousImage=0;}
      images[PreviousImage].click();

  }

  forwardButton.onclick = function(fwdBtn){
      ImageId = document.getElementById("mem").value.split("-");
      NextImage = parseInt(ImageId[1])+1;
      if(NextImage>5){NextImage=5;}
      images[NextImage].click();
  }

  var i;
  for (i =0; i < images.length; i++) {
     images[i].onclick = function(){
         modal.style.display = "block";
         var src = this.src;
         var filename = src.substring(src.lastIndexOf('/')+1);
         var filepath = src.substring(0, src.lastIndexOf('/')+1);
         modalImg.src = filepath + filename;
         modalImg.alt = this.alt;
        document.getElementById("mem").value=this.id;
        $('body').css('overflow','hidden');


     }
}



  $(window).on('click', function(event){
   if(event.target.id == 'myModal'){
       $('#myModal').css({display: "none"});
$('body').css('overflow','scroll');

   }

  });
$(window).bind('keyup',function(e){
    if(e.keyCode == 27){

       $('#myModal').css({display: "none"});
       $('body').css('overflow','scroll');

  }

});
 $(forwardButton).mousedown(function(){ return false; })



$(window).bind("keyup", function (e) {
   if (e.keyCode === 37) {
     ImageId = document.getElementById("mem").value.split("-");
     PreviousImage = parseInt(ImageId[1])-1;
     if(PreviousImage<0){PreviousImage=0;}
     images[PreviousImage].click();
   } else if (e.keyCode  === 39 ) {
     ImageId = document.getElementById("mem").value.split("-");
     NextImage = parseInt(ImageId[1])+1;
     if(NextImage>5){NextImage=5;}
     images[NextImage].click();
   }
});

window.addEventListener("keypress", function(e) {
    // space and arrow keys
    if([ 38,40].indexOf(e.keyCode) > -1) {
        e.preventDefault();
    }
}, false);

// function action()
// {
//   document.getElementById('bckBtn').style.display:none;
// }
$('ul.tabs li').click(function() {
    $(this).addClass("active").siblings().removeClass("active");

});
