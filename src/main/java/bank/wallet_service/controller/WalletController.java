package bank.wallet_service.controller;

import org.springframework.web.bind.annotation.*;

import bank.wallet_service.entity.Wallet;
import bank.wallet_service.service.WalletService;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    // ✅ CREATE WALLET
    @PostMapping("/{userId}")
    public Wallet createWallet(@PathVariable Long userId) {
        return walletService.createWallet(userId);
    }

    // ✅ GET WALLET
    @GetMapping("/{userId}")
    public Wallet getWallet(@PathVariable Long userId) {
        return walletService.getWalletByUserId(userId);
    }

    // ✅ ADD BALANCE
    @PutMapping("/add/{userId}/{amount}")
    public Wallet addBalance(@PathVariable Long userId,
                             @PathVariable Double amount) {
        return walletService.addBalance(userId, amount);
    }

    // ✅ DEDUCT BALANCE
    @PutMapping("/deduct/{userId}/{amount}")
    public Wallet deductBalance(@PathVariable Long userId,
                                @PathVariable Double amount) {
        return walletService.deductBalance(userId, amount);
    }
}
