import org.eclipse.paho.client.mqttv3.*;

/**
 * Created by jackfak on 19/12/2016.
 */
public class SampleMain {
    public static void main(String[] args) throws MqttException {
        Subscriber sub = new Subscriber();

        String mes = "Hallo !!!" ;
        MqttClient myClient = null;
        String myTopic = " ";
        MqttTopic topic = myClient != null ? myClient.getTopic(myTopic) : null;
        MqttMessage message = new MqttMessage(mes.getBytes());
        message.setQos(2);
        message.setRetained(false);
        //publishing
        System.out.println("publishing my message with QOS 2");
        MqttDeliveryToken token = null;
        try {
            // publish message to broker
            token = topic != null ? topic.publish(message) : null;
            // Wait until the message has been delivered to the broker
            if (token != null) {
                token.waitForCompletion();
            }
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //sub.messageArrived(topic , mes);
        System.out.println("inside main\n\n\n\nBB");
    }
}
