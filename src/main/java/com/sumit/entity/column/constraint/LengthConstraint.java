package com.sumit.entity.column.constraint;

import com.sumit.entity.data.BaseData;
import com.sumit.entity.data.DataType;
import com.sumit.exception.IllegalContraintException;

/**
 * Created by sumit on 29/10/20.
 */
public class LengthConstraint implements BaseConstraint {
    private static final ConstraintType type = ConstraintType.LENGTH;

    private int length;

    public LengthConstraint(int length) {
        this.length = length;
    }


    public ConstraintType getType() {
        return type;
    }

    public boolean validate(BaseData data) throws IllegalContraintException {
        DataType dataType = data.getDataType();
        if (dataType == DataType.STRING) {
            String value = (String) data.getValue();
            return (value != null)  && value.length() <= this.length;
        } else {
            throw new IllegalContraintException("Length constraint can only be applied to String dataType.");
        }
    }
}
