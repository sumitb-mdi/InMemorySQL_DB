package com.sumit.entity.table;

import com.sumit.exception.ConstraintException;

/**
 * Created by sumit on 29/10/20.
 */
public interface BaseTable {
    String getTableName();
    void insertRecord(TableRecord tableRecord) throws ConstraintException;
    void printRecords();
}
