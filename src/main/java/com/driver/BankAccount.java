package com.driver;



public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;

    }

    public String generateAccountNumber(int digits, int total) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        String accountNumber="";
        accountCheck(accountNumber,0,0,digits,total);
        return accountNumber;
    }
    public void accountCheck(String acnNo,int idx,int cSum,int digits,int sum){
        if(idx>digits|| sum<0)
            return;
        if(idx==digits){
            if(cSum==sum){
                System.out.println(acnNo);
            }
            return;
        }
        for(char ch='0';ch<='9';ch++)
            accountCheck(acnNo+ch, idx+1, cSum+(ch-'0'), digits, sum);

    }

    public void deposit(double amount) {
        //add amount to balance

        this.balance+=amount;


    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if((this.balance-amount)>=this.minBalance)
            this.balance-=amount;
        else
            throw new Exception("Insufficient Balance");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

}