package net.cyberaakash.banking.repository;

import net.cyberaakash.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
