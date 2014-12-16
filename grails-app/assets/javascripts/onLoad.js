jQuery(document).ready(function ($) {
		
	var tipomidia = $("#midiabanco").val();
	
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