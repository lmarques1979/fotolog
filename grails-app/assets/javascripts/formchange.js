jQuery(document).ready(function ($) {
	
	$("#eventocreate").change(function() {
		
		var tipomidia = $('option:selected',this).attr('data-tipomidia');
		
		if(tipomidia==1){
			$(".imagem").show();
			$(".video").hide();
			$(".musica").hide();
		}
		if(tipomidia==2){
			$(".imagem").hide();
			$(".video").show();
			$(".musica").hide();
		}
		if(tipomidia==3){
			$(".imagem").hide();
			$(".video").hide();
			$(".musica").show();
			}
	});
	
	$("#eventoedit").change(function() {
		
		var tipomidia = $('option:selected',this).attr('data-tipomidia');
		
		if(tipomidia==1){
			$(".imagemedit").show();
			$(".videoedit").hide();
			$(".musicaedit").hide();
		}
		if(tipomidia==2){
			$(".imagemedit").hide();
			$(".videoedit").show();
			$(".musicaedit").hide();
		}
		if(tipomidia==3){
			$(".imagemedit").hide();
			$(".videoedit").hide();
			$(".musicaedit").show();
			}
	});
	
});