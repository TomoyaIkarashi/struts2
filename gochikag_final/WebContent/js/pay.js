	$(function(){
	    $('.lastName').change(function(){
	        if(!$(this).val().match(/[A-Z]{1,10}/)){
	          alert('入力が違います');
	          $(this).val('');
	        }
	      });
	    
	    $('.firstName').change(function(){
	        if(!$(this).val().match(/^[A-Z]{1,10}$/)){
	          alert('入力が違います');
	          $(this).val('');
	        }
	      });
	    
	    $('.choose-credit-select').change(function(){
	    	console.log($(this).val());
	    	console.log($(this).val() == "amex");
	    	if($(this).val() == "master" || $(this).val() == "visa" ){
	            $('.card-number-4').show();
	            $('.card-number-2').attr({'maxlength': '4', 'size':'4', 'placeholder': '0000'}).removeClass('amexSelected');
	            $('.card-number-3').attr({'maxlength': '4', 'size':'4', 'placeholder': '0000'}).removeClass('amexSelected');
	            $('.card-security').attr({'placeholder': '000','size': '3','maxlength': '3'});
	    	}
	    	if($(this).val() == "amex"){
	            $('.card-number-4').hide();
	            $('.card-number-2').attr({'maxlength': '6', 'size':'6', 'placeholder': '000000'}).addClass('amexSelected');
	            $('.card-number-3').attr({'maxlength': '5', 'size':'5', 'placeholder': '000000'}).addClass('amexSelected');
	            $('.card-security').attr({'placeholder': '0000','size': '4','maxlength': '4'});
	    	}
	    });
		
	});