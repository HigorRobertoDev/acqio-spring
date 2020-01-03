package com.api.acqio.domain;

import com.api.acqio.roles.CardEnum;
import com.api.acqio.roles.CardStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalDateTime time;
    private BigDecimal value;
    private CardEnum cardApplication;
    private CardStatusEnum status;

    public Card() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public CardEnum getCardApplication() {
        return cardApplication;
    }

    public void setCardApplication(CardEnum cardApplication) {
        this.cardApplication = cardApplication;
    }

    public CardStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CardStatusEnum status) {
        this.status = status;
    }
}
