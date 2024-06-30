package org.example.stream;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 常用 stream api:
 * 生成一个整数流2 通过iterator IntStream方式
 * 过滤流中的null值 ofNullAble
 *
 * 将一个流映射诚map
 *
 * 从一个流中截取部分数据  dropWhile takeWhile
 *
 * 从一个流中收取max min teeing
 *
 * 将一个流分成两个流 partitionBy
 * 将两个流合并成一个流 concat
 */
public class StreamApi {

    public static void main(String[] args) {
        filterValue();
        it();
        collectoTrans();
        remove();

        intStream();

        teeing();

        concatStream();

        partitioningBy();
    }

    // 快速空值过滤 Java 9 过滤集合中的所有空值
    public static void filterValue(){
//        List<String> strings = Arrays.asList("fei", "liu", null, "zhi", null, "xia", "san", "qian", "chi");
//        List<String> collect = strings.stream().flatMap(Stream::ofNullable).collect(Collectors.toList());
//        System.out.println(collect);
    }

    // 流式迭代
    public static void it(){
        // 通过stream.iterate()生成的是无限序列流，需要通过limit findFirst findAny等定义终止条件
        Stream.iterate(0,n->n+2).limit(10).forEach(e->{  //limit表示生成个数
            System.out.println(e);
        });
    }

    // 集合转换
    public static void collectoTrans(){
        List<String> fruits = Arrays.asList("apple", "banana", "orange0");
        Map<Integer, String> result = fruits.stream()
                .collect(Collectors.collectingAndThen(Collectors.toMap(fruits::indexOf, String::toUpperCase), Collections::unmodifiableMap));
        //Collections::unmodifiableMap 使该映射为不可修改的map
        System.out.println(result);
    }

    // 删除和截取
    public static void remove(){
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
//        numbers.stream().dropWhile(n->n<3)
//                .takeWhile(n->n<6).forEach(System.out::println);
    }

    // 整数流 java8 用于快速生成整数流 常用的有以下几种方式  IntStream.range() 生成一个整数流，该整数流不包含结尾数字
    // IntStream.rangeClosed()生成一个整数流 该整数流包含结尾数字
    public static void intStream(){
        IntStream.range(1,5).forEach(System.out::print);
        System.out.println("=================");
        IntStream.rangeClosed(1,5).forEach(System.out::print);

    }

    // 应用多个收集器  Java 12
    public static void teeing(){
//        Stream<Integer> nums = Stream.of(1, 2, 3, 4);
//        Map<String,Integer> collect = nums.collect(Collectors
//                .teeing(Collectors.maxBy(Integer::compareTo),
//                        Collectors.minBy(Integer::compareTo),
//                        (e1,e2)->Map.of("min",e1.get(),"max",e2.get())));
//        System.out.println(collect);
    }

    // 合并流
    public static void concatStream(){
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4);
        Stream<Integer> stream2 = Stream.of(5, 6, 7, 8);
        Stream.concat(stream1,stream2).forEach(System.out::print);
    }

    // 分组
    public static void partitioningBy(){
        Map<Boolean, List<String>> result = Stream.of("applr", "banana", "orange", "grape").collect(Collectors.partitioningBy(f -> f.length() > 5));
        System.out.println(result);
    }

}
