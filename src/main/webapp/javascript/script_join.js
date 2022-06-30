var status = true;

$(document).ready(function(){
     $(".agree1").click(function(){
        // #modal과 일치하는 요소에 'active'클래스를 추가함 
        $("#layer1").addClass("active");
     });

     // .btn 요소를 클릭하면
     $(".btn").click(function(){
         // #modal의 'active'클래스를 삭제함
        $("#layer1").removeClass("active");
     });

     $(".agree2").click(function(){
        // #modal과 일치하는 요소에 'active'클래스를 추가함 
        $("#layer2").addClass("active");
     });

     // .btn 요소를 클릭하면
     $(".btn").click(function(){
         // #modal의 'active'클래스를 삭제함
        $("#layer2").removeClass("active");
     });
     
     
     // 아이디 중복확인
     	$("#checkId").click(function(){
	  	if($("#id").val()){
		var query = {id:$("#id").val()};
		
	    $.ajax({
	    	type:"post",
	    	url:"confirmId.jsp",
	    	data:query,
	    	success:function(data){
	    		if(data == 1){
	    			alert("사용할 수 없는 아이디");
	    	    	$("#id").val("");
	    	     }else if(data == 0)
	    	  	    alert("사용할 수 있는 아이디");
	 	    }
	    });
	  }else{
		  alert("사용할 아이디를 입력");
		  $("#id").focus();
	  }
	});
	
	$('#email_behind_sel').change(function(){ 
		$("#email_behind_sel option:selected").each(function(){
			if($(this).val()== '1') {
				$("#email_self").val('');
				$("#email_self").attr("readonly",false);
			} else { 
				$("#email_self").val($(this).text()); 
				$("#email_self").attr("readonly",true);
			}
		});
    });
});

