package br.com.via.poc.plataformas.app;

import br.com.via.poc.plataformas.app.dto.TransactionEvent;

public interface TransactionEventSender {

    void sendEvent(TransactionEvent event);

}
