package com.example.projectmanagementtool.ticket;


import com.example.projectmanagementtool.dto.TicketMapper;
import com.example.projectmanagementtool.dto.TicketRequest;
import com.example.projectmanagementtool.dto.TicketResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository=ticketRepository;
    }

    public TicketResponse createTicket(TicketRequest request){
        Ticket ticket= TicketMapper.toEntity(request);
        Ticket savedTicket=ticketRepository.save(ticket);
        return TicketMapper.toResponse(savedTicket);
    }

    public List<TicketResponse> getAllTickets(){

        return ticketRepository.findAll()
                .stream()
                .map(TicketMapper::toResponse)
                .toList();
    }

    public Optional<TicketResponse> getTicketById(Long id){

        return ticketRepository.findById(id)
                .map(TicketMapper::toResponse);
    }

    public TicketResponse updateTicket(Long id,TicketRequest request){
        Ticket existingTicket=ticketRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Ticket not Found"));

        existingTicket.setTitle(request.getTitle());
        existingTicket.setDescription(request.getDescription());
        existingTicket.setStatus(request.getStatus());
        existingTicket.setPriority(request.getPriority());
        existingTicket.setAssigneeId(request.getAssigneeId());
        Ticket updatedTicket=ticketRepository.save(existingTicket);

        return TicketMapper.toResponse(updatedTicket);
    }

    public void deleteTicket(Long id){
        ticketRepository.deleteById(id);
    }
}
