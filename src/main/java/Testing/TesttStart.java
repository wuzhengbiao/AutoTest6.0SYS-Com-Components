package Testing;

import Com.*;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import static Com.FileDelete.delFolder;

public class TesttStart {
    @Test
    public void Start()throws Exception{
        List<String> List_delete_files= new ArrayList<String>();
        List<String> List_need_delete_files= new ArrayList<String>();
        DosCommand servercheck = new DosCommand();
        servercheck.RunDosCommand("D:\\softEnglish\\Nox\\Nox\\bin\\Nox.exe");
        List_delete_files=GetAllFiles.getFolders("D:\\artifact",0);
        List_need_delete_files= GetAllFiles.GetFolderByName("scoped_dir",List_delete_files);
        FileDelete.delFilebylist(List_need_delete_files);
        //FileDelete t = new FileDelete();
        //System.out.println("deleted");

    }
}
