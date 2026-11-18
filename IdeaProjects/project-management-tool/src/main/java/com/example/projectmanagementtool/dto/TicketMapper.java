package com.example.projectmanagementtool.dto;

import com.example.projectmanagementtool.ticket.Ticket;

public class TicketMapper {
    public static Ticket toEntity(TicketRequest request){
        Ticket ticket=new Ticket();
        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setStatus(request.getStatus());
        ticket.setPriority(request.getPriority());
        ticket.setAssigneeId(request.getAssigneeId());
        return ticket;
    }
    public static TicketResponse toResponse(Ticket ticket){
        return new TicketResponse(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getStatus(),
                ticket.getPriority(),
                ticket.getAssigneeId(),
                ticket.getCreatedAt(),
                ticket.getUpdatedAt()
        );
    }
}
