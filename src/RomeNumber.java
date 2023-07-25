public enum RomeNumber {
    I(1), II(2), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100);

    private final int value;

    RomeNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
