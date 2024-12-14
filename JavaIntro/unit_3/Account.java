package unit_3;

public class Account {

    private final long DEF_ACCOUNT = 12345l;
    private String _name;
    private String _bank;
    private double _balance;
    private long _accountNum;

    public Account(String name, String bank, long accNnum, double balance) {
        _name = name;
        _bank = bank;
        _balance = balance;
        if (10000 > accNnum || accNnum >= 100000) {
            accNnum = DEF_ACCOUNT;
        }
        _accountNum = accNnum;
    }

    public String toString() {
        return _name +", " + _bank + ", " + _accountNum + ", " + _balance;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getBank() {
        return _bank;
    }

    public void setBank(String bank) {
        _bank = bank;
    }

    public double getBalance() {
        return _balance;
    }

    public void setBalance(double balance) {
        _balance = balance;
    }

    public long getAccountNum() {
        return _accountNum;
    }

    public void setAccountNum(long accNum) {
        if (10000 <= accNum && accNum < 100000) 
            _accountNum = accNum;
    }

    public boolean equals( Account other) {
        return (_accountNum == other._accountNum) && 
                (_balance == other._balance) &&
                (_bank.equals(other._bank)) &&
                (_name.equals(other._name));
    }

}
