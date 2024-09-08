package com.ust.bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Create two accounts
        bank.createAccount("123", 500);
        bank.createAccount("456", 300);

        // Simulate multiple transactions using threads
        bank.simulateTransactions();
    }
}

