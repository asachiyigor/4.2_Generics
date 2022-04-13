package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.Repository;

import java.util.Arrays;

public class Manager {
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public Ticket[] findTickets(String from, String to) {
        Ticket[] tickets = new Ticket[0];
        Ticket[] ticketsAll = repository.getAll();
        for (Ticket ticket : ticketsAll) {
            if (ticket.getFrom()
                      .equalsIgnoreCase(from) && ticket.getTo()
                                                       .equalsIgnoreCase(to)) {
                int length = tickets.length + 1;
                Ticket[] tmp = new Ticket[length];
                System.arraycopy(tickets, 0, tmp, 0, tickets.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                tickets = tmp;
            }
        }
        Arrays.sort(tickets);
        return tickets;
    }
}