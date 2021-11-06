package com.example.interview;

import java.util.*;
import java.util.stream.Collectors;

/**
 * lianmengliang
 * <p>
 * 2021-10-18 20:36
 */
@SuppressWarnings("all")
public class InterViewDemo {


    public static void result() {
        String[] arrayToCheck = {"A", "B", "C", "A", "B", "C", "A"};
        int numDupes = 0;

        ArrayList<String> result = new ArrayList<>();

        for (int j = 0; j < arrayToCheck.length; j++) {
            for (int k = j + 1; k < arrayToCheck.length; k++) {
                if (k != j && arrayToCheck[k].equals(arrayToCheck[j])) {
                    numDupes++;
                    result.add(arrayToCheck[k]);
                }
            }
        }
        System.out.println(numDupes);
        for (String s : result) {
            System.out.println(s);
        }

    }


    public static <E> List<E> getDuplicateElements(List<E> list) {
        return list.stream() // list 对应的 Stream
                .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
                .entrySet().stream() // 所有 entry 对应的 Stream
                .filter(entry -> entry.getValue() > 1) // 过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey()) // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toList());  // 转化为 List
    }

    public static void main(String[] args) throws Exception {
        String[] arrayToCheck = {"A", "B", "C", "A", "B", "C", "A"};
        List<String> strings = Arrays.asList(arrayToCheck);
        List<String> results = getDuplicateElements(strings);
        results.forEach(e -> System.out.println(e));

        strings.stream().collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        Map<String, Integer> result = new HashMap<>();

        for (String string : strings) {
            if (result.get(string) != null) {
                Integer num = result.get(string);
                num++;
                if (num == 2) {
                    System.out.println("重复元素：" + string);
                }
                result.put(string, num);
            } else {
                result.put(string, 1);
            }
        }


        List<String> collect = result.entrySet().stream().filter(e -> e.getValue() > 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());

        for (String s : collect) {
            System.out.println(s);
        }









       /* List<String> list = Arrays.asList("a", "b", "c", "d", "a", "a", "d", "d");
        List<String> duplicateElements = getDuplicateElements(list);

        System.out.println("list 中重复的元素：" + duplicateElements);*/


//        result1();

    }


    public static void result1() {
        String[] arrayToCheck = {"A", "B", "C", "A", "B", "C", "A"};
        int numDupes = 0;

        ArrayList<String> result = new ArrayList<>();

        String[] resultString = new String[arrayToCheck.length];
        int j = 0;
        for (int i = 0; i < arrayToCheck.length; i++) {
            result.add(arrayToCheck[i]);
            if (i >= 1) {
                for (String s : result) {
                    if (s.equals(arrayToCheck[i])) {
                        resultString[j] = arrayToCheck[i];
                        j++;
                    }
                }
            }


        }
        for (String s : resultString) {
            System.out.println(s);
        }

    }

}
