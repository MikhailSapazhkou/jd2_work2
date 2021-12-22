package by.academy.it.service;

import by.academy.it.dto.SearchTicketCriteria;
import by.academy.it.dto.SearchTicketResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchUserTicketController {

    @Autowired
    private SearchUserTicketService service;

    @GetMapping("/search-ticket.html")
    public ModelAndView searchTickets(SearchTicketCriteria criteria) {
        final List<SearchTicketResult> searchTicketResults = service.searchUserTickets(criteria);
        ModelAndView modelAndView = new ModelAndView("search-ticket-result");
        modelAndView.addObject("tickets", searchTicketResults);
        return modelAndView;
    }

}
