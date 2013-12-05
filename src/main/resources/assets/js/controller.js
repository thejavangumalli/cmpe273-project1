function deptClicked(){
$("#deptWide").show();
$("#streWide").hide();
$("#person").hide();

setTimeout("fireWater2()",5000);
}
function personClicked(){
	$("#deptWide").hide();
	$("#streWide").hide();
	$("#person").show();
	//setTimeout("fireWater()",5000);
	
	}
function storeClicked(){
	$("#deptWide").hide();
	$("#streWide").show();
	$("#person").hide();
	//setTimeout("storeListener()",5000);
	
	}
function searchUserByDept(){

	var dname = $('#deptnm').text();

	var URL = "/v1/users/display/"+dname;

	$.ajax({

	url: URL,

	type: 'GET',

	async: 'false',

	contentType: 'application/x-www-form-urlencoded',

	success: function(response) {

	var names = new Array();

	for(var i=0; i<response.username.length;i++)

	{

	names[i]=response.username[i];

	}

	alert("The Users in the "+dname+" Department are : "+names);

	},

	error: function(data,status,er){

	alert("Unable to Delete at this moment!!!");

	}

	 

	});

	}