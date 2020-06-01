package org.id.bankspringbatch.config;


import org.id.bankspringbatch.dao.BankTransaction;
import org.id.bankspringbatch.dao.repo.BankTransactionRepo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankTransacionItemWriter implements ItemWriter<BankTransaction> {

    private BankTransactionRepo bankTransactionRepo;

    public BankTransacionItemWriter(BankTransactionRepo bankTransactionRepo) {
        this.bankTransactionRepo = bankTransactionRepo;
    }

    @Override
    public void write(List<? extends BankTransaction> list) throws Exception {
        bankTransactionRepo.saveAll(list);
    }
}
