package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.example.Finish.isFinish;
import static org.example.FurtherActions.isFurtherActions;
import static org.example.ReadCompanyGenerator.isReadAllCompanies;

public class WorkingModeFindService {

    public static void isWorkingModeFindService() throws IOException, FileNotFoundException {
        try {
            System.out.println("Выбор по форме работы компании");
            List<Company> companies = isReadAllCompanies();
            isFindWorkingMode(companies);
            isChoose(companies);
            isFurtherActions();

        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
        }
    }

    public static List<Company> isFindWorkingMode(List<Company> companies) throws IOException {
        try {
            WriterCompany writerCompany = new WriterCompany();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Если Вас интересуют компании, которые работают только ОН-ЛАЙН,введите 1,");
            System.out.println("если компании, которые работают только ОФФ-ЛАЙН,введите 2,");
            System.out.println("ecли компании, которые работают, как ОН-ЛАЙН, так и ОФФ-ЛАЙН, введите 3.");
            int statusChoose = scanner.nextInt();
            List<Company> answer = new ArrayList<>();
            if (statusChoose == 1) {
                answer = companies.stream()
                        .filter(company -> company.getWorkingMode().equals(WorkingMode.ON_LINE))
                        .toList();
            } else if (statusChoose == 2) {
                answer = companies.stream()
                        .filter(company -> company.getWorkingMode().equals(WorkingMode.OFF_LINE))
                        .toList();
            } else if (statusChoose == 3) {
                answer = companies.stream()
                        .filter(company -> company.getWorkingMode().equals(WorkingMode.ON_OFF_LINE))
                        .toList();
            } else {
                System.out.println("Вы ввели некорректную цифру, повторите, пожалуйста, Ваш выбор");
                isFindWorkingMode(companies);
            }
            writerCompany.isWriterCompany(answer);

            if (answer.size() == 0) {
                System.out.println("По заданному поиску компаний не найдено");
                writerCompany.isWriterCompanyIfEmpty(companies);
            }
            System.out.println("-------------------------------------------------------------------------------");

        } catch (InputMismatchException | IOException e) {
            System.out.println("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            isFindWorkingMode(companies);
        }
        return companies;
    }


    public static void isChoose(List<Company> companies) {
        try {
            WriterCompany writerCompany = new WriterCompany();
            System.out.println("Если Вы хотите снова произвести поиск по данному критерию-введите 1,");
            System.out.println("если Вы хотите выйти из данной категории с сохранением результата поиска - введите 2");
            System.out.println ("если Вы хотите выйти из данной категории без сохранения результат поиска - введите 3");
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            if (choose == 1) {
                writerCompany.isWriterCompanyIfEmpty(companies);
                isFindWorkingMode(companies);
                isChoose(companies);
            }    if (choose ==3){
                writerCompany.isWriterCompanyIfEmpty(companies);
            }
        } catch (InputMismatchException | IOException e) {
            System.out.println("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            isChoose(companies);
        }
    }
}

