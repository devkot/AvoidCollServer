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


        //System.out.println(threadmes);






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
        switch (threadtop){
            case "Proximity":
                if(threadmes=="0.0"){
                    String alertP = "Danger too close to Object";
                    Publisher.main(threadtop,alertP);
                }
                break;

            case "Light":
                float x = Float.valueOf(threadmes);
                if(x<40.0){

                    String alertL="Danger Lightning too low";
                    Publisher.main(threadtop,alertL);
                }
                break;

            default: break;
        }


    }
}
