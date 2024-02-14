package net.cyberaakash.banking.repository;

import net.cyberaakash.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {


    @Query("SELECT ac FROM Account ac WHERE ac.balance > 0")
    List<Account> balNotZero();

}
