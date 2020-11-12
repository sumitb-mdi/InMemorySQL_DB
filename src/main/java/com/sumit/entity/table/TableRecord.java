package com.sumit.entity.table;

import com.sumit.entity.data.BaseData;

import java.util.Map;


/**
 * Created by sumit on 29/10/20.
 */
public class TableRecord {
    private Map<String, BaseData> row;

    public TableRecord(Map<String, BaseData> row) {
        this.row = row;
    }

    public Map<String, BaseData> getRow() {
        return row;
    }

    public void setRow(Map<String, BaseData> row) {
        this.row = row;
    }
}
