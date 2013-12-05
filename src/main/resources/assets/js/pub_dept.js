function fireMeDept()
{
        if(window.WebSocket) {
        		var deptNm=document.getElementById("txt_dept").value;
                var url = "ws://54.219.156.168:61623";
                var login = "admin";
                var passcode = "password";
                var destination5 = "/topic/isns.dept."+deptNm;
                client = Stomp.client(url, "stomp");
                client.connect(login, passcode, function() {
                        client.debug("connected to Stomp dept pub");
						var msg_to_send=document.getElementById("depttxtArea_Id").value;
                        var sub5 = client.send(destination5,{},msg_to_send);
                });
        }
 
}