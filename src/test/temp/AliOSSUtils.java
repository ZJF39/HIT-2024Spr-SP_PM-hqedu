package com.haoqi.hqedu.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Component
public class AliOSSUtils {
    /*
    private String endpoint = "https://cn-beijing.oss.aliyuncs.com";
    // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
    // 填写Bucket名称，例如examplebucket。
    private String bucketName = "web-hqedu";
    */

    @Autowired
    private AliOSSProperties aliOSSProperties;
    private EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

    public AliOSSUtils() throws ClientException {}
    // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。

    public String upload(MultipartFile file) throws IOException{

        String endpoint = aliOSSProperties.getEndpoint();
        String bucketName = aliOSSProperties.getBucketName();

        // 获取上传文件的输入流
        InputStream inputStream = file.getInputStream();

        String originalFilename = file.getOriginalFilename();
        // 使用UUID生成文件名，避免文件被覆盖，生成格式为32位UUID+原始文件名+以点分隔
        String fileName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));

        // 上传文件到阿里云OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        ossClient.putObject(bucketName, fileName, inputStream);

        // 文件访问路径，格式为 https://examplebucket.oss-cn-hangzhou.aliyuncs.com/exampleobject.txt
        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;

        // 关闭OSSClient
        ossClient.shutdown();
        return url;// 返回文件访问路径

    }


}
