package logic;

import java.io.*;
import java.util.*;
import java.util.Map.*;

public class BubbleSort<T extends Comparable<T>> implements Sort<T>{

    @Override
    public List<T> sort(List<T> data) {
        List<T> output = new ArrayList<>(data);

        int size = output.size();
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                //오름차순 정렬
                if (output.get(j).compareTo(output.get(j + 1)) > 0) {
                    T temp = output.get(j);
                    output.set(j, output.get(j + 1));
                    output.set(j + 1, temp);
                }
            }
        }

        return output;
    }


}
