package com.pluralsight.hibernatefundamentals;

import com.pluralsight.hibernatefundamentals.airport.Ticket;
import com.pluralsight.hibernatefundamentals.airport.TicketKey;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex06");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Ticket ticket1 = new Ticket();
        ticket1.setSeries("AA");
        ticket1.setNumber("1234");
        ticket1.setOrigin("Bucharest");
        ticket1.setDestination("London");

        Ticket ticket2 = new Ticket();
        ticket2.setSeries("AA");
        ticket2.setNumber("2345");
        ticket2.setOrigin("Praha");
        ticket2.setDestination("Zurich");

        em.persist(ticket1);
        em.persist(ticket2);

        em.getTransaction().commit();
        emf.close();
    }
}
