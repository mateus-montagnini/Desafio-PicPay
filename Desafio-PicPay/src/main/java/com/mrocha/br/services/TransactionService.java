package com.mrocha.br.services;

import com.mrocha.br.domain.user.User;
import com.mrocha.br.dto.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    public void createTransaction(TransactionDTO transaction) {
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());
    }
}
