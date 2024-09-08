package com.ust.bank;

public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Synchronized deposit method to ensure thread safety
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + " to account " + accountNumber);
    }

    // Synchronized withdraw method to ensure thread safety
    public synchronized boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + " from account " + accountNumber + " but insufficient balance.");
            return false;
        } else {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + " from account " + accountNumber);
            return true;
        }
    }

    // Synchronized transfer method to ensure thread safety
    public synchronized void transfer(Account toAccount, double amount) {
        if (this.withdraw(amount)) {
            toAccount.deposit(amount);
            System.out.println(Thread.currentThread().getName() + " transferred " + amount + " from account " + this.accountNumber + " to account " + toAccount.getAccountNumber());
        }
    }
}

