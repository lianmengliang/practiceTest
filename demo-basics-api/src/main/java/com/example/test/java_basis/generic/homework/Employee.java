package com.example.test.java_basis.generic.homework;

/**
 * lianmengliang
 * <p>
 * 2022-03-27 17:43
 */
@SuppressWarnings("all")
public class Employee {

    private String name;

    private Double sal;

    private MyDate myDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public MyDate getMyDate() {
        return myDate;
    }

    public void setMyDate(MyDate myDate) {
        this.myDate = myDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", myDate=" + myDate +
                '}';
    }
}


class MyDate implements Comparable<MyDate> {

    private Integer year;
    private Integer month;
    private Integer day;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public MyDate(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


    /**
     * 把年月日的比较 放在这里
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(MyDate o) {
        int compareToYear = this.year.compareTo(o.getYear());
        if (compareToYear != 0) {
            return compareToYear;
        }
        int compareToMonth = this.month.compareTo(o.getMonth());
        if (compareToMonth != 0) {
            return compareToMonth;
        }
        return this.day.compareTo(o.getDay());
    }
}

class Animal<K, T, V> {

}