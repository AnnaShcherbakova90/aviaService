package ru.netology.aviaservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void testSortFewTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","SPB",200,10,12);
        Ticket ticket2 = new Ticket("MSK","SPB",100,11,14);
        Ticket ticket3 = new Ticket("MSK","UFA",200,8,11);
        Ticket ticket4 = new Ticket("MSK","SPB",800,10,12);
        Ticket ticket5 = new Ticket("UFA","MSK",300,7,7);
        Ticket ticket6 = new Ticket("MSK","SPB",500,17,18);
        Ticket ticket7 = new Ticket("NEW","LA",200,10,16);
        Ticket ticket8 = new Ticket("MSK","SPB",400,6,9);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK","SPB");
        Ticket[] expected = {ticket2, ticket1, ticket8, ticket6, ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortZeroTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","SPB",200,10,12);
        Ticket ticket2 = new Ticket("MSK","SPB",100,11,14);
        Ticket ticket3 = new Ticket("MSK","UFA",200,8,11);
        Ticket ticket4 = new Ticket("MSK","SPB",800,10,12);
        Ticket ticket5 = new Ticket("UFA","MSK",300,7,7);
        Ticket ticket6 = new Ticket("MSK","SPB",500,17,18);
        Ticket ticket7 = new Ticket("NEW","LA",200,10,16);
        Ticket ticket8 = new Ticket("MSK","SPB",400,6,9);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK","LA");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortOneTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","SPB",200,10,12);
        Ticket ticket2 = new Ticket("MSK","SPB",100,11,14);
        Ticket ticket3 = new Ticket("MSK","UFA",200,8,11);
        Ticket ticket4 = new Ticket("MSK","SPB",800,10,12);
        Ticket ticket5 = new Ticket("UFA","MSK",300,7,7);
        Ticket ticket6 = new Ticket("MSK","SPB",500,17,18);
        Ticket ticket7 = new Ticket("NEW","LA",200,10,16);
        Ticket ticket8 = new Ticket("MSK","SPB",400,6,9);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("NEW","LA");
        Ticket[] expected = {ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","SPB",200,10,11); // 1
        Ticket ticket2 = new Ticket("MSK","SPB",100,11,14); // 3
        Ticket ticket3 = new Ticket("MSK","UFA",200,8,11);
        Ticket ticket4 = new Ticket("MSK","SPB",800,10,12); // 2
        Ticket ticket5 = new Ticket("UFA","MSK",300,7,7);
        Ticket ticket6 = new Ticket("MSK","SPB",500,13,18); //5
        Ticket ticket7 = new Ticket("NEW","LA",200,10,16);
        Ticket ticket8 = new Ticket("MSK","SPB",400,10,14); //4
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK","SPB",comparator);
        Ticket[] expected = {ticket1, ticket4, ticket2, ticket8, ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortOneTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","SPB",200,10,11); // 1
        Ticket ticket2 = new Ticket("MSK","SPB",100,11,14); // 3
        Ticket ticket3 = new Ticket("MSK","UFA",200,8,11);
        Ticket ticket4 = new Ticket("MSK","SPB",800,10,12); // 2
        Ticket ticket5 = new Ticket("UFA","MSK",300,7,7);
        Ticket ticket6 = new Ticket("MSK","SPB",500,13,18); //5
        Ticket ticket7 = new Ticket("NEW","LA",200,10,16);
        Ticket ticket8 = new Ticket("MSK","SPB",400,10,14); //4
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("NEW","LA",comparator);
        Ticket[] expected = {ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortZeroTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","SPB",200,10,11); // 1
        Ticket ticket2 = new Ticket("MSK","SPB",100,11,14); // 3
        Ticket ticket3 = new Ticket("MSK","UFA",200,8,11);
        Ticket ticket4 = new Ticket("MSK","SPB",800,10,12); // 2
        Ticket ticket5 = new Ticket("UFA","MSK",300,7,7);
        Ticket ticket6 = new Ticket("MSK","SPB",500,13,18); //5
        Ticket ticket7 = new Ticket("NEW","LA",200,10,16);
        Ticket ticket8 = new Ticket("MSK","SPB",400,10,14); //4
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("UFA","LA",comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
