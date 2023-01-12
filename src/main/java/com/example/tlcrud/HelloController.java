package com.example.tlcrud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "siemeczka";
    }

    @GetMapping("/hello")
    public String hello() {
        return "cześć";
    }

    @GetMapping("/rateCar")
    public String rateMyCar(String carName) {
        if (Objects.equals(carName, "Ferrari")) {
            return "zazdrość w narodzie";
        } else if (Objects.equals(carName, "Passat")) {
            return "prawdziwy polak";
        } else {
            return "co za złom";
        }
    }

    @GetMapping("/passat")
    public String getPassat() {
        Car passat = new Car();
        passat.producer = "vw";
        passat.model = "passserati";
        passat.yearOfProduction = 2001;
        passat.millage = 87000.0;

        return passat.toString();
    }

    @GetMapping("/fiat")
    public Car getFiat() {
        Car fiat = new Car();
        fiat.producer = "Fiat";
        fiat.model = "punto";
        fiat.yearOfProduction = 2011;
        fiat.millage = 287000.0;

        return fiat;
    }

    @GetMapping("/myCars")
    public List<Car> myCars() {
            List<Car> cars = new ArrayList<>();
            cars.add(new Car("Fiat", "Panda", 2005));
            cars.add(new Car("Fiat", "Tipo", 2010));
        cars.add(new Car("Fiat", "Bravo", 2015));
        return cars;
    }

    @GetMapping("/myCar")
    public Car myCar(String producer, String model, Integer yearOfProduction){
        Car usersCar = new Car(producer, model, yearOfProduction);
        System.out.println("Samochód użytkownika: " + usersCar);
        return usersCar;
    }
}
