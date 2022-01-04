package by.academy.it.service;

import by.academy.it.company.pojo.Company;
import by.academy.it.company.pojo.Employee;
import by.academy.it.dao.CompanySearchDao;
import by.academy.it.dao.PersonDao;
import by.academy.it.dto.SearchResult;
import by.academy.it.parking.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private CompanySearchDao companySearchDao;
    //private EmployeeSearchDao employeeSearchDao;

    @Autowired
    private PersonDao personDao;

    public List<SearchResult> searchAll(String searchParam) {
        List<SearchResult> results = new ArrayList<>();

        List<Company> companySearchResults = companySearchDao.search(searchParam);
        List<Employee> employeeSearchResults = Collections.emptyList();

        results.addAll(companySearchResults.stream()
                .map(company -> new SearchResult(
                                company.getId(),
                                "company",
                                company.getCompanyName()
                        )
                )
                .collect(Collectors.toList()));

        final List<Person> personSearchResults = personDao.search(searchParam);
        results.addAll(personSearchResults.stream()
                .map(person -> new SearchResult(
                        person.getId().toString(),
                        "person",
                        person.getName() + " " + person.getSecondName()
                )).collect(Collectors.toList()));
        return results;
    }
}
