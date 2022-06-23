package service;

import logic.JavaSort;
import logic.Sort;

import java.io.*;
import java.util.*;
import java.util.Map.*;

public class SortService<T extends Comparable<T>> {

    private final Sort<T> sort;

    // Dependency Injection
    public SortService(Sort<T> sort) {

        this.sort = sort;
    }

    public List<T> doSort(List<T> data) {

        return sort.sort(data);
    }
}
