function fireWater2() {
    if (window.WebSocket) {
   
        var url = "ws://54.219.156.168:61623";
        var login = "admin";
        var passcode = "password";

        if (location.port == 9001) {
        	
        		var deptNm=$('#deptnm').text();
            var destination6 = "/topic/isns.dept."+deptNm;
       

        client = Stomp.client(url, "stomp");
        client.connect(login, passcode, function () {
            client.debug("connected to Stomp Listener");
            var sub6 = client.subscribe(destination6, function (message1) {
                var res = message1.body;
                alert(res);


            });
                   });
    
  }
    }
}