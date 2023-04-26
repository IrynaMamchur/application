package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AgeCompanyGenerator {

    private static List<Company> companies;

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public static void isAgeCompanyGenerator(int age) throws IOException, FileNotFoundException {

        try {
            List<Company> companies = isReadCompanies();
            isFindFileCompanies(age, companies);
        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
        }
    }

    public static List<Company> isReadCompanies() throws IOException {
        List<Company> companies = new ArrayList<>();
        File file = new File("resources/company.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String companyString = "";
        while (companyString != null) {
            companyString = bufferedReader.readLine();
            if (companyString != null) {
                String[] data = companyString.split(" ");
                String name = data[0];
                int yearOfCreation = Integer.parseInt(data[1]);
                String locationCity = data[2];
                TypeOfCompany status = TypeOfCompany.valueOf(data[3]);
                String lineOfBusiness = data[4];
                WorkingMode workingMode = WorkingMode.valueOf(data[5]);
                Sex sex = Sex.valueOf(data[6]);
                int minAgeLimit = Integer.parseInt(data[7]);
                int maxAgeLimit = Integer.parseInt(data[8]);
                Company company = new Company(name, yearOfCreation, locationCity, status, lineOfBusiness, workingMode, sex, minAgeLimit, maxAgeLimit);
                companies.add(company);
            }
        }
        bufferedReader.close();
        return companies;
    }

    public static List<Company> isFindFileCompanies(int age, List<Company> companies) throws IOException {
        List<Company> answer = companies.stream()
                .filter(company -> company.getMinAgeLimit() <= age && company.getMaxAgeLimit() >= age)
                .toList();

        File file1 = new File("resources/findCompany.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
        for (Company company : answer) {
            System.out.println(company);
            bufferedWriter.write(String.valueOf(company));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        System.out.println("-------------------------------------------------------------------------------");
        return companies;
    }

}




