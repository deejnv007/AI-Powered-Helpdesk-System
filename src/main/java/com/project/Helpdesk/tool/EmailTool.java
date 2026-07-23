package com.project.Helpdesk.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class EmailTool {

    //send ticket to support team regarding new tickets
    @Tool(description = "This tool helps in sending email to support team regarding new tickets")
    public void sendEmailToSupportTeam(@ToolParam(description = "The email address for contacting the user") String email, @ToolParam(description = "Short description of the ticket to support team") String message) {

        //sending email to support team logic here
        System.out.println("EmailTool: Sending email to support team regarding new ticket to contact user with email: " + email);
        System.out.println("EmailTool: message sent to support team regarding new ticket: " + message);

    }
}
