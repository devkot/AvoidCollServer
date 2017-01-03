import org.eclipse.paho.client.mqttv3.*;

/**
 * Created by jackfak on 19/12/2016.
 */
public class SampleMain {
    public static void main(String args[]) throws MqttException {
        String text1[]={"light","lightAvo"};
        Thread t0=new Thread (new MessageLoop(text1));
        t0.start();
        String text2[]={"acceleration","accelAvo"};
        Thread t1 = new Thread(new MessageLoop(text2));
        t1.start();
        String text3[]={"proximity","ProxAvo"};
        Thread t2 = new Thread(new MessageLoop(text3));
        t2.start();




    }

}
