package br.com.via.poc.plataformas.ui.transaction;

import br.com.via.poc.plataformas.app.CreateTransactionService;
import br.com.via.poc.plataformas.app.UpdateTransactionStatusService;
import br.com.via.poc.plataformas.ui.transaction.dto.TransactionDto;
import br.com.via.poc.plataformas.ui.transaction.dto.create.CreateTransactionResponse;
import br.com.via.poc.plataformas.ui.transaction.dto.update.UpdateTransactionStatusDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
class TransactionController {

    private final CreateTransactionService createService;

    private final UpdateTransactionStatusService updateService;

    TransactionController(CreateTransactionService createService, UpdateTransactionStatusService updateService) {
        this.createService = createService;
        this.updateService = updateService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/transaction")
    CreateTransactionResponse register(@RequestBody TransactionDto transaction) {
        String transactionId = createService.execute(transaction);
        return new CreateTransactionResponse(transactionId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/transaction/{id}")
    void update(@PathVariable String id, @RequestBody UpdateTransactionStatusDto updateTransactionStatus) {
        updateService.execute(id, updateTransactionStatus);
    }

}
