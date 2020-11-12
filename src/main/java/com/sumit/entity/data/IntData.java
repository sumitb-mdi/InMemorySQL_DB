package com.sumit.entity.data;

/**
 * Created by sumit on 29/10/20.
 */
public class IntData implements BaseData {
    private Integer value;

    public IntData(Integer value) {
        this.value = value;
    }

    public void storeValue(Object value) {
        this.value = (Integer) value;
    }

    public void printData() {
        System.out.print(value);
    }

    public DataType getDataType() {
        return DataType.INT;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean matchValue(Object value) {
        Integer other = (Integer) value;
        return value.equals(other);   // TODO : NPE handling
    }
}
