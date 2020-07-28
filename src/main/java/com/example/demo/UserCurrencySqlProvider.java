package com.example.demo;

import org.apache.ibatis.jdbc.SQL;

public class UserCurrencySqlProvider {
    public static String selectOne() {
        return new SQL() {{
           SELECT("*");
           FROM("tb_user_currency");
           WHERE("user_id = #{userId}");
        }}.toString();
    }

    public static String insert() {
        return new SQL() {{
            INSERT_INTO("tb_user_currency");
            VALUES("user_id, gold, cash, paid_cash", "#{userId}, #{gold}, #{cash}, #{paidCash}");
        }}.toString();
    }
}
