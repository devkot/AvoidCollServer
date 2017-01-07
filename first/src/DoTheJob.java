import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackfak on 2/1/2017.
 */
public class DoTheJob {
    public static float pvaluex = 0;
    public static float pvaluey = 0;
    public static float pvaluez = 0;
    public static int pspeed = 0;
    public static String pid = null;
    public DoTheJob(String top, String mes) {

        float valuex=0;
        float valuey=0;
        float valuez=0;
        float speed;
        int i=0,j=0;
        List<String> strM;
        strM = new ArrayList<>();
        strM.add(0,mes);
        List<String> str;
        str = new ArrayList<>();
        str.add(0, top);
        String Ltopic = new String();
        String id;
        for (String RR : str.get(0).split("/")) {
            /*if(i==2){
                switch (Ltopic){
                    case "Light":

                        break;
                    case "Proximity":
                        if(i == 2){
                            float y = Float.parseFloat(RR);
                            if(y==0.0){
                                System.out.println("Danger!!! Too close to Object!!!");
                            }
                        }
                        break;
                }
            }*/
            if(i==1) {
                switch (RR) {
                    case "Light":
                        System.out.println("listening to light sensor");
                        Ltopic = RR;
                        for(String RRM : strM.get(0).split("/")){
                            float x=Float.parseFloat(RRM);
                            if(x<40.0){
                                //System.out.println("Danger!!! Low Light!!!");
                                Publisher.main("Danger/","Danger!!! Low Light!!!");
                            }
                        }
                        break;
                    case "Proximity":
                        System.out.println("listening to proximity sensor");
                        Ltopic = RR;
                        for(String RRM : strM.get(0).split("/")){
                            float y=Float.parseFloat(RRM);
                            if(y==0.0){
                                //System.out.println("Danger!!! To close to Object");
                                Publisher.main("Danger/","Danger!!! To close to Object");
                            }
                        }

                        break;
                    case "Acceleration":
                        System.out.println("listening to Acceleration sensor");
                        Ltopic = RR;
                        int k=0;
                        for(String RRM : strM.get(0).split("/")){
                            if(k==0) {
                                valuex = Float.parseFloat(RRM);
                            }
                            if(k==1) {
                                valuey = Float.parseFloat(RRM);
                            }
                            if(k==2) {
                                valuez = Float.parseFloat(RRM);
                            }
                            k++;
                        }
                        speed= (int) Math.abs(Math.sqrt(valuex+valuey+valuez));
                        System.out.println(" x=" + pvaluex + " y=" + pvaluey + " z=" +pvaluez);
                        System.out.println(" x=" + valuex + " y=" + valuey + " z=" +valuez);
                        System.out.println("speed="+speed);
                        System.out.println("pspeed="+pspeed);
                        pvaluex=valuex;
                        pvaluey=valuey;
                        pvaluez=valuez;
                        pspeed=(int) Math.abs(Math.sqrt(pvaluex+pvaluey+pvaluez));
                        break;
                    default:
                        break;

                }
            }
            if(i==0){
                id=RR;
                System.out.println(id);
                //System.out.println(pid);
                pid=id;
            }
            i++;
        }

        //search List<String>

    }
}
