import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PIcalTest {

    @Test
    void jishuPI() {
        PIcal test = new PIcal();
        double r = test.jishuPI();
        assertEquals(3.141592653589792,r);
    }

    @Test
    void jishuPI1() {
        PIcal test = new PIcal();
        double r = test.jishuPI(1e-1);
        assertEquals(3.098412698412698,r);
    }


    @Test
    void jishuPI2() {
        PIcal test = new PIcal();
        double r = test.jishuPI(1e-5);
        assertEquals(3.1415863960370602,r);
    }

    @Test
    void circularCircumference() {
        PIcal test = new PIcal();
        double r = test.circularCircumference(3.141592653589792, 1);
        assertEquals(6.283185307179584,r);
    }

    @Test
    void circularCircumference1() {
        PIcal test = new PIcal();
        double r = test.circularCircumference(3.141592648659951, 10);
        assertEquals(62.83185297319902,r);
    }

    @Test
    void circularArea() {
        PIcal test = new PIcal();
        double r = test.circularArea(3.141592653589792, 3);
        assertEquals(29.60881320326805,r);
    }

    @Test
    void circularArea1() {
        PIcal test = new PIcal();
        double r = test.circularArea(3.1415379931734746, 8);
        assertEquals(78.95408770041938,r);
    }
}