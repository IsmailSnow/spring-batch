package org.id.bankspringbatch.config;

import org.id.bankspringbatch.dao.BankTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


public class BankTransactionProcessor implements ItemProcessor<BankTransaction, BankTransaction> {

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy-HH:mm");

    @Override
    public BankTransaction process(BankTransaction bankTransaction) throws Exception {
        bankTransaction.setTransactionDate(format.parse(bankTransaction.getDateFormat()));
        return bankTransaction;
    }
}
