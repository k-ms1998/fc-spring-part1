package app.service;

import app.logic.Sort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SortService<T extends Comparable<T>> {

    private final Sort<T> sort;

    // Dependency Injection
    public SortService(@Qualifier("javaSort") Sort<T> sort) {
        //@Qualifier 로 Sort에 주입 가능한 빈(javaSort, bubbleSort) 중에서 어떤것을 주입할지 정해줌
        this.sort = sort;
    }

    public List<T> doSort(List<T> data) {

        return sort.sort(data);
    }
}
