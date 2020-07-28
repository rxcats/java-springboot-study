package com.example.demo;

import java.util.Optional;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserCurrencyRepository {

    @SelectProvider(type = UserCurrencySqlProvider.class, method = "selectOne")
    UserCurrency selectOne(Long userId);

    @InsertProvider(type = UserCurrencySqlProvider.class, method = "insert")
    Integer insert(UserCurrency userCurrency);

}
