package com.wang.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传。。。");

        //使用file组件完成文件的上传
        //制定文件位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");

        //判断路径是否存在
        File file = new File(path);
        if (!file.exists()){
            //创建爱你文件夹
            file.mkdirs();
        }

        //解析request对象，获取文件上传像
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        //解析
        List<FileItem> items = upload.parseRequest(request);

        //遍历
        for (FileItem item:items){
            //判断是否是上传文件爱你的选项
            if (item.isFormField()){
                //普通
            }else{
                //上传的文件项
                //获取上传文件的名称
                String filename = item.getName();
                //完成上传
                item.write(new File(path,filename));

                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /**
     * springmvc方式上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传。。。");

        //使用file组件完成文件的上传
        //制定文件位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");

        //判断路径是否存在
        File file = new File(path);
        if (!file.exists()){
            //创建爱你文件夹
            file.mkdirs();
        }

                //上传的文件项
                //获取上传文件的名称
        String filename = upload.getOriginalFilename();
                //完成上传
            upload.transferTo(new File(path,filename));



        return "success";
    }
}
