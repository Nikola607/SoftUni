package WorkingWithAbstraction.HotelReservation;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    SUMMER(4),
    WINTER(3);

    private int multiplier;

    Season(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
