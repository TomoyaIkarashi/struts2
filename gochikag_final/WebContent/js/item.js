$(function(){
	$('.sub-img').hover(
		function(){
			 var $main_url = $('.main-img').attr('src');
			 var $sub_url = $(this).attr('src');
			 $('.main-img').attr('src', $sub_url);
			 $(this).attr('src', $main_url);
		}, 
		function(){
			 var $main_url = $('.main-img').attr('src');
			 var $sub_url = $(this).attr('src');
			 $('.main-img').attr('src', $sub_url);
			 $(this).attr('src', $main_url);
		});
});