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
        String minute=Integer.toString(ca.get(Calendar.MINUTE));//分
        String second=Integer.toString(ca.get(Calendar.SECOND));//秒
        String longtime=hour+":"+minute+":"+second;
        System.out.print("CurrentSystemTime ="+longtime+"\n");
        return longtime;
    }
    public  static String ReturnCurrentSystemTime(int time){
        String[] stringValueList = WhetherOpenService.CurrentTime.split(":");
        int returnhour=Integer.parseInt(stringValueList[0]);
        int returnminute=Integer.parseInt(stringValueList[1]);
        int returnsecon=Integer.parseInt(stringValueList[2])+time;
        String returnlongTime="";//返回的时间
        if(returnsecon>=60)
        {
            returnminute=returnminute+1;
            System.out.print("intminute +1 :"+returnminute+"\n");
            returnsecon=returnsecon-60;
            System.out.print("intseconds -60 :"+returnsecon+"\n");
            if(returnminute>=60)
            {
                returnhour=returnhour+1;
                System.out.print("returnhour +1 :"+returnhour+"\n");
                returnminute=returnminute-60;
                System.out.print("returnminute -60 :"+returnminute+"\n");
            }
        }
        returnlongTime=Integer.toString(returnhour)+":"+Integer.toString(returnminute)+":"+Integer.toString(returnsecon);
        System.out.print("returnlongTime ="+returnlongTime+"\n");
        return returnlongTime;
    }
}
