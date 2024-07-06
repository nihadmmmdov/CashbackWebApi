package com.example.transactioncashback.Controller;

import com.example.transactioncashback.Dto.CreateCardRequest;
import com.example.transactioncashback.Dto.TransferRequest;
import com.example.transactioncashback.Dto.UpdateCardRequest;
import com.example.transactioncashback.Entity.Card;
import com.example.transactioncashback.Service.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;
    @PostMapping("/add/card")
    public String addNewCard(@RequestBody CreateCardRequest request){
        return cardService.addCard(request);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestBody TransferRequest request) {
        cardService.transferMoney(request.getFromCardNumber(), request.getToCardNumber(), request.getAmount());
        return ResponseEntity.ok("Transfer successful");
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateCard(@RequestBody UpdateCardRequest request) {
        cardService.updateCard(request);
        return ResponseEntity.ok("Card updated successfully");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return ResponseEntity.ok("Card deleted successfully");
    }
    @GetMapping("/get")
    public List<Card> getCards(){
        return cardService.getAllCards();
    }
}
