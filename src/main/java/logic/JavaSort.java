package logic;

import java.io.*;
import java.util.*;
import java.util.Map.*;

public class JavaSort<T extends Comparable<T>> {

    public List<T> sort(List<T> data) {
        List<T> output = new ArrayList<>(data);

        Collections.sort(output);

        return output;
    }
}
