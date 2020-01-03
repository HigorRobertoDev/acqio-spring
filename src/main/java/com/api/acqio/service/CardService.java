package com.api.acqio.service;

import com.api.acqio.domain.Card;
import com.api.acqio.dto.CardDTO;
import com.api.acqio.repository.CardRepository;
import com.api.acqio.representation.CardRepresentation;
import com.api.acqio.roles.CardEnum;
import com.api.acqio.roles.CardStatusEnum;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public CardRepresentation save(CardDTO cardDTO) throws NotFoundException {
        if (cardDTO.getId() != null) {
            Optional<Card> card = Optional.ofNullable(cardRepository.findById(cardDTO.getId())
                    .orElseThrow(() -> new NotFoundException("id not exists: " + cardDTO.getId())));
        }
        return from(cardRepository.save(from(cardDTO)));
    }

    public List<CardRepresentation> getAll() {
        return from(cardRepository.findAll());
    }

    public Card from(CardDTO cardDTO) {
        Card card = new Card();

        card.setId(cardDTO.getId());
        card.setDate(cardDTO.getDate());
        card.setTime(cardDTO.getTime());
        card.setValue(cardDTO.getValue());
        card.setCardApplication(CardEnum.valueOf(cardDTO.getCardApplication()));
        card.setStatus(CardStatusEnum.valueOf(cardDTO.getStatus()));
        return card;
    }

    public CardRepresentation from(Card card) {
        CardRepresentation representation = new CardRepresentation();

        representation.setId(card.getId());
        representation.setTime(card.getTime());
        representation.setDate(card.getDate());
        representation.setValue(card.getValue());
        representation.setCardApplication(card.getCardApplication().toString());
        representation.setStatus(card.getStatus().toString());
        return representation;
    }

    public List<CardRepresentation> from(List<Card> cardList) {
        List<CardRepresentation> representationList = new ArrayList<>();
        cardList.stream()
                .forEach(card -> {
                    CardRepresentation representation = new CardRepresentation();
                    representation.setId(card.getId());
                    representation.setCardApplication(card.getCardApplication().toString());
                    representation.setStatus(card.getStatus().toString());
                    representation.setDate(card.getDate());
                    representation.setTime(card.getTime());
                    representation.setValue(card.getValue());
                    representationList.add(representation);
                });
        return representationList;
    }

}
