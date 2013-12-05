$("#btn_Submit").click(function() {
    //var isbn = this.id;
	var user= $("#username").val();
	var pass=$("#password").val();
    $.ajax({
    url: "/v1/users/login",
    type: 'POST',
    async: 'false',
    data:'username='+user+'&password='+pass,
    contentType: 'application/x-www-form-urlencoded',
    success: function(response) {
    	//alert(response.username);
    	$('#usrnm').text(response.username);
    	$('#deptnm').text(response.department);
    	//alert("hell"+$('#usrnm').text()+"HELL"+$('#deptnm').text());
    	

    $("#Admin").show();
	 $("#login").hide();
	 if(location.port==9001)

	 {

	 $("#delete").hide();

	 }
	 
	fireWater();
	 fireWater2();
	 //storeListener();
	 
    },
    error: function(data,status,er){
    	    	
    	alert("You are Invalid User!!!Please enter Correct Credentials");
    	console.log("error ", data.error+""+status)}
    	
    });
});

$("#btn_Reg").click(function() {
	
	$("#login_form").attr("action","/register");
	
});

$("#reg_Submit").click(function() {
    //var isbn = this.id;
	var user= $("#username").val();
	var pass=$("#password").val();
	var fname=$("#firstname").val();
	var lname=$("#lastname").val();
	var email=$("#email").val();
	var phno=$("#phno").val();
	var dept=$("#dept").val();	
    alert('in ajax');
    $.ajax({
    url: "v1/users",
    type: 'POST',
    async: 'false',
    data:'username='+user+'&password='+pass+'&firstname='+fname+'&lastname='+lname+'&email='+email+'&phno='+phno+'&dept='+dept,
    contentType: 'application/x-www-form-urlencoded',
    success: function(response) {
   
   
    },
    error: function(data,status,er){
    	
    	 alert("You are Successfully  Registered!");
    	
    });
});

$("#personbtn_Send").click(function() {
    var username= $("#txt_person").val();
	$.ajax({
    url: "/v1/users/personEmail",
    type: 'POST',
    async: 'false',
    data:'username='+username,
    contentType: 'application/x-www-form-urlencoded',
    success: function(response) {
    	 
    },
    error: function(data,status,er){
    }
    });
});