package logic;

import app.logic.JavaSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class JavaSortTest {
    
    @DisplayName("자바소트")
    @Test
    void sort() {
        //Given
        JavaSort<Integer> javaSort = new JavaSort<>();

        //When
        List<Integer> result = javaSort.sort(List.of(3, 1, 5, 2, 4));

        //Then
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5), result);

    }

}