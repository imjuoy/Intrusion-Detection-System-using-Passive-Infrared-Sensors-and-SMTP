// Port of the broker
var loc = {'port' : '9002' };
// Connects with the broker
client = new Paho.MQTT.Client(location.hostname, Number(loc.port), 'dvirmani_sub');

// set callback handlers
client.onConnectionLost = onConnectionLost;
client.onMessageArrived = onMessageArrived;

// connects with the client
client.connect({onSuccess:onConnect});

// called when the client connects, subscribes to the messages with topic 
// DiceRolling
function onConnect() {
    client.subscribe("intrusion");
}

// called when the client loses its connection
function onConnectionLost(responseObject) {
  if (responseObject.errorCode !== 0) {
    console.log("onConnectionLost:"+responseObject.errorMessage);
  }
}

// called when a message arrives, prints the message to the HTML
function onMessageArrived(message) {
    var time = new Date().toLocaleString();
    var intrusion = JSON.parse(message.payloadString);
    var ele = document.getElementById('timelist');
    var node = document.createElement("li"); 
    var textnode = document.createTextNode(time); 
    node.appendChild(textnode); 
    ele.appendChild(node);
    var request=new XMLHttpRequest();
    request.open("POST", "http://localhost:8090/IntrusionSystem/intrusion" , true);
    request.send();
}
