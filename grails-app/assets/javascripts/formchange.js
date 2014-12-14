jQuery(document).ready(function ($) {
	
	$("#tipomidia").change(function() {
		var tipomidia = $(this).val();
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
	
	$("#tipomidiaedit").change(function() {
		var tipomidia = $(this).val();
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