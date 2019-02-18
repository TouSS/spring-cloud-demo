package com.xx.demo.provider.bean;

import java.util.ArrayList;
import java.util.List;

public class IndexList {
    private final static List<Index> list = new ArrayList<>();

    synchronized public static final Index  add(Index index) {
        index.setId(list.size());
        list.add(index);
        return index;
    }

    synchronized public static final Index remove(int id) {
        if(list.isEmpty()) return null;
        return list.remove(id);
    }

    public static final Index get(int id) {
        if(list.isEmpty()) return null;
        return list.get(id);
    }

    public static final List<Index> all() {
        return list;
    }
}
