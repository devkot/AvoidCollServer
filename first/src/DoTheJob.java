import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackfak on 2/1/2017.
 */
public class DoTheJob {
    public static float pvaluex = 0;
    public static float pvaluey = 0;
    public static float pvaluez = 0;
    public static String pid=null;
    public static String id = null;
    public static boolean collision = false;
    public static boolean dcol = false;
    public static long timef = 0;
    public static float pspeed = 0;
    public DoTheJob(String top, String mes,String time) {
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
        pid=id;
        for (String RR : str.get(0).split("/")) {
            if(i==1) {
                switch (RR) {

                    case "Light":
                        if(!(id.equals(pid))){
                            dcol=true;
                            System.out.println("different ids true");
                            //timef=System.currentTimeMillis();
                            //System.out.println("Timef ="+timef);
                        }
                        System.out.println("listening to light sensor");
                        for(String RRM : strM.get(0).split("/")){
                            float x=Float.parseFloat(RRM);
                            if(x<40.0){
                                collision=true;

                                Publisher.main("Light/Danger","Danger!!! Low Light!!!");
                                System.out.println("Timef ="+timef);
                            }
                            if(dcol && collision){
                                System.out.println("Timef - Current="+(System.currentTimeMillis()-timef));
                                if ((System.currentTimeMillis()-timef)<1000) {

                                    Publisher.main("Proximity/Confirmed","Collision Confirmed"+time);
                                }

                            }
                        }
                        break;
                    case "Proximity":
                        if(!(id.equals(pid))){
                            dcol=true;
                            System.out.println("different ids true");
                            //timef=System.currentTimeMillis();
                            //System.out.println("Timef ="+timef);
                        }
                        System.out.println("listening to proximity sensor");
                        for(String RRM : strM.get(0).split("/")){
                            float y=Float.parseFloat(RRM);
                            if(y==0.0){
                                collision=true;
                                //timef=System.currentTimeMillis();
                                Publisher.main("Proximity/Danger","Danger!!! To close to Object");
                            }
                            System.out.println("dcol "+dcol+"collision"+collision);
                            if(dcol && collision){
                                System.out.println("timef="+timef+" Current="+System.currentTimeMillis());
                                System.out.println("Timef - Current="+(System.currentTimeMillis()-timef));
                                if ((System.currentTimeMillis()-timef)<1000) {

                                    Publisher.main("Proximity/Confirmed","Collision Confirmed"+time);
                                }

                            }
                        }
                        break;
                    case "Acceleration":
                        if(!(id.equals(pid))){
                            dcol=true;
                            System.out.println("different ids true");
                            //timef=System.currentTimeMillis();
                            //System.out.println("Timef ="+timef);
                        }
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
                        speed= Math.abs(valuex+valuey+valuez-pvaluex-pvaluey-pvaluez);
                        System.out.println(" x=" + valuex + " y=" + valuey + " z=" +valuez);
                        System.out.println("speed="+speed);
                        pvaluex=valuex;
                        pvaluey=valuey;
                        pvaluez=valuez;
                        //speedcase if
                        if(speed>2.0){
                            collision=true;
                            timef=System.currentTimeMillis();
                            Publisher.main("Acceleration/Danger","Danger!!! Moving too Fast");

                        }
                        if(dcol && collision){
                            System.out.println("Timef - Current="+(System.currentTimeMillis()-timef));
                            if ((System.currentTimeMillis()-timef)<1000) {

                                Publisher.main("Acceleration/Confirmed","Collision Confirmed"+time);
                            }

                        }
                        break;
                    default:
                        break;

                }
            }
            if(i==0) {
                if (!(RR.equals("Proximity") || RR.equals("Light") || RR.equals("Acceleration"))) {
                    id = RR;
                    //System.out.println("now " + id + " previous " + pid);
                }

            }
            i++;
        }
        if(!(id.equals(pid))){
            dcol=true;
            System.out.println("different ids true");
            timef=System.currentTimeMillis();
            System.out.println("Timef ="+timef);
        }else{
            dcol=false;
        }
    }
}
