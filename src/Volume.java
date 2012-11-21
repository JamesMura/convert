//Understands different units of measurements

public class Volume {

    public static final double LITRES_PER_GALLON = 3.78;
    private final double litres;

    public Volume(double litres) {
        this.litres = litres;
    }

    public static Volume litres(double litres) {
        return new Volume(litres);
    }

    public static Volume gallons(double gallons) {
        return new Volume(gallons * LITRES_PER_GALLON);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return litres == ((Volume) o).litres;
    }


}
