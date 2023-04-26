package org.example;

import java.util.List;
import java.util.Objects;

public class Company {

    private String name;
    private int yearOfCreation;
    private String locationCity;
    private TypeOfCompany status;
    private String lineOfBusiness;
    private WorkingMode workingMode;
    private Sex sex;
    private int minAgeLimit;
    private int maxAgeLimit;
    private List<Company> companies;

    public Company(String name, int yearOfCreation, String locationCity, TypeOfCompany status, String lineOfBusiness, WorkingMode workingMode, Sex sex, int minAgeLimit, int maxAgeLimit) {
        this.name = name;
        this.yearOfCreation = yearOfCreation;
        this.locationCity = locationCity;
        this.status = status;
        this.lineOfBusiness = lineOfBusiness;
        this.workingMode = workingMode;
        this.sex = sex;
        this.minAgeLimit = minAgeLimit;
        this.maxAgeLimit = maxAgeLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLineOfBusiness() {
        return lineOfBusiness;
    }

    public void setLineOfBusiness(String lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
    }

    public TypeOfCompany getStatus() {
        return status;
    }

    public void setStatus(TypeOfCompany status) {
        this.status = status;
    }

    public WorkingMode getWorkingMode() {
        return workingMode;
    }

    public void setWorkingMode(WorkingMode workingMode) {
        this.workingMode = workingMode;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public int getMinAgeLimit() {
        return minAgeLimit;
    }

    public void setMinAgeLimit(int minAgeLimit) {
        this.minAgeLimit = minAgeLimit;
    }

    public int getMaxAgeLimit() {
        return maxAgeLimit;
    }

    public void setMaxAgeLimit(int maxAgeLimit) {
        this.maxAgeLimit = maxAgeLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return yearOfCreation == company.yearOfCreation && minAgeLimit == company.minAgeLimit && maxAgeLimit == company.maxAgeLimit && Objects.equals(name, company.name) && Objects.equals(locationCity, company.locationCity) && status == company.status && Objects.equals(lineOfBusiness, company.lineOfBusiness) && workingMode == company.workingMode && sex == company.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfCreation, locationCity, status, lineOfBusiness, workingMode, sex, minAgeLimit, maxAgeLimit);
    }

    @Override
    public String toString() {
        return name +
                "  " + yearOfCreation +
                "  " + locationCity +
                "  " + status +
                "  " + lineOfBusiness +
                "  " + workingMode +
                "  " + sex +
                "  " + minAgeLimit +
                "  " + maxAgeLimit;
    }

}

