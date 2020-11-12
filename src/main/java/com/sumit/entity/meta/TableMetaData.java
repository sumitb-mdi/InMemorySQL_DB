package com.sumit.entity.meta;

/**
 * Created by sumit on 29/10/20.
 */
public class TableMetaData implements BaseMetaData {
    private String name;

    public TableMetaData(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
