package Testing;

import Com.ModifyWindowsTime;
import org.testng.annotations.Test;

import  Com.WhetherOpenService;

public class TesttStart {
    @Test
    public void Start()throws Exception{
        WhetherOpenService.GetMacacaServer();
    }
}
