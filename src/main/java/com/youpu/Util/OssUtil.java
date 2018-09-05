package com.youpu.Util;

import com.aliyun.openservices.ClientException;
import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.OSSException;
import com.aliyun.openservices.oss.model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class OssUtil {
    /**
     * 阿里云ACCESS_ID
     */
    private static String ACCESS_ID = "vtXujYmNXNaTGV93";
    /**
     * 阿里云ACCESS_KEY
     */
    private static String ACCESS_KEY = "aFg7zGkmk8DkxbLHgOQlDEIlYW2INn";
    /**
     * 阿里云OSS_ENDPOINT  青岛Url
     */
    private static String OSS_ENDPOINT = "http://oss-cn-hangzhou.aliyuncs.com";

    /**
     * 阿里云BUCKET_NAME  OSS
     */
    private static String BUCKET_NAME = "test-upload-paper";

    public static void  upload(String objectKey,String uploadFilePath){
        OSSClient client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY);

        //文件上传到OSS
        try {
            creatBucket(client,BUCKET_NAME);
            setBucketPuclicReadable(client,BUCKET_NAME);
            System.out.println("正在上传...");
            uploadFile(client,BUCKET_NAME,objectKey,uploadFilePath);
            System.out.println("上传完成!!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void dowload(String objectKey,String dowloadFilePath){
        OSSClient client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY);

        //文件从OSS下载到本地
        try {
            System.out.println("正在下载...");
            dowloadFile(client,BUCKET_NAME,objectKey,dowloadFilePath);
            System.out.println("上传完成!!!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            deleteBucket(client,BUCKET_NAME);
        }
    }

    /**
     * 创建Bucket
     *
     * @param client     OSSClient对象
     * @param bucketName BUCKET名
     * @throws OSSException
     * @throws ClientException
     */
    public static void creatBucket(OSSClient client,String bucketName){
        client.createBucket(bucketName);
    }

    /**
     * 删除一个Bucket和其中的Objects
     *
     * @param client     OSSClient对象
     * @param bucketName Bucket名
     * @throws OSSException
     * @throws ClientException
     */
    public static void deleteBucket(OSSClient client,String bucketName){
        ObjectListing objectListing = client.listObjects(bucketName);
        List<OSSObjectSummary> listDelete = objectListing.getObjectSummaries();
        for (int i = 0; i < listDelete.size(); i++) {
            String objectName = listDelete.get(i).getKey();
            System.out.println("objectName="+objectName);
            //如果不为空,先删除bucket下的文件
            client.deleteObject(bucketName,objectName);
        }
        client.deleteBucket(bucketName);
    }
    /**
     * 把Bucket设置成所有人可读
     *
     * @param client     OSSClient对象
     * @param bucketName Bucket名
     * @throws OSSException
     * @throws ClientException
     */
    public static void setBucketPuclicReadable(OSSClient client,String bucketName){
        //创建bucket
        client.createBucket(bucketName);
        //设置bucket访问权限 public - read - write 权限
        client.setBucketAcl(bucketName,CannedAccessControlList.PublicRead);
    }
    /**
     * 上传文件
     *
     * @param client     OSSClient对象
     * @param bucketName Bucket名
     * @param Objectkey  上传到OSS起的名
     * @param filename   本地文件名
     * @throws OSSException
     * @throws ClientException
     * @throws FileNotFoundException
     */
    private static void uploadFile(OSSClient client, String bucketName, String Objectkey, String filename)
            throws OSSException, ClientException, FileNotFoundException {
        File file = new File(filename);
        ObjectMetadata objectMeta = new ObjectMetadata();
        objectMeta.setContentLength(file.length());
        //判断上传类型，多的可根据自己需求来判定
        if (filename.endsWith("xml")) {
            objectMeta.setContentType("text/xml");
        } else if (filename.endsWith("jpg")) {
            objectMeta.setContentType("image/jpeg");
        } else if (filename.endsWith("png")) {
            objectMeta.setContentType("image/png");
        } else if (filename.endsWith("doc")) {
            objectMeta.setContentType("application/msword");
        }

        InputStream input = new FileInputStream(file);
        client.putObject(bucketName, Objectkey, input, objectMeta);
    }

    /**
     * 下载文件
     *
     * @param client     OSSClient对象
     * @param bucketName Bucket名
     * @param objectKey  上传到OSS起的名
     * @param fileName   文件下载到本地保存的路径
     * @throws OSSException
     * @throws ClientException
     */
    public static void dowloadFile(OSSClient client,String bucketName,String objectKey,String fileName){
        client.getObject(new GetObjectRequest(bucketName,objectKey),new File(fileName));
    }
}
