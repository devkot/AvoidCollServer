import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackfak on 2/1/2017.
 */

public class DoTheJob {
    public static float pvaluex = 0;
    public static float pvaluey = 0;
    public static float pvaluez = 0;
    public static String pid="null";
    public static String id = "null";
    public static boolean collision = false;
    public static long timef = 0;
    public Thread t;
    public DoTheJob(String top, String mes,String time) {
        float valuex=0;
        float valuey=0;
        float valuez=0;
        float speed;
        float x = 0;
        float y = 0;
        String lat=null;
        String lon=null;
        boolean dcol = false;
        int i=0,j=0,n=0;
        List<String> strM;
        strM = new ArrayList<>();
        strM.add(0,mes);
        List<String> str;
        str = new ArrayList<>();
        str.add(0, top);
        for (String RR : str.get(0).split("/")) {
            if(i==1) {
                switch (RR) {

                    case "Light":
                        if(!(id.equals(pid))){
                            dcol=true;
                            System.out.println("different ids true");
                        }
                        System.out.println("listening to light sensor");
                        for(String RRM : strM.get(0).split("/")){
                            if(j==0) {
                                x = Float.parseFloat(RRM);
                            }
                            if(j==1){
                                lat=RRM;
                            }
                            if(j==2){
                                lon=RRM;
                            }
                            if(dcol && collision){
                                System.out.println("Timef - Current="+(System.currentTimeMillis()-timef));
                                if ((System.currentTimeMillis()-timef)<1000) {
                                    t=new Thread(new PubCaller("Light/Confirmed","Collision Confirmed "+time));
                                    t.start();
                                    try {
                                        t.join();
                                    } catch (InterruptedException ie) {
                                        ie.printStackTrace();
                                    }
                                    //Publisher.main("Light/Confirmed","Collision Confirmed "+time);
                                    String s="Light,"+Float.toString(x);
                                    try {
                                        SampleMain.main(id,lat+"-"+lon,s,time,dcol);
                                    } catch (MqttException e) {
                                    }
                                    System.out.println("Between "+id+" and "+pid);
                                }

                            }
                            if(x<40.0){
                                collision=true;
                                timef=System.currentTimeMillis();
                                t=new Thread(new PubCaller("Light/Danger/"+id,"Danger!!! Low Light!!! "+time));
                                t.start();
                                try {
                                    t.join();
                                } catch (InterruptedException ie) {
                                    ie.printStackTrace();
                                }
                                //Publisher.main("Light/Danger","Danger!!! Low Light!!! "+time);
                                String s="Light,"+Float.toString(x);
                                try {
                                    SampleMain.main(id,lat+"-"+lon,s,time,dcol);
                                } catch (MqttException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("Timef ="+timef);
                            }else{
                                collision=false;

                            }
                        }
                        break;
                    case "Proximity":
                        if(!(id.equals(pid))){
                            dcol=true;
                            System.out.println("different ids true");
                        }
                        System.out.println("listening to proximity sensor");
                        for(String RRM : strM.get(0).split("/")) {
                            if (n == 0) {
                                y = Float.parseFloat(RRM);
                            }
                            if (n == 1) {
                                lat = RRM;
                            }
                            if (n == 2) {
                                lon = RRM;
                            }
                            n++;
                        }

                            System.out.println("dcol "+dcol+" collision "+collision);
                            if(dcol && collision){
                                if ((System.currentTimeMillis()-timef)<1000) {
                                    t=new Thread(new PubCaller("Proximity/Confirmed","Collision Confirmed "+time));
                                    t.start();
                                    try {
                                        t.join();
                                    } catch (InterruptedException ie) {
                                        ie.printStackTrace();
                                    }
                                    //Publisher.main("Proximity/Confirmed","Collision Confirmed "+time);
                                    String s="Proximity,"+Float.toString(y);
                                    try {
                                        SampleMain.main(id,lat+"-"+lon,s,time,dcol);
                                    } catch (MqttException e) {
                                        e.printStackTrace();
                                    }
                                    System.out.println("Between "+id+" and "+pid);
                                }

                            }
                            if(y==0.0){
                                collision=true;
                                timef=System.currentTimeMillis();
                                t=new Thread(new PubCaller("Proximity/Danger"+id,"Danger!!! To close to Object "+time));
                                t.start();
                                try {
                                    t.join();
                                } catch (InterruptedException ie) {
                                    ie.printStackTrace();
                                }
                                //Publisher.main("Proximity/Danger","Danger!!! To close to Object "+time);
                                String s="Proximity,"+Float.toString(y);
                                try {
                                    SampleMain.main(id,lat+"-"+lon,s,time,dcol);
                                } catch (MqttException e) {
                                    e.printStackTrace();
                                }
                            }else{
                                collision=false;

                            }
                        break;
                    case "Acceleration":
                        if(!(id.equals(pid))){
                            dcol=true;
                            System.out.println("different ids true");
                        }
                        System.out.println("listening to Acceleration sensor");
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
                            if(k==3){
                                lat=RRM;
                            }
                            if(k==4){
                                lon=RRM;
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
                        if(dcol && collision){
                            System.out.println("Timef - Current="+(System.currentTimeMillis()-timef));
                            if ((System.currentTimeMillis()-timef)<1000) {
                                t=new Thread(new PubCaller("Acceleration/Confirmed","Collision Confirmed "+time));
                                t.start();
                                try {
                                    t.join();
                                } catch (InterruptedException ie) {
                                    ie.printStackTrace();
                                }
                                //Publisher.main("Acceleration/Confirmed","Collision Confirmed "+time);
                                String s="Acceleration,"+Float.toString(speed);
                                try {
                                    SampleMain.main(id,lat+"-"+lon,s,time,dcol);
                                } catch (MqttException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("Between "+id+" and "+pid);
                            }

                        }
                        if(speed>2.0){
                            collision=true;
                            timef=System.currentTimeMillis();
                            t=new Thread(new PubCaller("Acceleration/Danger"+id,"Danger!!! Moving too Fast "+time));
                            t.start();
                            try {
                                t.join();
                            } catch (InterruptedException ie) {
                                ie.printStackTrace();
                            }
                            //Publisher.main("Acceleration/Danger","Danger!!! Moving too Fast "+time);
                            String s="Acceleration,"+Float.toString(speed);
                            try {
                                SampleMain.main(id,lat+"-"+lon,s,time,dcol);
                            } catch (MqttException e) {
                                e.printStackTrace();
                            }

                        }else{
                            collision=false;
                        }
                        break;
                    default:
                        break;

                }
            }
            if(i==0) {
                if (!(RR.equals("Proximity") || RR.equals("Light") || RR.equals("Acceleration"))) {
                    id = RR;
                }
            }
            i++;
        }
        pid=id;
    }
}
