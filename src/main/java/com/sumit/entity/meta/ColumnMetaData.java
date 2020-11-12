package com.sumit.entity.meta;

/**
 * Created by sumit on 29/10/20.
 */
public class ColumnMetaData implements BaseMetaData {
    private String name;

    public ColumnMetaData(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
