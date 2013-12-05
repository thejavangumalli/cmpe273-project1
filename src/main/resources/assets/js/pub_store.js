function fireMe()
{
        if(window.WebSocket) {
                var url = "ws://54.219.156.168:61623";
                var login = "admin";
                var passcode = "password";
                var destination2 = "/topic/isns.store";
                client = Stomp.client(url, "stomp");
                client.connect(login, passcode, function() {
                        client.debug("connected to Stomp");
						var msg_to_send=document.getElementById("txtArea_Id").value;
                        var sub2 = client.send(destination2,{},msg_to_send);
                });
        }
 
}