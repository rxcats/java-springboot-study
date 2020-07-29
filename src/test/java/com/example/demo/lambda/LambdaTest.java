package com.example.demo.lambda;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.lang.NonNull;

import lombok.NoArgsConstructor;
import lombok.ToString;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaTest {

    @Target({ ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface ForA {

    }

    @ForA
    @ToString
    @NoArgsConstructor
    static class A {
        private String name;
    }

    @Test
    void info() {
        // lombok annotation 은 컴파일 시점에 코드를 생성 하기 때문에 runtime 에 가져올 수 없어서 나오지 않음.
        for (Annotation annotation : A.class.getAnnotations()) {
            System.out.println(annotation);
        }

        System.out.println();

        for (Method method : A.class.getMethods()) {
            System.out.println(method);
        }
    }

    /**
     * @see Runnable
     * @see Supplier
     * @see Consumer
     * @see Function
     * @see Predicate
     */

    @FunctionalInterface
    interface R {
        void doit();
    }

    private final R r = () -> {
        System.out.println("r");
    };

    // 익명 함수
    private final Predicate<String> fun = new Predicate<String>() {
        @Override
        public boolean test(@NonNull String s) {
            return s.equals("hello");
        }
    };

    // 람다 표현식
    private final Predicate<String> lambdaFun = (@NonNull String s) -> s.equals("hello");

    @Test
    void useOverride() {
        assertThat(fun.test("hello")).isTrue();
        assertThat(fun.test("world")).isFalse();
    }

    @Test
    void useLambdaExpression() {
        assertThat(lambdaFun.test("hello")).isTrue();
        assertThat(lambdaFun.test("world")).isFalse();
    }

    @Test
    void nonNullAnnotation() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            System.out.println(fun.test(null));
        });
    }

    @Test
    void doAsyncWork() throws InterruptedException {
        System.out.println("start " + Thread.currentThread().getName());

        var job = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("hello " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        job.start();

        System.out.println("end " + Thread.currentThread().getName());

        Thread.sleep(5000);


        var pool = Executors.newFixedThreadPool(1);

        try {
            pool.submit(() -> {
                System.out.println("ok" + Thread.currentThread().getName());
            }).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    @Test
    void threadPool() throws InterruptedException {

        var pool = Executors.newFixedThreadPool(1);

        try {
            pool.submit(() -> {
                System.out.println("ok" + Thread.currentThread().getName());
            }).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Thread.sleep(5000);
    }

    @Test
    void stream() {
        var list = List.of(1, 2, 3, 4, 5);

        list.stream()
            .filter(i -> i > 2)
            .map(i -> i * 3)
            .forEach(System.out::println);
    }

    @Test
    void parallelStream() {
        var list = List.of(1, 2, 3, 4, 5);

        list.parallelStream().forEach(v -> {
            System.out.println(v + " " + Thread.currentThread().getName());
        });
    }

}
