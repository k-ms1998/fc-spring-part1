package logic;

import java.io.*;
import java.util.*;
import java.util.Map.*;

public interface Sort<T extends Comparable<T>> {
    List<T> sort(List<T> data);
}
