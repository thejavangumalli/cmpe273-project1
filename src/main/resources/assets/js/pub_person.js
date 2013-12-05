function fireMePerson()
{
        if(window.WebSocket) {
        		var userNm=document.getElementById("txt_person").value;
                var url = "ws://54.219.156.168:61623";
                var login = "admin";
                var passcode = "password";
                var destination3 = "/queue/isns.person."+userNm;
                client = Stomp.client(url, "stomp");
                client.connect(login, passcode, function() {
                        client.debug("connected to Stomp");
						var msg_to_send=document.getElementById("persontxtArea_Id").value;
                        var sub1 = client.send(destination3,{},msg_to_send);
                });
        }
 
}