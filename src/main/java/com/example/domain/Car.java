package com.example.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @Author ： Leo
 * @Date : 2021/2/22 16:54
 * @Desc:
 */
public  class Car {
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }


    final Car car = Car.create(Car::new);
    final List<Car> cars = Arrays.asList(car);

    Car car1 = new Car();
   /* cars.forEach( Car::collide );

    final Car police = Car.create( Car::new );
    cars.forEach( police::follow );*/
}