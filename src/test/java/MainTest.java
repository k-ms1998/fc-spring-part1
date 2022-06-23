import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        //Given
        String[] data = {"C", "A", "D", "B", "E"};

        //When & Then
        Main.main(data);

    }
}