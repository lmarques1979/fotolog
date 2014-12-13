jQuery(document).ready(function ($) {
	
	$( ".enviarmensagem" ).click(function() {
		var valor = $(".enviomsg" ).css("display");
		if(valor=="none"){
			$(".enviomsg" ).css("display", "block");
		}else{
			$(".enviomsg" ).css("display", "none");
		}
	});
	
	$(".enviomsg").submit(function(e){
		
	    var postData = $(".enviomsg").serializeArray();
	    var formURL  = $(".enviomsg").attr("action"); 
	    $(".message").hide();
	    $(".ajaxerror").hide();
	    
	    $.ajax(
	    {
	        url : formURL,
	        type: "POST",
	        data : postData,
	        dataType: "json",
	        success:function(data, textStatus, jqXHR)
	        {
	             $(".message").html(data.mensagem);
	             $(".message").show();
	             $(".enviomsg")[0].reset();
	             $(".enviomsg" ).css("display", "none");
	        } ,
	        error: function(jqXHR, textStatus, errorThrown)
        	{
        	
	        	var i = 0;
	        	var errodiv='<ul class="errors" role="alert">';
	        	var mensagem='';
	        	var fechadiv="</div>"
	        	while (i<jqXHR.responseJSON.length) {
	        		mensagem = mensagem + '<li>' +  jqXHR.responseJSON[i] + '</li>'
	        		i++;
	        	}
	        	var htmlfinal= errodiv + mensagem + fechadiv;
	        	
	        	$('.ajaxerror').html(htmlfinal);
	        	$(".ajaxerror").show();
        	
        	}
	    });
    	e.preventDefault(); //STOP default action
  	});
		          
});

