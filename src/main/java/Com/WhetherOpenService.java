package Com;
import java.util.List;

public class WhetherOpenService {
    public static String CurrentTime;
    //public String CurrentTime="";
    public static int GetMacacaServer() {

        int SeverTime = 30;
        int ValueNumber;
        int ServerResultNumber;
        int PortNumber;
        int PortResultNumber;
        ConfigurationEnvironmentStart serverStart=new ConfigurationEnvironmentStart();
        String Macacainformation = "";//获取macaca服务信息
        String PidValue="";
        String RealPid="";//获取正确pid值
        String Port="";//端口号
        //String time="";
        String MacacainformationPort= "";//根据macaca服务的pid获取端口信息
        DosCommand servercheck = new DosCommand();
        CurrentTime=ModifyWindowsTime.GetCurrentSystemTime();
        try {
            List<String> MacacaServer = servercheck.RunDosCommand("tasklist|find /i \"node.exe\"");//查找macaca服务
            if (MacacaServer.size() == 0) {
                //serverStart.RunServerBat("CallMacacaServer");
                ModifyWindowsTime.SetSystemTime("04:59:50");
            }
            for (int i = 0; i <= SeverTime; i++) {
                List<String> ServerResult = servercheck.RunDosCommand("tasklist|find /i \"node.exe\"");//查找macaca服务
                if (ServerResult.size() != 0) {
                    for (ValueNumber = 0; ValueNumber < ServerResult.size(); ValueNumber++) {
                        Macacainformation = ServerResult.get(ValueNumber);
                        String[] StringValueList = Macacainformation.split("\\s+");
                        for (ServerResultNumber = 0; ServerResultNumber < StringValueList.length; ServerResultNumber++) {
                            //System.out.println("Characters after removing spaces :" + StringValueList[ServerResultNumber]);
                            if (StringValueList[ServerResultNumber].contains("Console") || StringValueList[ServerResultNumber].contains("RDP") || StringValueList[ServerResultNumber].contains("Ser")) {
                                PidValue = StringValueList[ServerResultNumber - 1];
                                System.out.println("Find the Judgment Conditions ,So PidValue= :" + PidValue);
                                break;
                            } else {
                                PidValue = StringValueList[1];
                                //System.out.println("No Contain Everything ,So PidValue= :" + PidValue);
                            }
                            List<String> PidResult = servercheck.RunDosCommand("netstat -ano | findstr " + PidValue);
                           // System.out.println("PidResult :" + PidResult.size());
                            if (PidResult.size() != 0)//找到正确的pid值才进入循环
                            {
                                RealPid=PidValue;//找到正确的pid并赋值
                                System.out.println("ReturnPid :"+PidValue);
                                List<String> PortResult = servercheck.RunDosCommand("netstat -ano | findstr "+RealPid);
                                for (PortNumber = 0; PortNumber < PortResult.size(); PortNumber++)
                                {
                                    MacacainformationPort=PortResult.get(PortNumber);
                                    String [] StringValuePort=MacacainformationPort.split("\\s+");
                                    for(PortResultNumber = 0; PortResultNumber < StringValuePort.length; PortResultNumber++){
                                        System.out.println("Port after removing blanks :"+StringValuePort[PortResultNumber]);
                                        if(StringValuePort[PortResultNumber].contains("[::]:")){
                                            Port=StringValuePort[PortResultNumber].replace("[::]:","");
                                            System.out.println("Find port:"+Port);
                                            System.out.println("Finding Service Time spend :"+i+" seconds");
                                            ModifyWindowsTime.SetSystemTime(ModifyWindowsTime.ReturnCurrentSystemTime(i*2));;//改回原时间
                                            return 1;
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
               // Thread.sleep(1000);
                continue;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
