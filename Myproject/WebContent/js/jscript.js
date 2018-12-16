$(document).ready(function(){
$("#add1").click(function(){
	var q = parseInt($("#f1 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity1").val());
		if(aq==0)
			$("#combo").val(parseInt($("#combo").val()) + 1);
		aq=aq+q;
		$("#addedquantity1").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp1").val());
		p=p+(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#f1 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f1").html(select);
		select="";
		lastValue = parseInt($('#F1 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F1").html(select);
	}
});
$("#remove1").click(function(){
	var q = parseInt($("#F1 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity1").val());
		if(aq==1)
			$("#combo").val(parseInt($("#combo").val()) - 1);
		aq=aq-q;
		$("#addedquantity1").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp1").val());
		p=p-(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#F1 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F1").html(select);
		select="";
		lastValue = parseInt($('#f1 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f1").html(select);
	}
});


$("#add2").click(function(){
	var q = parseInt($("#f2 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity2").val());
		if(aq==0)
			$("#combo").val(parseInt($("#combo").val()) + 1);
		aq=aq+q;
		$("#addedquantity2").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp2").val());
		p=p+(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#f2 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f2").html(select);
		select="";
		lastValue = parseInt($('#F2 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F2").html(select);
	}
});
$("#remove2").click(function(){
	var q = parseInt($("#F2 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity2").val());
		if(aq==1)
			$("#combo").val(parseInt($("#combo").val()) - 1);
		aq=aq-q;
		$("#addedquantity2").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp2").val());
		p=p-(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#F2 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F2").html(select);
		select="";
		lastValue = parseInt($('#f2 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f2").html(select);
	}
});


$("#add3").click(function(){
	var q = parseInt($("#f3 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity3").val());
		if(aq==0)
			$("#combo").val(parseInt($("#combo").val()) + 1);
		aq=aq+q;
		$("#addedquantity3").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp3").val());
		p=p+(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#f3 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f3").html(select);
		select="";
		lastValue = parseInt($('#F3 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F3").html(select);
	}
});
$("#remove3").click(function(){
	var q = parseInt($("#F3 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity3").val());
		if(aq==1)
			$("#combo").val(parseInt($("#combo").val()) - 1);
		aq=aq-q;
		$("#addedquantity3").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp3").val());
		p=p-(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#F3 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F3").html(select);
		select="";
		lastValue = parseInt($('#f3 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f3").html(select);
	}
});


$("#add4").click(function(){
	var q = parseInt($("#f4 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity4").val());
		if(aq==0)
			$("#combo").val(parseInt($("#combo").val()) + 1);
		aq=aq+q;
		$("#addedquantity4").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp4").val());
		p=p+(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#f4 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f4").html(select);
		select="";
		lastValue = parseInt($('#F4 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F4").html(select);
	}
});
$("#remove4").click(function(){
	var q = parseInt($("#F4 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity4").val());
		if(aq==1)
			$("#combo").val(parseInt($("#combo").val()) - 1);
		aq=aq-q;
		$("#addedquantity4").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp4").val());
		p=p-(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#F4 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F4").html(select);
		select="";
		lastValue = parseInt($('#f4 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f4").html(select);
	}
});


$("#add5").click(function(){
	var q = parseInt($("#f5 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity5").val());
		if(aq==0)
			$("#combo").val(parseInt($("#combo").val()) + 1);
		aq=aq+q;
		$("#addedquantity5").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp5").val());
		p=p+(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#f5 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f5").html(select);
		select="";
		lastValue = parseInt($('#F5 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F5").html(select);
	}
});
$("#remove5").click(function(){
	var q = parseInt($("#F5 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity5").val());
		if(aq==1)
			$("#combo").val(parseInt($("#combo").val()) - 1);
		aq=aq-q;
		$("#addedquantity5").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp5").val());
		p=p-(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#F5 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F5").html(select);
		select="";
		lastValue = parseInt($('#f5 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f5").html(select);
	}
});


$("#add6").click(function(){
	var q = parseInt($("#f6 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity6").val());
		if(aq==0)
			$("#combo").val(parseInt($("#combo").val()) + 1);
		aq=aq+q;
		$("#addedquantity6").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp6").val());
		p=p+(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#f6 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f6").html(select);
		select="";
		lastValue = parseInt($('#F6 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F6").html(select);
	}
});
$("#remove6").click(function(){
	var q = parseInt($("#F6 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity6").val());
		if(aq==1)
			$("#combo").val(parseInt($("#combo").val()) - 1);
		aq=aq-q;
		$("#addedquantity6").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp6").val());
		p=p-(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#F6 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F6").html(select);
		select="";
		lastValue = parseInt($('#f6 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f6").html(select);
	}
});


$("#add7").click(function(){
	var q = parseInt($("#f7 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity7").val());
		if(aq==0)
			$("#combo").val(parseInt($("#combo").val()) + 1);
		aq=aq+q;
		$("#addedquantity7").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp7").val());
		p=p+(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#f7 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f7").html(select);
		select="";
		lastValue = parseInt($('#F7 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F7").html(select);
	}
});
$("#remove7").click(function(){
	var q = parseInt($("#F7 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity7").val());
		if(aq==1)
			$("#combo").val(parseInt($("#combo").val()) - 1);
		aq=aq-q;
		$("#addedquantity7").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp7").val());
		p=p-(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#F7 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F7").html(select);
		select="";
		lastValue = parseInt($('#f7 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f7").html(select);
	}
});


$("#add8").click(function(){
	var q = parseInt($("#f8 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity8").val());
		if(aq==0)
			$("#combo").val(parseInt($("#combo").val()) + 1);
		aq=aq+q;
		$("#addedquantity8").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp8").val());
		p=p+(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#f8 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f8").html(select);
		select="";
		lastValue = parseInt($('#F8 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F8").html(select);
	}
});
$("#remove8").click(function(){
	var q = parseInt($("#F8 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity8").val());
		if(aq==1)
			$("#combo").val(parseInt($("#combo").val()) - 1);
		aq=aq-q;
		$("#addedquantity8").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp8").val());
		p=p-(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#F8 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F8").html(select);
		select="";
		lastValue = parseInt($('#f8 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f8").html(select);
	}
});


$("#add9").click(function(){
	var q = parseInt($("#f9 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity9").val());
		if(aq==0)
			$("#combo").val(parseInt($("#combo").val()) + 1);
		aq=aq+q;
		$("#addedquantity9").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp9").val());
		p=p+(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#f9 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f9").html(select);
		select="";
		lastValue = parseInt($('#F9 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F9").html(select);
	}
});
$("#remove9").click(function(){
	var q = parseInt($("#F9 option:selected" ).val());
	if(q>0){
		var aq = parseInt($("#addedquantity9").val());
		if(aq==1)
			$("#combo").val(parseInt($("#combo").val()) - 1);
		aq=aq-q;
		$("#addedquantity9").val(aq);
		var p = parseInt($("#price" ).val());
		var fp = parseInt($("#fp9").val());
		p=p-(q*fp);
		$("#price").val(p);
		var combo = parseInt($("#combo").val());
		if((combo==3)&&(p>=100))
			$("#submit").attr('disabled',false);
		else
			$("#submit").attr('disabled',true);
		var select = "";
		var lastValue = parseInt($('#F9 option:last-child').val());
		var newval = lastValue-q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#F9").html(select);
		select="";
		lastValue = parseInt($('#f9 option:last-child').val());
		newval= lastValue+q;
		for(j=0;j<=newval;j++){
			select +="<option value=\""+ j + "\">" + j + "</option>";
		}
		$("#f9").html(select);
	}
});
});