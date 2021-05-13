package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ClassName:    le_01
 * Package:    com.myleetcode https://www.cnblogs.com/zhangboyu/p/7580262.html
 * Description: java8语法专项
 * Datetime:    2021/5/7   9:17
 * Author:   houyufei@fulong.tech一
 *
 */
public class java8Grammar {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 34, 5};
        IntStream intStream = Arrays.stream(arr);
        intStream.forEach(System.out::print);
        System.out.println();
        /**
         * of: 流的创建 Stream.of 通过数组创建流 语法
         */
        Stream<Integer> stream1 = Stream.of(1, 2, 34, 5, 9);
        stream1.forEach(System.out::print);
        System.out.println();
        /**
         * stream: 流的创建 strs.stream() 通过集合创建流
         */
        List<String> strs = Arrays.asList("11212", "dfd", "2323", "dfhgf");
        Stream<String> stream = strs.stream();
        /**
         * map: 转换流，将一种类型的流转换为另外一种流，可以修改数据的使用
         */
        String[] arr1 = new String[]{"yes", "YES", "no", "NO"};
        Arrays.stream(arr1).map(e -> e.toUpperCase(Locale.ROOT)).forEach(System.out::print);
        System.out.println();
        /**
         * filter：过滤流，过滤流中的元素
         */
        Integer[] filter = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(filter).filter(x -> x > 3 && x < 8).forEach(System.out::println);
        /**
         * flatMap:拆解流，将流中每一个元素拆解成一个流 嵌套list使用的时候就需要这个
         */
        String[] arr4 = {"a", "b", "c", "d"};
        String[] arr2 = {"e", "f", "c", "d"};
        String[] arr3 = {"h", "j", "c", "d"};
        Stream.of(arr4, arr2, arr3).flatMap(Arrays::stream).forEach(System.out::print);
        System.out.println();
        /**
         * sorted:对流进行排序
         */
        String[] sorted = {"abc", "a", "bc", "abcd"};
        Arrays.stream(sorted).sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
        System.out.println("方式2");
        /**
         * sorted方式2：按照字符长度排序 一句话,返回负数,第一个参数放前面
         */
        Arrays.stream(sorted).sorted((x, y) -> {
            if (x.length() > y.length()) {
                return 1;
            } else if (x.length() < y.length()) {
                return -1;
            } else {
                return 0;
            }
        }).forEach(System.out::println);

        /**
         * iterate:重复产生的
         * limit：限制从流中获得前n个数据
         */
        System.out.println("产生规律的数据");
        Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::print);
        /**
         * skip，跳过前n个数据
         */
        System.out.println("跳过前n个数据");
        Stream.iterate(1, x -> x + 2).skip(1).limit(5).forEach(System.out::print);
        /**
         * concat:可以把两个stream合并成一个stream（合并的stream类型必须相同）
         */
        System.out.println("可以把两个stream合并成一个stream");
        Stream<String> stringStream1 = Stream.of(arr1);
        Stream<String> stringStream2 = Stream.of(arr2);
        Stream.concat(stringStream1, stringStream2).distinct().forEach(System.out::print);

    }
}
