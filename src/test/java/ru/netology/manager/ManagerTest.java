package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByPriceAscComparator;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class ManagerTest {

    private Repository repository = new Repository();
    private Manager manager = new Manager(repository);

    private Ticket first = new Ticket(1, 3230, "LED", "DME", 95);
    private Ticket second = new Ticket(2, 107000, "LED", "LHR", 540);
    private Ticket third = new Ticket(3, 3000, "LED", "VKO", 90);
    private Ticket fourth = new Ticket(4, 3100, "LED", "VKO", 89);

    @Test
    void shouldFindTickets() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        TicketByPriceAscComparator comparator = new TicketByPriceAscComparator();
        Ticket[] actual = manager.findTickets("LED", "VKO", comparator);
        Ticket[] expected = new Ticket[]{fourth, third};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldNotFindTickets() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        TicketByPriceAscComparator comparator = new TicketByPriceAscComparator();
        Ticket[] actual = manager.findTickets("VKO", "LED", comparator);
        Ticket[] expected = new Ticket[]{};

        assertArrayEquals(expected, actual);
    }
}