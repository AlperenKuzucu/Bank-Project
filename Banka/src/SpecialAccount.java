class SpecialAccount extends Account {
    public static final double INTEREST_RATE = 0.12;
    public static final int MIN_BALANCE_MULTIPLIER = 1;
    private Object accountID;

    public SpecialAccount(int balance) {
        super(balance);
    }

    @Override
    public double getBenefit() {
        return getBalance() * INTEREST_RATE / 365;
    }

    @Override
    public void deposit(int amount) {
        super.deposit(amount);
        if (amount >= 2000) {
            int pointsEarned = amount / 2000;
            // Hesaba para eklendikten sonraki çekiliş sayısını artıran kodlar yazılabilir.
        }
    }

    String getAccountID() {
   
        
return String.valueOf(accountID);
   
    }
}