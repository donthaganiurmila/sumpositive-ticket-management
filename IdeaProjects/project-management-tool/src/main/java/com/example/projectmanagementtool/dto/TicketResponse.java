package com.example.projectmanagementtool.dto;

import java.time.LocalDateTime;

public class TicketResponse {
    private Long id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private Long assigneeId;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    public TicketResponse(){}
    public TicketResponse(Long id,String title,String description,String status
    ,String priority,Long assigneeId,LocalDateTime createdAt,LocalDateTime updateAt){
        this.id=id;
        this.title=title;
        this.description=description;
        this.status=status;
        this.priority=priority;
        this.assigneeId=assigneeId;
        this.createdAt=createdAt;
        this.updateAt=updateAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public Long getAssigneeId() {
        return assigneeId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }
}
