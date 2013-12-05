$(document).ready(function (){
    if (window.WebSocket) {

        var url = "ws://54.219.156.168:61623";
        var login = "admin";
        var passcode = "password";

        if (location.port == 9001) {
            var destination = "/topic/isns.store";
        

        client = Stomp.client(url, "stomp");
        client.connect(login, passcode, function () {
            client.debug("connected to Stomp Listener");
            var sub1 = client.subscribe(destination, function (message) {
                var res = message.body;
                alert(res);


            });
                   });
    }
    }
});