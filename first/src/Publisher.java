import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Created by jackfak on 16/12/2016.
 */
public class Publisher {
    public static void main(String[] args) {
        String topic = args[0];
        String content =args[1];
        int qos = 2;
        String broker = "tcp://localhost:1883";
        String clientId = " JavaSamplePublisher ";
        MemoryPersistence persistence = new MemoryPersistence();
        //Publisher publish = new Publisher();

        try {
//Connect to MQTT Broker
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
//Publish message to MQTT Broker

            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            sampleClient.disconnect();
            System.out.println("Disconnected");
            /*try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            //System.exit(0);

        } catch(MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println(" msg " + me.getMessage());
            System.out.println(" loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println(" excep " + me);
            me.printStackTrace();
        }
    }
}
