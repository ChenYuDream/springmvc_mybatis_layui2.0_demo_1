package org.jypj.dev.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {

    public static void main(String[] args) {
        String fileName = "20161105152036099.jpg";
        System.out.println(fileName.substring(8, 10));
    }

    /**
     * 文件上传 不需要进行分类
     *
     * @param realpath 文件上传的路径 /noticeFile
     * @param file     上传的文件
     * @return
     * @throws Exception
     */
    public static String upload(String realpath, MultipartFile file) throws Exception {
        // 获取上传文件的总目录
        String filePath = PropertyUtil.getProperties("file_path");
        // 获取文件的名称
        String fileName = file.getOriginalFilename();
        // 文件的后缀名
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        //得到4位随机数
        String substring = StringUtil.getLowUUID().substring(0, 4);

        //时间戳加上4位随机数命名
        String timeStamp = sdf.format(new Date()) + substring;

        // 时间戳命名文件
        String newName = timeStamp + "." + ext;

        // D:/upload/noticeFile
        String path = filePath + realpath;

        // 创建一个目录
        File targetFile = new File(path, newName);
        // 如果目标文件不存在就创建
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        // 上传文件
        file.transferTo(targetFile);

        // 返回图片的真实地址用于数据库的保存
        String fileRealPath = realpath + "/" + newName;

        Runtime.getRuntime().exec("chmod 777 " + filePath+fileRealPath);

        return fileRealPath;
    }

}
