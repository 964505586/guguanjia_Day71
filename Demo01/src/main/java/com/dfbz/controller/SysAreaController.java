package com.dfbz.controller;

import com.dfbz.entity.Result;
import com.dfbz.service.SysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: SysAreaController
 * @Description:
 * @author: zwx
 * @Date: 2020/1/4 14:42
 * @version: V1.0
 */
@RestController
@RequestMapping("manager/area")
public class SysAreaController {

    @Autowired
    SysAreaService sysAreaService;

    /**
     * 跳转到查询页
     * @return
     */
    @RequestMapping("")
    public ModelAndView toIndex() {
        return new ModelAndView("/area/area");
    }

    /**
     * Excel下载操作:
     * 1.设置响应头
     * 2.设置文件乱码处理
     * 3.获取响应数据流
     * 4.写出到页面
     */
    @RequestMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment;filename=sysArea.xls");
        ServletOutputStream outputStream = response.getOutputStream();
        sysAreaService.writeExcel(outputStream);
        MultipartFile file;
    }

    @RequestMapping("upload")
    public Result upload(MultipartFile file) throws IOException {
        Result result = new Result();
        int i = sysAreaService.readExcel(file.getInputStream());
        if (i > 0) {
            result.setMsg("导入数据成功");
            result.setSuccess(true);
        }
        return result;
    }



}
