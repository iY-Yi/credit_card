package creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        String[] args = {"input2.csv", "output.csv"};
        Main.main(args);
    }
}