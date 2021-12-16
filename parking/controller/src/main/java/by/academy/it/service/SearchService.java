package by.academy.it.service;

import by.academy.it.company.Company;
import by.academy.it.company.Employee;
import by.academy.it.dao.CompanySearchDao;
import by.academy.it.dto.SearchResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    private CompanySearchDao companySearchDao;
    //private EmployeeSearchDao employeeSearchDao;

    public List<SearchResult> searchAll(String searchParam) {
        List<SearchResult> results = new ArrayList<>();

        List<Company> companySearchResults = companySearchDao.search(searchParam);
        List<Employee> employeeSearchResults = Collections.emptyList();

        results.addAll(companySearchResults
                .stream()
                .map(company ->
                        new SearchResult(
                                company.getId(),
                                "company",
                                company.getCompanyName()
                        )
                )
                .collect(Collectors.toList()));

        return results;
    }
}
