function fireWater() {
    if (window.WebSocket) {
   
        var url = "ws://54.219.156.168:61623";
        var login = "admin";
        var passcode = "password";

        if (location.port == 9001) {
        	
        		var userNm=document.getElementById("username").value;
            var destination4 = "/queue/isns.person."+userNm;
       

        client = Stomp.client(url, "stomp");
        client.connect(login, passcode, function () {
            client.debug("connected to Stomp Listener");
            var sub4 = client.subscribe(destination4, function (message) {
                var res = message.body;
                alert(res);


            });
            
            
                   });
    
  }
    }
    }