package com.dfbz.mapper.provider;

import com.dfbz.entity.SysArea;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @ClassName: SysOfficeProvider
 * @Description:
 * @author: zwx
 * @Date: 2020/1/4 19:55
 * @version: V1.0
 */
public class SysOfficeProvider {

    /**
     * 批量插入
     */
    public String insertBath(@Param("sysAreas") List<SysArea> sysAreas) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `guguanjia`.`sys_area`(`parent_id`, `parent_ids`, `code`, `name`, `type`, `create_by`," +
                " `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`, `icon`) VALUES");
        for (int i = 0; i < sysAreas.size(); i++) {
            sb.append("(");
            sb.append("#{sysAreas["+"i"+"].parent_id}, #{sysAreas["+"i"+"].parent_ids}, #{sysAreas["+"i"+"].code}, #{sysAreas["+"i"+"].name}," +
                    " #{sysAreas["+"i"+"].type}, #{sysAreas["+"i"+"].create_by}, #{sysAreas["+"i"+"].create_date}, #{sysAreas["+"i"+"].update_by}," +
                    " #{sysAreas["+"i"+"].update_date}, #{sysAreas["+"i"+"].remarks}, #{sysAreas["+"i"+"].del_flag}, #{sysAreas["+"i"+"].icon}");
            sb.append("),");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


}
