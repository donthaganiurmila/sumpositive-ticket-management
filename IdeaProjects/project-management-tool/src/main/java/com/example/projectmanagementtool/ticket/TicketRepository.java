package com.example.projectmanagementtool.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    long countByStatus(String status);
    long countByPriority(String priority);

}
