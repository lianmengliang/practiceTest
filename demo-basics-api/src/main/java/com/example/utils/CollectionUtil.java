package com.example.utils;


import org.apache.poi.ss.formula.functions.T;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ： Leo
 * @Date : 2021/8/10 12:15
 * @Desc: 集合的工具类
 */
public class CollectionUtil {


    /**
     * 对集合进行深拷贝，注意需要对泛型类进行序列化（需要实现Serializable）
     *
     * @param srcList
     * @param <T>
     * @return
     */
    public static <T> List<T> deoCopy(List<T> srcList) {

        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        try {
            // 写
            ObjectOutputStream oos = new ObjectOutputStream(byteOut);
            oos.writeObject(srcList);

            // 读
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(byteIn);
            List<T> destList = (List<T>) ois.readObject();
            return destList;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
