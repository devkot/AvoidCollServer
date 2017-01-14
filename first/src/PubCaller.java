/**
 * Created by jackfak on 13/1/2017.
 */
public class PubCaller implements Runnable {
    private String message;
    private String topic;


    public PubCaller(String top,String mes){
        this.topic=top;
        this.message=mes;

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
        Publisher.main(topic,message);
        if(Thread.interrupted()){
            try {
                Thread.currentThread(). sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
