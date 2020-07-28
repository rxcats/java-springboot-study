package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserInventoryRepository {

    @Insert("insert into tb_user_inventory(user_id, item_id, item_qty) values(#{userId}, #{itemId}, #{itemQty})")
    Integer insert(Long userId, Long itemId, Integer itemQty);

    @Update("update tb_user_inventory set item_qty = #{itemQty} where user_id = #{userId} and item_id = #{itemId}")
    Integer update(Long userId, Long itemId, Integer itemQty);

    @Select("select * from tb_user_inventory where user_id = #{userId}")
    List<UserInventory> selectAllByUserId(Long userId);

    @Select("select * from tb_user_inventory where user_id = #{userId} and #{itemId}")
    Optional<UserInventory> selectOne(Long userId, Long itemId);

    @Delete("delete from tb_user_inventory where user_id = #{userId}")
    Integer deleteByUserId(Long userId);

}
