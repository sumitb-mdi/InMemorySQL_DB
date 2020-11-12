package com.sumit.entity.data;

/**
 * Created by sumit on 29/10/20.
 */
public class StringData implements BaseData {
    private String value;

    public StringData(String value) {
        this.value = value;
    }

    public void storeValue(Object value) {
        this.value = (String) value;
    }

    public void printData() {
        System.out.print(value);
    }

    public DataType getDataType() {
        return DataType.STRING;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean matchValue(Object value) {
        String other = (String) value;
        return value.equals(other);   // TODO : NPE handling
    }
}
