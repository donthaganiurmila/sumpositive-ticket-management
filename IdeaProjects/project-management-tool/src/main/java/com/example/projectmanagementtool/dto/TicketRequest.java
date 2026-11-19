package com.example.projectmanagementtool.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TicketRequest {

    @NotBlank(message = "Ticket title is required")
    @Size(min=3,max=100,message="Title must contain between 3 and 100 characters")
    private String title;

    @Size(max=1000,message="Description cannot exceed 1000 characters")
    private String description;

    @NotBlank(message="Ticket status is required")
    private String status;

    @NotBlank(message = "Ticket priority is required")
    private String priority;
    private Long assigneeId;
    public TicketRequest(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Long getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }
}
