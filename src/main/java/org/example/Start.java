package org.example;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.Finish.isFinish;
import static org.example.LineOfBusinessFindService.isLineOfBusinessFindService;
import static org.example.SexFindService.isSexFindService;
import static org.example.StatusFindService.isStatusFindService;
import static org.example.TownFindService.isTownFindService;
import static org.example.WorkingModeFindService.isWorkingModeFindService;

public class Start {

    public static void isStart() throws IOException {
        try {
            int age = AgeCalculation.isAgeCalculation();
            AgeCompanyGenerator.isAgeCompanyGenerator(age);
           isSearchEngine();
        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
        }
    }

    public static void isSearchEngine() throws IOException {
        try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Если Вы хотите произвести отбор по месту нахождению компании, введите 1; ");
        System.out.println("Если Вы хотите произвести отбор по форме собственности компании, введите 2; ");
        System.out.println("Если Вы хотите произвести отбор по половому признаку, введите 3; ");
        System.out.println("Если Вы хотите произвести отбор по сфере деятельности компании, введите 4; ");
        System.out.println("Если Вы хотите произвести отбор по форме работы компании, введите 5; ");
        System.out.println("Если Вы хотите выйти из приложения, введите 0; ");

        int choose = scanner.nextInt();

            switch (choose) {
                case 1 -> isTownFindService();
                case 2 -> isStatusFindService();
                case 3 -> isSexFindService();
                case 4 -> isLineOfBusinessFindService();
                case 5 -> isWorkingModeFindService();
                case 0 -> isFinish();
                default -> {
                    System.out.println("Вы ввели некорректную цифру, повторите, пожалуйста, Ваш выбор");
                    isSearchEngine();
                }
            }
        } catch (InputMismatchException | IOException e) {
            System.out.println("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            isSearchEngine();
        }
    }

}
