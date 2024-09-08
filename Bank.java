package com.ust.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();

    // Create a new account and add it to the bank
    public void createAccount(String accountNumber, double initialBalance) {
        Account account = new Account(accountNumber, initialBalance);
        accounts.put(accountNumber, account);
    }

    // Get account by account number
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    // Simulate transactions using threads
    public void simulateTransactions() {
        Thread t1 = new Thread(() -> {
            Account acc1 = getAccount("123");
            acc1.deposit(100);
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            Account acc2 = getAccount("456");
            acc2.withdraw(50);
        }, "Thread-2");

        Thread t3 = new Thread(() -> {
            Account acc1 = getAccount("123");
            Account acc2 = getAccount("456");
            acc1.transfer(acc2, 75);
        }, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        // Join threads to ensure all transactions complete
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance of account 123: " + getAccount("123").getBalance());
        System.out.println("Final balance of account 456: " + getAccount("456").getBalance());
    }
}

