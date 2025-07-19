class CurrentAccount extends Account {
    public CurrentAccount(int balance) {
        super(balance);
    }

    @Override
    public double getBenefit() {
        return 0;
    }
}
