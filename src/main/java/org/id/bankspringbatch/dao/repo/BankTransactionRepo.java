package org.id.bankspringbatch.dao.repo;

import org.id.bankspringbatch.dao.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankTransactionRepo extends JpaRepository<BankTransaction,Long> {
}
