package com.api.acqio.service;

import com.api.acqio.domain.Card;
import com.api.acqio.dto.CardDTO;
import com.api.acqio.repository.CardRepository;
import com.api.acqio.representation.CardRepresentation;
import com.api.acqio.roles.CardEnum;
import com.api.acqio.roles.CardStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public Card save(CardDTO cardDTO) {
        return cardRepository.save(from(cardDTO));
    }

    public Card from(CardDTO cardDTO) {
        Card card = new Card();

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

}
