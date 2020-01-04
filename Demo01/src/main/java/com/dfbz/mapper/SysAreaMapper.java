package com.dfbz.mapper;

import com.dfbz.entity.SysArea;
import com.dfbz.mapper.provider.SysOfficeProvider;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

public interface SysAreaMapper extends Mapper<SysArea> {

    @InsertProvider(type = SysOfficeProvider.class, method = "insertBath")
    int insertBath(@Param("sysAreas") List<SysArea> sysAreas);
}