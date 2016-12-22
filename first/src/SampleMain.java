import org.eclipse.paho.client.mqttv3.*;

/**
 * Created by jackfak on 19/12/2016.
 */
public class SampleMain {
    public static void main(String args[]) throws MqttException {
        String text[]={"danger"," be"};
        Subscriber.main(text);
        //Publisher.main(text);



        //sub.messageArrived(topic , mes);
        //System.out.println("inside main\n\n\n\nBB");
    }
    public static void Job(boolean subcall) {
        if (subcall) {
            String text1[] = {"danger", "do something"};
            Publisher.main(text1);
        }
    }
}
