package com.dfbz.controller;

import com.dfbz.entity.SysOffice;
import com.dfbz.service.SysOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @ClassName: SysOfficeController
 * @Description:
 * @author: zwx
 * @Date: 2019/12/27 0:26
 * @version: V1.0
 */
@RestController
@RequestMapping("manager/sysOffice")
public class SysOfficeController {

    @Autowired
    SysOfficeService sysOfficeService;

    @RequestMapping("list")
    public List<SysOffice> selectAll() {
        return sysOfficeService.selectAll();
    }

}
