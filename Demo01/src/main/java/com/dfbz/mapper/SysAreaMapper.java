package com.dfbz.mapper;

import com.dfbz.entity.SysArea;
import com.dfbz.mapper.provider.SysAreaProvider;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;
import java.util.Map;

public interface SysAreaMapper extends Mapper<SysArea> {

    @InsertProvider(type = SysAreaProvider.class, method = "insertBath")
    int insertBath(@Param("sysAreas") List<SysArea> sysAreas);

    @SelectProvider(type = SysAreaProvider.class, method = "selectByCondition")
    List<SysArea> selectByCondition(Map<String, Object> map);
}