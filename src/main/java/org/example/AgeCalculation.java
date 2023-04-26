package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AgeCalculation {
    private int dateOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private int age;

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {

        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int isAgeCalculation() throws IOException {
        try {
            LocalDate localDate = LocalDate.now();
            int dateOfBirth = isBathDay();
            int monthOfBirth = isBathMonth();
            int yearOfBirth = isBathYear();
            LocalDate newDate = localDate.minusDays(dateOfBirth).minusMonths(monthOfBirth).minusYears(yearOfBirth);
            int age = newDate.getYear();
            return age;
        } finally {
        }
    }


    public static int isBathDay() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите день рождения");
            int dateOfBirth = scanner.nextInt();
            if (dateOfBirth < 1 || dateOfBirth > 31) {
                System.out.println("Вы ввели некорректную дату. Дата рождения не может быть меньше 1 или больше 31");
                return isBathDay();
            } else return dateOfBirth;
        } catch (InputMismatchException e) {
            System.out.println("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            return isBathDay();
        }
    }

    public static int isBathMonth() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите месяц рождения");
            int monthOfBirth = scanner.nextInt();
            if (monthOfBirth <= 0 || monthOfBirth > 12) {
                System.out.println("Вы ввели некорректный месяц. Месяц не может быть меньше 1 или больше 12");
                return isBathMonth();
            } else return monthOfBirth;
        } catch (InputMismatchException e) {
            System.out.println("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            return isBathMonth();
        }
    }

    public static int isBathYear() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите год рождения");
            int yearOfBirth = scanner.nextInt();
            LocalDate localDate = LocalDate.now();
            int thisYear = localDate.getYear();
            if (yearOfBirth < 1920 || yearOfBirth > thisYear) {
                System.out.println("Вы ввели некорректный год. Год не может быть меньше 1920, а также не может  быть больше текущего года");
                return isBathYear();
            } else return yearOfBirth;
        } catch (InputMismatchException e) {
            System.out.println("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            return isBathYear();
        }
    }

}
