package com.mapper;


import com.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zl on 2015/8/27.
 */
/*
@Mapper 这里可以使用@Mapper注解，但是每个mapper都加注解比较麻烦，所以统一配置@MapperScan在扫描路径在application类中
* 安装了ibatis插件可以直接使用alt+ctrl+b快捷从mapper进入到xml中。
*/
public interface UserMapper {
    @Insert("insert into user (name,age,password) values ('ad',11111,'asd')")
    public int findUserInfo();

}
