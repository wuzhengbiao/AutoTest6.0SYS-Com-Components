package Com;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ModifyWindowsTime {
    public static void SetSystemTime(String time){
        DosCommand servertime = new DosCommand();
        try{
            /**
             * 获取操作系统的名称
             * */
            String name = System.getProperty("os.name");
            if(name.contains("Windows")){	// Window 操作系统
                servertime.RunDosCommand("time "+time);
            }
        }catch(Exception e){
            e.printStackTrace();
    }
}
    public static String GetCurrentSystemTime(){
        Calendar ca = Calendar.getInstance();
        String hour=Integer.toString(ca.get(Calendar.HOUR_OF_DAY));//小时
        int   intminute=ca.get(Calendar.MINUTE);
        //System.out.print("spendtime :"+spendtime+"\n");
        int   intseconds=ca.get(Calendar.SECOND)+12;
        if(intseconds>60)
        {
            intminute=intminute+1;
            System.out.print("intminute +1 :"+intminute+"\n");
            intseconds=intseconds-60;
            System.out.print("intseconds -60 :"+intseconds+"\n");
        }
        String minute=Integer.toString(intminute);//分
        String second=Integer.toString(intseconds);//秒
        String longtime=hour+":"+minute+":"+second;
        System.out.print("CurrentSystemTime ="+longtime+"\n");
        return longtime;

    }
    public  static String ReturnCurrentSystemTime(String time){
        int returnhour=0;
        int returnminute=0;
        int returnsecon=0;
        String returnlongTime="";
        System.out.print("CurrentSystemTime ="+WhetherOpenService.CurrentTime+"\n");
        returnlongTime=Integer.toString(returnhour)+":"+Integer.toString(returnminute)+":"+Integer.toString(returnsecon);
        return returnlongTime;
    }
}
