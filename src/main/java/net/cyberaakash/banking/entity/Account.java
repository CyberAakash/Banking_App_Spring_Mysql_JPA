package net.cyberaakash.banking.entity;

import jakarta.persistence.*;
import lombok.*;


//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
@Entity
public @Data class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    private double balance;
}
