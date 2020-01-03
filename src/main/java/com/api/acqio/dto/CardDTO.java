package com.api.acqio.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CardDTO {

    private Long id;
    private LocalDate date = LocalDate.now();
    private LocalDateTime time = LocalDateTime.now();
    private BigDecimal value;
    private String cardApplication;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCardApplication() {
        return cardApplication;
    }

    public void setCardApplication(String cardApplication) {
        this.cardApplication = cardApplication;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
