package com.sumit.entity.column.constraint;

import com.sumit.entity.data.BaseData;
import com.sumit.entity.data.DataType;
import com.sumit.exception.IllegalContraintException;

/**
 * Created by sumit on 29/10/20.
 */
public class LimitConstraint implements BaseConstraint {
    private static final ConstraintType type = ConstraintType.LIMIT;

    private Integer lowerLimit;
    private Integer upperLimit;

    public LimitConstraint(Integer lowerLimit, Integer upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public ConstraintType getType() {
        return type;
    }


    public boolean validate(BaseData data) throws IllegalContraintException {
        DataType dataType = data.getDataType();
        Integer value = (Integer) data.getValue();
        if (dataType == DataType.INT) {
            return this.lowerLimit <= value && value <= this.upperLimit;
        } else {
            throw new IllegalContraintException("Limit constraint can be applied only to Integer DateType.");
        }
    }
}
