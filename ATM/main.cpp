#include "Account.h"
#include <iostream>

int main(){
    std::cout<< "=== ATM Service Activating... ===" << std::endl;
    Account myAcc("ducky", 1000);

    myAcc.printInfo();

    std::cout<<"[Test] Deposit 500$";
    myAcc.deposit(500);

    myAcc.printInfo();

    std::cout<<"[Test] Deposit 600$";
    if(myAcc.withdraw(600)){
        std::cout<< "Sucessed!\n";
    }
    else{
        std::cout<< "Error!\n";
    }
    std::cout<<"[Test] Deposit 2000$";
    myAcc.withdraw(2000);
    if(myAcc.withdraw(2000)){
        std::cout<< "Sucessed!\n";
    }
    else{
        std::cout<< "Error!\n";
    }

    myAcc.printInfo();

    return 0;
}