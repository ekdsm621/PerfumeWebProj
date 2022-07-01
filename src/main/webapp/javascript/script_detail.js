jQuery(document).ready(function(){

      $("#minus").click(function(){
      	let amount = $("#amount").val() - 1;
      	if(($("#amount").val()) > 0){
      		$("#amount").val(amount)
      	}
      });

	$("#cart").click(function(){
		if($("#amount").val() > 0){
			var query = {id:$("#id").val(), amount:$("#amount").val()};
			$.ajax({
				type:"post",
		    	url:"/setcart.do",
		    	data:query,
		    	success:function(data){
		    		if(data == 1){
		    			alert("장바구니에 추가되었습니다");
		    	     }
		 	    }
			});
		}
	});
	
	$("#plus").click(function(){
		var total = $("#amount").val().Number() * $("#price").val().Number();
		$("#totalPrice").replace($("#amount").val().Number() * $("#price").val().Number());
	});
});