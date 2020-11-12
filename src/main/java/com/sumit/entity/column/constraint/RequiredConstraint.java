package com.sumit.entity.column.constraint;

import com.sumit.entity.data.BaseData;

/**
 * Created by sumit on 29/10/20.
 */
public class RequiredConstraint implements BaseConstraint {
    private static final ConstraintType type = ConstraintType.REQUIRED;

    public ConstraintType getType() {
        return type;
    }

    public boolean validate(BaseData data) {
        Object value = data.getValue();
        return value != null;
    }
}
