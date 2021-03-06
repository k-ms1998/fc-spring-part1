package service;

import app.service.SortService;
import app.logic.JavaSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SortServiceTest {

    private final SortService service = new SortService(new JavaSort());

    @Test
    void test() {
        //Given
        List<String> data = List.of("C", "A", "D", "B", "E");

        //When
        List result = service.doSort(data);

        //Then
        Assertions.assertEquals(Arrays.asList("A", "B", "C", "D", "E"), result);
    }
}