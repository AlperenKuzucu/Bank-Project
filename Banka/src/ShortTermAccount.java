class ShortTermAccount extends Account {
    public static final int MIN_BALANCE = 1000;
    public static final double INTEREST_RATE = 0.17;

    public ShortTermAccount(int balance) {
        super(balance);
    }

    @Override
    public double getBenefit() {
        return getBalance() * INTEREST_RATE / 365;
    }
}