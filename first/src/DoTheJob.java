/**
 * Created by jackfak on 2/1/2017.
 */
public class DoTheJob  implements Runnable{
    private String threadtop;
    private String threadmes;
    public DoTheJob(String arg[]){
        //Publisher.main(args);
        threadtop=arg[0];
        threadmes=arg[1];



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
    public void run() {
        String pub[]={threadtop,threadmes};
        boolean stop = false;
        while(!stop){
            Publisher.main(pub);
            stop=true;

        }


        //System.out.println("thread exit");


    }
}
