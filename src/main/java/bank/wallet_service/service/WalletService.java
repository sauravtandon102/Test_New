package bank.wallet_service.service;

import bank.wallet_service.entity.Wallet;

public interface WalletService {

    Wallet createWallet(Long userId);

    Wallet getWalletByUserId(Long userId);

    Wallet addBalance(Long userId, Double amount);

    Wallet deductBalance(Long userId, Double amount);
}
