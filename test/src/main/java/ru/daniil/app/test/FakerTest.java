package ru.daniil.app;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerTest {
    private FakerTest(){}
    public static void printSomeFakeData(){
        String line = " ----> ";
        Faker faker = new Faker(new Locale("ru"));
        System.out.println(faker.name().fullName() + line + "Faker.name().fullName()");
        System.out.println(faker.address().fullAddress() + line + "Faker.address().fullAddress");
        System.out.println(faker.animal().name() + line + "Faker.animal().name()");
        System.out.println(faker.phoneNumber().phoneNumber() + line + "Faker.phoneNumber().phoneNumber");
    }
}
