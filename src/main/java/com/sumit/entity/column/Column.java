package com.sumit.entity.column;

import com.sumit.entity.column.constraint.BaseConstraint;
import com.sumit.entity.data.BaseData;
import com.sumit.entity.data.DataType;
import com.sumit.entity.meta.BaseMetaData;
import com.sumit.exception.ConstraintException;

import java.util.List;

/**
 * Created by sumit on 29/10/20.
 */
public class Column implements BaseColumn {
    private BaseMetaData metaData;
    private DataType dataType;
    private List<BaseConstraint> constraints;

    public Column(BaseMetaData metaData, DataType type, List<BaseConstraint> constraints)  {
        this.metaData = metaData;
        this.dataType = type;
        this.constraints = constraints;

    }

    @Override
    public String getColumnName() {
        return this.metaData.getName();
    }

    public boolean applyConstraints(BaseData data) throws ConstraintException {
        if (data.getDataType() != this.dataType) {
            return false;
        }

        for (BaseConstraint constraint : this.constraints) {
            if (!constraint.validate(data)) {
                return false;
            }
        }
        return true;
    }
}
