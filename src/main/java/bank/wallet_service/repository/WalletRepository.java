package bank.wallet_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.wallet_service.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findByUserId(Long userId);
}
