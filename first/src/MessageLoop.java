/**
 * Created by jackfak on 22/12/2016.
 */
    public class MessageLoop implements Runnable {
        private String threadarr[];
        public MessageLoop(String[] text) {
            threadarr=text;
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
            Subscriber.main(threadarr);

        }


}

