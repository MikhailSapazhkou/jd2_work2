package by.academy.it.service;

import by.academy.it.dao.AppParkingUserDao;
import by.academy.it.dao.PersonDao;
import by.academy.it.dao.TicketDao;
import by.academy.it.dto.SearchTicketCriteria;
import by.academy.it.dto.SearchTicketResult;
import by.academy.it.parking.pojo.AppParkingUser;
import by.academy.it.parking.pojo.Person;
import by.academy.it.parking.pojo.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchUserTicketService {

    @Autowired
    AppParkingUserDao userDao;
    @Autowired
    TicketDao ticketDao;
    @Autowired
    private PersonDao personDao;

    public List<SearchTicketResult> searchUserTickets(SearchTicketCriteria searchTicketCriteria) {
        String fio = searchTicketCriteria.getFio();
        String[] names = fio.split(" ");
        final List<Person> personList = personDao.searchByNameAndSecondName(names[1], names[0]);

        final List<AppParkingUser> appParkingUsers = userDao.searchByAppParkingUserLogin(searchTicketCriteria.getLogin());

        final Set<Long> personIds = new HashSet<>();
        personList.forEach(person -> personIds.add(person.getId()));
        appParkingUsers.forEach(appParkingUser -> personIds.add(appParkingUser.getPerson().getId()));

        final List<Ticket> tickets = ticketDao.findByPersonIds(personIds);

        return tickets
                .stream()
                .filter(Objects::nonNull)
                .map(ticket -> {
                    SearchTicketResult result = new SearchTicketResult();
                    result.setTicket(ticket.getLicensePlateNumber());
                    result.setFio(ticket.getPerson().getSecondName() + " " + ticket.getPerson().getName());
                    result.setPersonId(ticket.getPerson().getId().toString());
                    result.setLogin(userDao.findUserByPersonId(ticket.getPerson().getId()));
                    return result;
                })
                .collect(Collectors.toList());
    }

}
