package app.logic;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JavaSort<T extends Comparable<T>> implements Sort<T>{

    @Override
    public List<T> sort(List<T> data) {
        List<T> output = new ArrayList<>(data);

        Collections.sort(output);

        return output;
    }
}
