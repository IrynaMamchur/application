package org.example;

import java.io.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.example.Finish.isFinish;
import static org.example.FurtherActions.isFurtherActions;
import static org.example.ReadCompanyGenerator.isReadAllCompanies;
import static org.example.Start.isSearchEngine;

public class LineOfBusinessFindService {


    public static void isLineOfBusinessFindService() throws IOException, FileNotFoundException {

        try {
            System.out.println("Отбор по сфере деятельности компании");

            List<Company> companies = isReadAllCompanies();
            isFindLineOfBusinessCompany(companies);
            isChoose(companies);
            isFurtherActions();

        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
            isLineOfBusinessFindService();

        }
    }


    public static List<Company> isFindLineOfBusinessCompany(List<Company> companies) throws IOException {

        try {
            WriterCompany writerCompany = new WriterCompany();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите поисковые слова деятельности компании, такие как: ");
            System.out.println("'дети', 'детское', 'для детей', 'языковые', 'язык', 'английский', 'искусство', 'изобразительное', 'рисование', ");
            System.out.println("'йога', 'спорт', 'прыжки', 'парашют', 'вождения', 'вождение'");

            String line1 = scanner.nextLine();
            String line = line1.toLowerCase();
            String business = null;
            switch (line) {
                case "дети", "детское", "для детей" -> business = "детское_развитие";
                case "языковые", "язык", "английский" -> business = "языковые_курсы";
                case "искусство", "изобразительное", "рисование" -> business = "изобразительное_искусство";
                case "вождения", "вождение" -> business = "курсы_вождения";
                case "спорт", "прыжки", "парашют" -> business = "прыжки_с_парашютом";
                case "йога" -> business = "йога";
            }
            String finalBusiness = business;
            List<Company> answer = companies.stream()
                    .filter(company -> company.getLineOfBusiness().equals(finalBusiness))
                    .toList();
            writerCompany.isWriterCompany(answer);
            if (answer.size() == 0) {
                System.out.println("По заданному поиску компаний не найдено");
                writerCompany.isWriterCompanyIfEmpty(companies);
            }
            System.out.println("-------------------------------------------------------------------------------");


        } catch (NumberFormatException | IOException e) {
            System.out.println("Неправильно введен запрос, используйте при введении запроса только буквы");
            isFindLineOfBusinessCompany(companies);
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
                isFindLineOfBusinessCompany(companies);
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
