import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class VolumeTest {

    @Test
    public void shouldCompareGallonsAndLitres() {
        assertNotNull(Volume.gallons(1));

        assertEquals(Volume.gallons(1), Volume.litres(3.78));

    }
}
