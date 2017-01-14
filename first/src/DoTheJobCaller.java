/**
 * Created by jackfak on 13/1/2017.
 */
public class DoTheJobCaller implements Runnable {
    private String topic;
    private String message;
    private String time;


    public DoTheJobCaller(String top,String mes,String t){
        this.topic=top;
        this.message=mes;
        this.time=t;
    }
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        new DoTheJob(topic,message,time);
        if(Thread.interrupted()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
