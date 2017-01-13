/**
 * Created by jackfak on 13/1/2017.
 */
public class MainServerClass {
    public static void main(String args[]){
        new Thread(new SubCaller()).start();
    }
}
