class LongTermAccount extends Account {
    public static final int MIN_BALANCE = 1500;
    public static final double INTEREST_RATE = 0.24;

    public LongTermAccount(int balance) {
        super(balance);
    }

    @Override
    public double getBenefit() {
        return getBalance() * INTEREST_RATE / 365;
    }
}