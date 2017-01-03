/**
 * Created by jackfak on 22/12/2016.
 */
public class Message {
    static void threadMessage(String  message){
        String threadname = Thread.currentThread().getName();
        System.out.println(threadname + " " + message);
    }
}
