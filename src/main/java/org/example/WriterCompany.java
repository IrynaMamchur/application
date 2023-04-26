package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterCompany {

    public List<Company> isWriterCompany(List<Company> answer) throws IOException {
        try {
            File file = new File("resources/findCompany.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Company company : answer) {
                System.out.println(company);
                bufferedWriter.write(String.valueOf(company));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
            isWriterCompany(answer);
        }
        return answer;
    }


    public List<Company> isWriterCompanyIfEmpty(List<Company> companies) throws IOException {
        try {
            File file = new File("resources/findCompany.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Company company : companies) {
                bufferedWriter.write(String.valueOf(company));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Неизвестная ошибка");
            isWriterCompany(companies);
        }
        return companies;
    }

}
