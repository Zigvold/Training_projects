package ru.daniil.app.test;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerTest {
    private FakerTest(){}

    private static final Faker faker = new Faker(new Locale("ru"));
    public static void printSomeFakeData(){
        String line = " ----> ";
        System.out.println(faker.name().fullName() + line + "Faker.name().fullName()");
        System.out.println(faker.address().fullAddress() + line + "Faker.address().fullAddress");
        System.out.println(faker.animal().name() + line + "Faker.animal().name()");
        System.out.println(faker.phoneNumber().phoneNumber() + line + "Faker.phoneNumber().phoneNumber");
    }
    public static String generateRandomFirstName(){
        return faker.name().firstName();
    }
    public static String generateRandomLastName(){
        return faker.name().lastName();
    }

    public static int generateRandomAge(){
        return faker.number().numberBetween(15, 70);
    }
}
