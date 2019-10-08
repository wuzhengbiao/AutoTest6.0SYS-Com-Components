package Com;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetAllFiles {
    public static List<String> getFolders(String path,int isDirectoryflag) {
        File file = new File(path);
        int  DirectoryNum=0;
        int  SubfileNum=0;
        List<String> Directory_list_files = new ArrayList<String>();
        List<String> Subfile_list_files = new ArrayList<String>();
        // 如果这个路径是文件夹
        if (file.isDirectory()) {
            // 获取路径下的所有文件
            File[] Folder= file.listFiles();//存储文件夹名称
            for (int i = 0; i < Folder.length; i++) {
                // 如果还是文件夹 递归获取里面的文件 文件夹
                if (Folder[i].isDirectory()) {
                   // System.out.println("i= ：" + i+Folder.length);
                    Directory_list_files.add(DirectoryNum,Folder[i].getPath());
                    DirectoryNum++;
                    System.out.println("Directory ：" + Folder[i].getPath());
                } else {
                    Subfile_list_files.add(SubfileNum,Folder[i].getPath());
                    SubfileNum++;
                    System.out.println("Subfile ：" + Folder[i].getPath());
                }
            }
        } else {
            System.out.println("文件：" + file.getPath());
        }
        if(isDirectoryflag==1)//为1返回子文件,默认返回文件夹名称
        {
            return  Subfile_list_files;
        }
        return Directory_list_files;
    }
    public static List<String> GetFolderByName(String filename,List<String> list_files) {
        List<String> List_FolderByName = new ArrayList<String>();
        int num=0;
        for(int i = 0 ; i <list_files.size() ; i++) {
            // System.out.print("GET file list: " + list_files.get(i) + "\n");
            if(list_files.get(i).contains(filename))
            {
                //  System.out.print("filename: "+filename+"\n");
                List_FolderByName.add(list_files.get(i));
                System.out.print("Need to delete file: "+List_FolderByName.get(num)+"\n");
                num++;
            }

        }
        return  List_FolderByName;
    }
}
