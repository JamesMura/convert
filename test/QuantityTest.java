
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


public class QuantityTest {

    @Test
    public void shouldCompareInchesToFeet() {
        assertNotNull(Quantity.feet(1));
        assertNotNull(Quantity.inches(12));
        assertEquals(Quantity.feet(1), Quantity.inches(12));
    }

    @Test
    public void shouldCompareFeetToYards() {
        assertEquals(Quantity.feet(3), Quantity.yard(1));
    }
    @Test
    public void shouldCompareInchesToCentimetres() {
        assertEquals(Quantity.inches(1), Quantity.centimetres(2.54));
    }
    @Test
    public void shouldAddInchesToInches() {
        assertEquals(Quantity.inches(2).add(Quantity.inches(2)), Quantity.inches(4));
    }

    @Test
    public void shouldAddInchesToCentimeters() {
        assertEquals(Quantity.inches(2).add(Quantity.centimetres(2.54)), Quantity.inches(3));
    }

    @Test
    public void shouldCompareGallonsWithLitres() {
        assertNotNull(Quantity.gallons(1));
        assertEquals(Quantity.gallons(1), Quantity.litres(3.78));
    }
    @Test
    public void shouldAddAGallonToALitre() {
        assertThat(Quantity.gallons(1.0).add(Quantity.litres(1.0)), is(Quantity.litres(4.779999999999999)));
    }
}
