package com.example.transactioncashback.Service.card;

import com.example.transactioncashback.Dto.CreateCardRequest;
import com.example.transactioncashback.Dto.UpdateCardRequest;
import com.example.transactioncashback.Entity.Card;
import com.example.transactioncashback.Entity.Operation;
import com.example.transactioncashback.Repository.card.CardRepository;
import com.example.transactioncashback.Repository.operation.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final OperationRepository transactionRepository;
    @Transactional
    public void transferMoney(String fromCardNumber, String toCardNumber, BigDecimal amount) {
        Card fromCard = cardRepository.findByCardNumber(fromCardNumber)
                .orElseThrow(() -> new RuntimeException("From card not found"));
        Card toCard = cardRepository.findByCardNumber(toCardNumber)
                .orElseThrow(() -> new RuntimeException("To card not found"));

        if (fromCard.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient funds");
        }

        fromCard.setBalance(fromCard.getBalance().subtract(amount));
        toCard.setBalance(toCard.getBalance().add(amount));

        Operation operation = new Operation();
        operation.setFromCard(fromCard);
        operation.setToCard(toCard);
        operation.setAmount(amount);
        operation.setTimestamp(LocalDateTime.now());

        cardRepository.save(fromCard);
        cardRepository.save(toCard);
        transactionRepository.save(operation);
    }

    public String addCard(CreateCardRequest request){
        Optional<Card> card = cardRepository.findByCardNumber(request.getCardNumber());
        if(Objects.nonNull(card)){
            Card newCard = new Card();
            newCard.setCardNumber(request.getCardNumber());
            newCard.setCardHolderName(request.getCardHolderName());
            newCard.setBalance(request.getBalance());
            cardRepository.save(newCard);
            return newCard.getCardHolderName() + " new card created";
        }
        else{
            return "Card number is already exist";
        }
    }

    public String deleteCard(Long id){
        Card existingCard = cardRepository.getById(id);
        if(Objects.isNull(existingCard)){
            return "Card does not exist";
        }
        cardRepository.delete(existingCard);
        return existingCard.getCardNumber() + "Successfully deleted";
    }
    public String updateCard(UpdateCardRequest request){
        Card existingCard = cardRepository.getById(request.getId());
        if(Objects.isNull(existingCard)){
            return "Card does not exist";
        }
        existingCard.setCardNumber(request.getCardNumber());
        existingCard.setCardHolderName(request.getCardHolderName());
        cardRepository.save(existingCard);
        return existingCard.getCardNumber() + "Successfully updated";
    }
    public List<Card> getAllCards(){
        return cardRepository.findAll();
    }
}
