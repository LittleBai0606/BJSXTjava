import java.io.File;

/**
 * Created by BenWhite on 2017/6/10.
 */
public class FileTree {
    public static void main(String[] args) {
        File f = new File("D:/BaiduYunDownload");
        printFile(f, 0);
    }

    static void printFile(File file, int level)
    {
        for(int i = 0; i < level; i++)
        {
            System.out.print("-");
        }
        System.out.println(file.getName());

        if(file.isDirectory())
        {
            File[] files = file.listFiles();
            for(File temp : files)
            {
                printFile(temp, level+1);
            }
        }
    }
}
