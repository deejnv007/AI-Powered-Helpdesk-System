package com.project.Helpdesk.tool;

import com.project.Helpdesk.entity.Ticket;
import com.project.Helpdesk.service.TicketService;
import jakarta.servlet.Servlet;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketDBTool {

    private final TicketService ticketService;

    //create ticket tool
    @Tool(description = "This tool helps in creating new ticket in Database")
    public Ticket createTicketTool(@ToolParam(description = "Ticket details.") Ticket ticket) {
        try{
            System.out.println("TicketDBTool: createTicketTool called with ticket: " + ticket);
            return ticketService.createTicket(ticket);
        }
        catch(Exception e){
            System.out.println("TicketDBTool: Error occurred while creating ticket: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

    }

    //update ticket tool
    @Tool(description = "This tool helps in updating existing ticket in Database")
    public Ticket updateTicketTool(@ToolParam(description = "new ticket details with ticket id.") Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }

    //get ticket by id tool
    @Tool(description = "This tool helps in fetching ticket from Database by id")
    public Ticket getTicketByIdTool(@ToolParam(description = "Ticket details for the provided id.") Long id) {
        return ticketService.getTicket(id);
    }

    //get ticket by email tool
    @Tool(description = "This tool helps in fetching ticket from Database by email")
    public Ticket getTicketByEmailTool(@ToolParam(description = "Ticket details for the provided email.") String email) {
        return ticketService.getTicketByEmail(email);
    }

    //get current system time
    @Tool(description = "This tool helps in fetching the current system time")
    public String getCurrentSystemTimeTool() {
        return String.valueOf(System.currentTimeMillis());
    }

}
