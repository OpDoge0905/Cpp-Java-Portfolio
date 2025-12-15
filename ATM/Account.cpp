#include "Account.h"
#include <iostream>

Account::Account(std::string initName, double initBalance){
    name = initName;
    balance = initBalance;
}

void Account::deposit(double amount){
    if(amount > 0){
        balance += amount;
        std::cout << "Sucessed! Deposited: " << amount << std::endl;
    }
    else{
        std::cout << "ERROR: Must > 0\n";
    }
}

bool Account::withdraw(double amount){
    if(balance<amount && amount>0){
        std::cout << "Balance not enough!\n";
        return false;
    }
    else if(amount<0){
        std::cout << "ERROR: Must > 0\n";
        return false;
    }
    else{
        balance -= amount;
        std::cout << "Sucessed! Withdrew: " << amount << std::endl << "You have "<< getBalance() << "in your account now.\n";
    }
}

double Account::getBalance(){
    return balance;
}

void Account::printInfo(){
    std::cout << "-------------------" << std::endl;
    std::cout << "Account Name: " << name << std::endl;
    std::cout << "Balance: $" << balance << std::endl;
    std::cout << "-------------------" << std::endl;
}

std::string Account::getName(){
    return name;
}


