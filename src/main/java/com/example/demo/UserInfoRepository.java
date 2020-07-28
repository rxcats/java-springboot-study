package com.example.demo;

import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoRepository {

    @Delete("delete from tb_user_info where platform_id = #{platformId}")
    Integer deleteByPlatformId(Long platformId);

    @Options(useGeneratedKeys = true, keyProperty = "userId")
    @Insert("insert into tb_user_info(platform_id, user_name, state, `join_ts`, `last_login_ts`) values (#{platformId}, #{username}, #{state}, #{joinTs}, #{lastLoginTs})")
    Integer insert(UserInfo userInfo);

    @Select("select * from tb_user_info where platform_id = #{platformId}")
    Optional<UserInfo> findByPlatformId(Long platformId);

}
