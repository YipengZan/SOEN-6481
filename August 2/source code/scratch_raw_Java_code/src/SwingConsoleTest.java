import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwingConsoleTest {

    @Test
    void run() {
        RegularCalculator test = new RegularCalculator();
        SwingConsole.run(test, 250, 300);
    }
}