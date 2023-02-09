package com.example.AppointmentSystem.Util;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/**
 * @author xxx
 * @description Base64工具类
 **/
public class Base64Util {

    /**
     * @Description: base64转文件
     * @Param: [file64Str, outPath]
     * @Return: boolean
     **/
    public static boolean base64StrToFile(String file64Str, String outPath) {
        if (file64Str == null)
            return false;
        Decoder decoder = Base64.getDecoder();
        try {
            // 解密
            byte[] b = decoder.decode(file64Str);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            // 文件夹不存在则自动创建
            File tempFile = new File(outPath);
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(tempFile);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @Description: base64转MultipartFile
     * @Param: [base64Str]
     * @Return: org.springframework.web.multipart.MultipartFile
     **/
    public static MultipartFile base64StrToMultipartFile(String base64Str){
        if (StringUtils.isEmpty(base64Str)){
            return null;
        }
        Decoder decoder = Base64.getDecoder();
        MultipartFile multipartFile = null;
        try {
            // 解密
            byte[] b = decoder.decode(base64Str);
            multipartFile = new MockMultipartFile("file.png", b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return multipartFile;
    }

    /**
     * @Description: 文件转base64(路径入参)
     * @Param: [filePath]
     * @Return: java.lang.String
     **/
    public static String fileToBase64Str(String filePath) {
        InputStream inputStream;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(filePath);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(data);
    }

    /**
     * @Description: 文件转base64(文件入参)
     * @Param: [file]
     * @Return: java.lang.String
     **/
    public static String fileToBase64Str(MultipartFile file) {
        InputStream inputStream;
        byte[] data = null;
        try {
            inputStream = file.getInputStream();
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(data);
    }

    /**
     * @Description: byte转Base64
     * @Param: [data]
     * @Return: java.lang.String
     **/
    public static String byteToBase64(byte[] data){
        // 加密
        Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(data);
    }

}

