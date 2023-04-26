package org.example;

import java.io.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.example.Finish.isFinish;
import static org.example.FurtherActions.isFurtherActions;
import static org.example.ReadCompanyGenerator.isReadAllCompanies;

public class TownFindService {

    public static void isTownFindService() throws IOException, FileNotFoundException {

        try {
            System.out.println("Отбор по месту нахождения компании");
            List<Company> companies = isReadAllCompanies();
            isFindTownCompany(companies);
            isChoose(companies);
            isFurtherActions();

        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
        }
    }


    public static List<Company> isFindTownCompany(List<Company> companies) throws IOException {
        try {
            WriterCompany writerCompany = new WriterCompany();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название города");
            String town1 = scanner.next();
            String town = town1.toUpperCase();

            List<Company> answer = companies.stream()
                    .filter(company -> company.getLocationCity().equals(town))
                    .toList();
            writerCompany.isWriterCompany(answer);
            if (answer.size() == 0) {
                System.out.println("По заданному поиску компаний не найдено");
                writerCompany.isWriterCompanyIfEmpty(companies);
            }

            System.out.println("-------------------------------------------------------------------------------");
        } catch (NumberFormatException | IOException e) {
            System.out.println("Неправильно введен запрос, используйте при введении запроса только буквы");
            isFindTownCompany(companies);
        }
        return companies;
    }


    public static void isChoose(List<Company> companies) {
        try {
            WriterCompany writerCompany = new WriterCompany();
            System.out.println("Если Вы хотите снова произвести поиск по данному критерию-введите 1,");
            System.out.println("если Вы хотите выйти из данной категории с сохранением результата поиска - введите 2");
            System.out.println ("если Вы хотите выйти из данной категории без сохранения результат поиска - введите 3");Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            if (choose == 1) {
                writerCompany.isWriterCompanyIfEmpty(companies);
                isTownFindService();
            }    if (choose ==3){
                writerCompany.isWriterCompanyIfEmpty(companies);
            }
        } catch (InputMismatchException | IOException e) {
            System.out.println("Неправильно введены цифры. Введите, пожалуйста, цифровое значение");
            isChoose(companies);
        }
    }

}

