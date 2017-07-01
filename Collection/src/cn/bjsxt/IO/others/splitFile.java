package cn.bjsxt.IO.others;

import cn.bjsxt.IO.util.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BenWhite on 2017/6/27.
 */
public class splitFile {
    //文件的路径
    private String filePath;
    //文件名
    private String fileName;
    //文件长度
    private long fileLength;
    //块数
    private int size;
    //每块的大小
    private long blockSize;
    //每块的名称
    private List<String> blockPath;

    public splitFile() {
        blockPath = new ArrayList<>();
    }

    public splitFile(String filePath) {
        this(filePath, 1024);
    }

    public splitFile(String filePath, long blockSize) {
        this();
        this.filePath = filePath;
        this.blockSize = blockSize;
        init();
    }

    public void init() {
        File src = null;
        if(null == filePath || !(src = new File(filePath)).exists()) {
            return;
        }
        if(src.isDirectory()){
            System.out.println("文件夹无法拆分");
            return;
        }
        this.fileName = src.getName();
        //计算块数 实际大小与每块大小
        this.fileLength = src.length();
        if(this.blockSize > this.fileLength){
            this.blockSize = this.fileLength;
        }
        //确定块数
        size =(int) Math.ceil(this.fileLength * 1.0 / this.blockSize);
    }

    private void initPathName(String destPath) {
        for (int i = 0; i < this.size; i++) {
            this.blockPath.add(destPath + "/"+ this.fileName + ".part" + i);
        }
    }
    /*
    * 文件的分割
    * 0、第几块
    * 1、起始位置
    * 2、实际大小
    * */

    public void split(String destPath) {
        initPathName(destPath);
        long beginPos = 0;
        long actualBlockSize = blockSize;
        for (int i = 0; i < this.size; i++) {
            if(i == size - 1) {
                actualBlockSize = this.fileLength - beginPos;
            }
            splitDetail(i,beginPos, actualBlockSize);
            beginPos += actualBlockSize;
        }
    }

    public void splitDetail(int idx, long beginPos, long actualBlockSize) {
        File src = new File(this.filePath);
        File dest = new File(this.blockPath.get(idx));
        //2、选择流
        RandomAccessFile raf = null;
        BufferedOutputStream bos = null;
        try {
            raf = new RandomAccessFile(src, "r");
            bos = new BufferedOutputStream(new FileOutputStream(dest));

            raf.seek(beginPos);
            byte[] flush = new byte[1024];
            int len = 0;
            while (-1 != (len = raf.read(flush))) {
                if(actualBlockSize - len >=0) {
                    bos.write(flush, 0 ,len);
                    actualBlockSize -= len;
                }else {
                    bos.write(flush, 0, (int)actualBlockSize);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileUtil.closeAll(bos, raf);
        }
    }

    public void  mergeFile(String destPath) {
        //创建源
        File dest = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        dest = new File(destPath);
        try {
                bos = new BufferedOutputStream(new FileOutputStream(dest, true));
                for (int i = 0; i < this.blockPath.size(); i++) {
                    bis = new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i))));

                    byte[] flush = new byte[1024];
                    int len = 0;
                    while (-1 != (len = bis.read(flush))) {
                        bos.write(flush, 0 ,len);
                    }
                    bos.flush();
                    FileUtil.close(bis);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e1) {
            e1.printStackTrace();
        }finally {
            FileUtil.close(bos);
        }
    }
    public static void main(String[] args) {
        splitFile file = new splitFile("D:/test.txt",100000);
        System.out.println(file.size);
        file.split("D:/20170627");
        file.mergeFile("D:/20170627/test.txt");
    }
}
