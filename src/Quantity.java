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
        return "Quantity{" + "baseQuantity=" + baseQuantity +'}';
    }

    public Quantity add(Quantity otherQuantity) {
        return new Quantity(inBaseUnit() + otherQuantity.inBaseUnit(), Unit.CM);
    }
}

class Unit {
    private static final double CENTIMETRES_PER_INCH = 2.54;
    private static final double CENTIMETRES_PER_FOOT = 12 * CENTIMETRES_PER_INCH;
    private static final double CENTIMETRES_PER_YARD = 3 * CENTIMETRES_PER_FOOT;
    private static final int CENTIMETER = 1;
    private static final int BASE_LITRE = 1;
    private static final double LITRES_PER_GALLON = 3.78;


    public static final Unit CM = new Unit(CENTIMETER);
    public static final Unit INCH = new Unit(CENTIMETRES_PER_INCH);
    public static final Unit YARD = new Unit(CENTIMETRES_PER_YARD);
    public static final Unit FOOT = new Unit(CENTIMETRES_PER_FOOT);
    public static final Unit LITRE = new Unit(BASE_LITRE);
    public static final Unit GALLON = new Unit(LITRES_PER_GALLON);

    private final double conversationFactor;

    private Unit(double conversionFactor) {
        this.conversationFactor =  conversionFactor;
    }

    public double inBaseUnit(double value) {
        return value * conversationFactor;
    }


}
