package by.academy.it.dao;

import by.academy.it.company.Company;

import java.util.List;

public interface CompanySearchDao {

    List<Company> search(String namePattern);
}
