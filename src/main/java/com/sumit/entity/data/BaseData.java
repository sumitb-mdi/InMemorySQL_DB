package com.sumit.entity.data;

/**
 * Created by sumit on 29/10/20.
 */
public interface BaseData {
    DataType getDataType();
    void printData();
    void storeValue(Object value);
    boolean matchValue(Object value);
    Object getValue();
}
