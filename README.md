# Intrusion-Detection-System-using-Passive-Infrared-Sensors-and-SMTP

Passive Infrared Sensor's also popularly known as PIR sensors are infrared sensors that are used for various purposes.
We used the Infrared Sensor to detect intrusion. 

![publish message](https://raw.githubusercontent.com/imjuoy/Intrusion-Detection-System-using-Passive-Infrared-Sensors-and-SMTP/master/PIR_Sensors.png)

The PIR sensors work as mentioned in the below screenshot.

![publish message](https://raw.githubusercontent.com/imjuoy/Intrusion-Detection-System-using-Passive-Infrared-Sensors-and-SMTP/master/HowItWorks.png)

When there is a energy difference between two halves of the sensor, an ouput signal is sent indicating movment in front of the sensor.
The sensor generally sends signals between 0 - 2047.
When there is a movement the sensor sends a signal between 2048 - 4095

We used the below setup to connect the PIR sensor to a Photon particle.

![publish message](https://raw.githubusercontent.com/imjuoy/Intrusion-Detection-System-using-Passive-Infrared-Sensors-and-SMTP/master/Setup.jpg)

Then we used ThingSpeak to publish the signals of the PIR sensor captured by respective pins of the Particle Photon. Once the signals were published in to the cloud
we used a simple web client to relay the signals to an HTML GUI.
We also implemented a mail client that would send emails to configured mail id's based on the frequency of intrusions.

This project is therefore a end to end implementation of an intrusion detection system based using PIR sensors, Particle Photon, ThingsSpeak and SMTP.

