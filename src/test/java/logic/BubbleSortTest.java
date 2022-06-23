package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    
    @DisplayName("버블소트")
    @Test
    void sort() {
        //Given
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();

        //When
        List<Integer> result = bubbleSort.sort(List.of(3, 1, 5, 2, 4));

        //Then
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5), result);
        
    }

}