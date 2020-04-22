// var ws;
// function connect() {
//     ws = new WebSocket('ws://localhost:8080/ws');
//
//     ws.onmessage = onMessageReceived;
//
//     ws.onclose = function(e) {
//         console.log('Socket is closed. Reconnect will be attempted in 1 second.', e.reason);
//         setTimeout(function() {
//             connect();
//         }, 1000);
//     };
//
//     ws.onerror = function(err) {
//         console.error('Socket encountered error: ', err.message, 'Closing socket');
//         ws.close();
//     };
// }
//
// connect();

function connect() {

    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, onConnected, onError);
}

// Connect to WebSocket Server.
connect();

function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/speech', onMessageReceived);
}

function onError(error) {
    console.log("Error while connecting");
    console.log(error);
    setTimeout(connect, 10000);
}

function speech() {
    var text = document.getElementById("text");
    var voice = document.getElementById("voice");
    var pitch = document.getElementById("pitch");
    var rate = document.getElementById("rate");
    var volume = document.getElementById("volume");
    responsiveVoice.speak(
        text.value,
        voice.value,
        {
            pitch: pitch.value,
            rate: rate.value,
            volume: volume.value
        }
    );
}

function sendMessage() {
    var text = document.getElementById("text");
    var voice = document.getElementById("voice");
    var pitch = document.getElementById("pitch");
    var rate = document.getElementById("rate");
    var volume = document.getElementById("volume");
    if (stompClient) {
        var voiceMessage = {
            text: text.value,
            voice: voice.value,
            voiceConfig: {
                pitch: pitch.value,
                rate: rate.value,
                volume: volume.value
            }
        };
        stompClient.send("/app/speech", {}, JSON.stringify(voiceMessage));

        // ws.send(JSON.stringify(voiceMessage));
    }
}

function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);

    responsiveVoice.speak(message.text, message.voice, message.voiceConfig);
}

