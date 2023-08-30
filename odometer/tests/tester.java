package odometer.tests;

import static org.junit.Assert.*;
import org.junit.*;

import odometer.Odometer;
import odometer.exceptions.NonAscendingReadingException;
import odometer.exceptions.ReadingException;
import odometer.exceptions.ReadingSizeMismatchException;

class testers{

    @Test
    public void testGetMinReading() {
        assertEquals(1, Odometer.getMinReading(1));
        assertEquals(12, Odometer.getMinReading(2));
        assertEquals(123, Odometer.getMinReading(3));
    }

    @Test
    public void testGetMaxReading() {
        assertEquals(9, Odometer.getMaxReading(1));
        assertEquals(89, Odometer.getMaxReading(2));
        assertEquals(789, Odometer.getMaxReading(3));
    }

    @Test
    public void testGetSize() {
        assertEquals(1, Odometer.getSize(5));
        assertEquals(2, Odometer.getSize(23));
        assertEquals(3, Odometer.getSize(456));
    }

    @Test
    public void testConstructor() {
        Odometer odo = new Odometer(3);
        assertEquals(123, odo.getReading());
    }

    @Test
    public void testSetReading() throws ReadingException {
        Odometer odo = new Odometer(3);
        
        // Valid reading
        odo.setReading(124);
        assertEquals(124, odo.getReading());
        
        // Non-ascending digits
        try {
            odo.setReading(122);
            fail("Expected NonAscendingReadingException");
        } catch (NonAscendingReadingException e) {
            // Expected exception
        }
        
        // Mismatched size
        try {
            odo.setReading(1234);
            fail("Expected ReadingSizeMismatchException");
        } catch (ReadingSizeMismatchException e) {
            // Expected exception
        }
    }

    @Test
    public void testIncrementReading() {
        Odometer odo = new Odometer(3);
        odo.incrementReading();
        assertEquals(124, odo.getReading());
    }

    @Test
    public void testDecrementReading() {
        Odometer odo = new Odometer(3);
        odo.decrementReading();
        assertEquals(789, odo.getReading());
    }

    @Test
    public void testNextReading() {
        Odometer odo = new Odometer(3);
        Odometer nextOdo = odo.nextReading();
        assertEquals(124, nextOdo.getReading());
    }

    @Test
    public void testReset() {
        Odometer odo = new Odometer(3);
        odo.incrementReading();
        odo.reset();
        assertEquals(123, odo.getReading());
    }

    @Test
    public void testGetSizeMethod() {
        Odometer odo = new Odometer(3);
        assertEquals(3, odo.getSize());
        odo.incrementReading();
        assertEquals(3, odo.getSize());
    }
    
    @Test
    public void testIsAscending() {
        assertTrue(Odometer.isAscending(123));
        assertFalse(Odometer.isAscending(122));
        assertTrue(Odometer.isAscending(789));
        assertFalse(Odometer.isAscending(987));
    }
}
