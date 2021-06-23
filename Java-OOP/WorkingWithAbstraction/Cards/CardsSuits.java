package WorkingWithAbstraction.Cards;

public enum CardsSuits {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    @Override
    public String toString(){
        return String.format("Ordinal value: %d; Name value: %s", ordinal(), name());
    }
}
