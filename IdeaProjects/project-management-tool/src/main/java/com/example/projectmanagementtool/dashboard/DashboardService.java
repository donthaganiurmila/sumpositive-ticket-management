package com.example.projectmanagementtool.dashboard;

import com.example.projectmanagementtool.ticket.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {
    private final TicketRepository ticketRepository;
    public DashboardService(TicketRepository ticketRepository){
        this.ticketRepository=ticketRepository;
    }
    public Map<String,Long> getDashboardStatistics() {
        Map<String, Long> statistics = new HashMap<>();
        statistics.put("totalTickets", ticketRepository.count());
        statistics.put("toDoTickets", ticketRepository.countByStatus("TO_DO"));
        statistics.put("inProgressTickets",
                ticketRepository.countByStatus("IN_PROGRESS"));

        statistics.put("doneTickets",
                ticketRepository.countByStatus("DONE"));

        statistics.put("lowPriorityTickets",
                ticketRepository.countByPriority("LOW"));

        statistics.put("mediumPriorityTickets",
                ticketRepository.countByPriority("MEDIUM"));

        statistics.put("highPriorityTickets",
                ticketRepository.countByPriority("HIGH"));

        return statistics;
    }
}
