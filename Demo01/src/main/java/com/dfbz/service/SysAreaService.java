package com.dfbz.service;

import com.dfbz.entity.SysArea;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @ClassName: SysAreaService
 * @Description:
 * @author: zwx
 * @Date: 2020/1/4 14:44
 * @version: V1.0
 */
public interface SysAreaService extends IService<SysArea> {

    OutputStream writeExcel(OutputStream outputStream);

    int readExcel(InputStream inputStream);

}
