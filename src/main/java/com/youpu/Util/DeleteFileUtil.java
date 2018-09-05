package com.youpu.Util;

import java.io.File;

public class DeleteFileUtil {
    //删除文件夹
    //param folderPath文件夹绝对完整路径
    public static void delFolder(String folderPath){
        delAllFile(folderPath);//删除文件夹下所有文件
        File file = new File(folderPath);
        file.delete();//删除空文件夹
    }
    //删除指定文件夹下的所有文件
    //param path 文件夹绝对完整路径
    private static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if(!file.exists()){
            return flag;
        }
        if(!file.isDirectory()){
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if(path.endsWith(File.separator)){
                temp = new File(path+tempList[i]);
            }else {
                temp = new File(path+File.separator+tempList[i]);
            }
            if(temp.isFile()){
                temp.delete();
            }
            if(temp.isDirectory()){
                delAllFile(temp.getPath());//先删除文件夹中的所有文件
                delFolder(temp.getPath());//删除文件夹中的所有文件夹
                flag = true;
            }
        }
        return flag;
    }
}
