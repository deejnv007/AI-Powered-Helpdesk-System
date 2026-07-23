package com.project.Helpdesk.service;

import com.project.Helpdesk.entity.Ticket;
import com.project.Helpdesk.repository.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    //create ticket
    @Transactional
    public Ticket createTicket(Ticket ticket){
        ticket.setId(null); // Let the database generate the ID
        return ticketRepository.save(ticket);
    }

    //update ticket
    @Transactional
    public Ticket updateTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    //get ticket by id
    public Ticket getTicket(Long id){
        return ticketRepository.findById(id).orElse(null);
    }

    //get ticket by email
    public Ticket getTicketByEmail(String email){
        return ticketRepository.findByEmail(email).orElse(null);
    }
}
