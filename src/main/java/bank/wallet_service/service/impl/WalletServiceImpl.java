package bank.wallet_service.service.impl;

import org.springframework.stereotype.Service;

import bank.wallet_service.entity.Wallet;
import bank.wallet_service.repository.WalletRepository;
import bank.wallet_service.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Wallet createWallet(Long userId) {
        Wallet wallet = new Wallet();
        wallet.setUserId(userId);
        wallet.setBalance(0.0);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet getWalletByUserId(Long userId) {
        return walletRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
    }

    @Override
    public Wallet addBalance(Long userId, Double amount) {
        Wallet wallet = getWalletByUserId(userId);
        wallet.setBalance(wallet.getBalance() + amount);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet deductBalance(Long userId, Double amount) {
        Wallet wallet = getWalletByUserId(userId);

        if (wallet.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }

        wallet.setBalance(wallet.getBalance() - amount);
        return walletRepository.save(wallet);
    }
}
