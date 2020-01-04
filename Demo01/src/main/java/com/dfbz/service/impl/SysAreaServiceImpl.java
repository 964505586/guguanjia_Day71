package com.dfbz.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.dfbz.entity.SysArea;
import com.dfbz.entity.SysAreaListener;
import com.dfbz.mapper.SysAreaMapper;
import com.dfbz.service.SysAreaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SysAreaServiceImpl
 * @Description:
 * @author: zwx
 * @Date: 2020/1/4 14:44
 * @version: V1.0
 */
@Service
@Transactional
public class SysAreaServiceImpl extends ServiceImpl<SysArea> implements SysAreaService {

    SysAreaMapper sysAreaMapper;

    /**
     * 根据传入的输出流对象，进行excel写入操作，并返回该输出流对象
     * @param outputStream
     * @return
     */
    @Override
    public OutputStream writeExcel(OutputStream outputStream) {
        // 获取excel写出对象
        ExcelWriter excel = EasyExcel.write(outputStream, SysArea.class).build();
        // 获取sheet对象
        WriteSheet sheet = EasyExcel.writerSheet("sysarea数据").build();
        List<SysArea> sysAreas = sysAreaMapper.selectAll();
        // 将数据写出到excel表的对应sheet位置
        excel.write(sysAreas, sheet);
        // 关闭资源
        excel.finish();
        return outputStream;
    }

    /**
     * 将传入的excel文件的组成的inputStream流读取，转换成java对象，并且进行批量插入到数据库
     * @param inputStream
     * @return
     */
    @Override
    public int readExcel(InputStream inputStream) {
        ExcelReader excel = EasyExcel.read(inputStream, SysArea.class, new SysAreaListener(sysAreaMapper)).build();
        ReadSheet sheet = EasyExcel.readSheet(0).build();
        excel.read(sheet);
        excel.finish();
        return 1;
    }

}
