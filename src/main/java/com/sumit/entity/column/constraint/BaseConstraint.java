package com.sumit.entity.column.constraint;

import com.sumit.entity.data.BaseData;
import com.sumit.exception.ConstraintException;

/**
 * Created by sumit on 29/10/20.
 */
public interface BaseConstraint {
    boolean validate(BaseData data) throws ConstraintException;
    ConstraintType getType();
}
