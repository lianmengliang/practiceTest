package com.example.test.javaBasis.collection;

import lombok.Data;
import org.jdom.output.SAXOutputter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author ： Leo
 * @Date : 2021/7/26 17:10
 * @Desc:
 */
public class ListHomework {

    static ListBook listBook1 = new ListBook("西游記", "吳承恩", 21.35);
    static ListBook listBook2 = new ListBook("红楼梦", "曹雪芹", 32.35);
    static ListBook listBook5 = new ListBook("水浒传", "施耐庵", 52.35);
    static ListBook listBook3 = new ListBook("平凡的世界", "路遥", 41.35);
    static ListBook listBook4 = new ListBook("三国演义", "罗贯中", 31.25);

    public static void main(String[] args) {
        homework01();
    }

    public static void homework01() {
        List<ListBook> listBooks = new ArrayList<>();

        listBooks.add(listBook1);
        listBooks.add(listBook2);
        listBooks.add(listBook3);
        listBooks.add(listBook4);
        listBooks.add(listBook5);
        for (ListBook listBook : listBooks) {
            System.out.println(listBook);
        }
        //按照价钱从低到高的重新排列图书，重新封装到一个新集合中
        ArrayList<ListBook> books = new ArrayList<>();

        int size = listBooks.size();
        int i = 0;
        while (i < size) {
            for (int j = 0; j < listBooks.size() - 1 - i; j++) {
                ListBook book1 = listBooks.get(j);
                ListBook book2 = listBooks.get(j + 1);
                if (book1.getPrice() > book2.getPrice()) {
                    listBooks.set(j, book2);
                    listBooks.set(j + 1, book1);
                }
            }
            i++;
        }

        for (ListBook book : listBooks) {
            System.out.println(book);
        }
        System.out.println("-------------------------------");
        //使用jdk1.8
        /*listBooks.sort(Comparator.comparing(ListBook::getPrice));
        listBooks.forEach(System.out::println);
        for (ListBook listBook : listBooks) {
            System.out.println("书名：" + listBook.getName() + "   价格："+listBook.getPrice() +"    作者："+ listBook.getAuthor());
        }*/


        for (int i1 = 6; i1 <= 12; i1++) {
            System.out.println("hello"+i1);
        }

    }

}


@Data
class ListBook {
    private String name;

    private String author;

    private double price;

    public ListBook(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public ListBook() {
    }

    @Override
    public String toString() {
        return "书名：" + name + "\t\t价格：" + price + "\t\t作者：" + author;
    }
}