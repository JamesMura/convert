//Understand different units of measurements.

public class Quantity {

    private double baseQuantity;
    private final Unit unit;

    private Quantity(double baseQuantity, Unit unit) {
        this.baseQuantity = baseQuantity;
        this.unit = unit;
    }

    public static Quantity feet(double value) {
        return new Quantity(value, Unit.FOOT);
    }

    public static Quantity inches(double value) {
        return new Quantity(value, Unit.INCH);
    }

    public static Quantity yard(double value) {
        return new Quantity(value, Unit.YARD);
    }

    public static Quantity centimetres(double value) {
        return new Quantity(value, Unit.CM);
    }

    public static Quantity gallons(double value) {
        return new Quantity(value, Unit.GALLON);
    }

    public static Quantity litres(double value) {
        return new Quantity(value, Unit.LITRE);
    }

    public static Quantity fahr(double temparature) {
        return new Quantity(temparature / 100, Unit.FAHR);
    }

    public static Quantity cel(double temperature) {
        return new Quantity(temperature / 100, Unit.CEL);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return inBaseUnit() == ((Quantity) o).inBaseUnit();
    }

    private double inBaseUnit() {
        return unit.inBaseUnit(baseQuantity);
    }

    @Override
    public String toString() {
        return "Quantity{" + "baseQuantity=" + baseQuantity + '}';
    }

    public Quantity add(Quantity otherQuantity) throws DifferentUnitsException {
        if (unit.comparableWith(otherQuantity.unit)) {
            return new Quantity(inBaseUnit() + otherQuantity.inBaseUnit(), Unit.CM);
        } else {
            throw new DifferentUnitsException();
        }
    }
}

class Unit {
    private static final double CENTIMETRES_PER_INCH = 2.54;
    private static final double CENTIMETRES_PER_FOOT = 12 * CENTIMETRES_PER_INCH;
    private static final double CENTIMETRES_PER_YARD = 3 * CENTIMETRES_PER_FOOT;
    private static final int CENTIMETER = 1;
    private static final int BASE_LITRE = 1;
    private static final double LITRES_PER_GALLON = 3.78;
    private static final double DEGREES_F = 1;
    private static final double DEGREES_F_PER_C = 2.12;


    private static final String TEMPERATURE = "temperature";
    private static final String LENGTH = "length";
    private static final String VOLUME = "volume";

    private double conversationFactor;
    private String unitType;

    public static final Unit CM = new Unit(CENTIMETER, LENGTH);
    public static final Unit INCH = new Unit(CENTIMETRES_PER_INCH, LENGTH);
    public static final Unit YARD = new Unit(CENTIMETRES_PER_YARD, LENGTH);
    public static final Unit FOOT = new Unit(CENTIMETRES_PER_FOOT, LENGTH);
    public static final Unit LITRE = new Unit(BASE_LITRE, VOLUME);
    public static final Unit GALLON = new Unit(LITRES_PER_GALLON, VOLUME);
    public static final Unit FAHR = new Unit(DEGREES_F, TEMPERATURE);
    public static final Unit CEL = new Unit(DEGREES_F_PER_C, TEMPERATURE);

    private Unit(double conversionFactor, String unitType) {
        this.conversationFactor = conversionFactor;
        this.unitType = unitType;

    }

    public double inBaseUnit(double value) {
        return value * conversationFactor;
    }

    public Boolean comparableWith(Unit otherUnit) {
        return unitType.equals(otherUnit.unitType);
    }
}

class DifferentUnitsException extends Exception {

}
