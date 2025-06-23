package com.banksystem.corebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banksystem.corebank.model.CurrentAccount;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {
    // Pas besoin de méthodes, tu peux ajouter des requêtes personnalisées si besoin
}
