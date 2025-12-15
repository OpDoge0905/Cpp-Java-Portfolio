#ifndef ATM_h
#define ATM_h

#include <string>

class Account {
private:
    std::string name;
    double balance;
public:
    Account(std::string initName, double initBalance);

    void deposit(double amount);
    bool withdraw(double amount);
    double getBalance();
    void printInfo();
    std::string getName();

};

#endif