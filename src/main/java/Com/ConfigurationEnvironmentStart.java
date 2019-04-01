package Com;


import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ConfigurationEnvironmentStart {
        public  void RunServerBat(String batName) throws UnsupportedEncodingException {
            String packagePath = this.getClass().getResource("").getPath();
            packagePath = StringUtils.substringBefore(packagePath,"/target")+"/"+batName+".bat";
            String filePath =java.net.URLDecoder.decode(packagePath,"utf-8").trim();
            filePath = StringUtils.substringAfter(filePath,"/");
            //String filePath= System.getProperty("user.dir")+"\\config.txt";//获取用户的当前工作目录
            System.out.println("adress :"+filePath+"\n");
            String[] cmd = new String[]{ filePath};  // dos命令
            try {
                Process ps = Runtime.getRuntime().exec(cmd);
                InputStream in = ps.getInputStream();
                in.close();
                ps.waitFor();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("child thread donn");
        }
}
