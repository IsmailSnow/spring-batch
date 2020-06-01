package org.id.bankspringbatch.dao;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class BankTransaction {

       @Id
       private Long id;
       private long accountID;
       private Date transactionDate;
       @Transient
       private String dateFormat;
       private String transactionType;
       private double amount;

}
