package com.example.demo.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.lang.NonNull;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaTest {

    /**
     * @see Runnable
     * @see Supplier
     * @see Consumer
     * @see Function
     * @see Predicate
     */

    // 익명 함수
    private final Predicate<String> fun = new Predicate<String>() {
        @Override
        public boolean test(@NonNull String s) {
            return s.equals("hello");
        }
    };

    // 람다 표현식
    private final Predicate<String> fun2 = (@NonNull String s) -> s.equals("hello");

    @Test
    void useOverride() {
        assertThat(fun.test("hello")).isTrue();
        assertThat(fun.test("world")).isFalse();
    }

    @Test
    void useLambdaExpression() {
        assertThat(fun2.test("hello")).isTrue();
        assertThat(fun2.test("world")).isFalse();
    }

    @Test
    void nullException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            System.out.println(fun.test(null));
        });
    }

}
