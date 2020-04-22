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
    // stompClient.subscribe('/topic/sound', onSound)
}

function onError(error) {
    console.log("Error while connecting");
    console.log(error);
    setTimeout(connect, 10000);
}


// function onSound(payload) {
//     var snd = new Audio("data:audio/mp3;base64," + payload.body);
//     snd.play();
// }


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
    }
}


function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);

    responsiveVoice.speak(message.text, message.voice, message.voiceConfig);
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