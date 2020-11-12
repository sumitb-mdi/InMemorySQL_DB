package com.sumit.entity.table;

import com.sumit.entity.column.Column;
import com.sumit.entity.data.BaseData;
import com.sumit.entity.meta.BaseMetaData;
import com.sumit.exception.ConstraintException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sumit on 29/10/20.
 */
public class Table implements BaseTable {
    private BaseMetaData metaData;
    private Map<String, Column> columns;
    private List<TableRecord> records;

    public Table(BaseMetaData metaData, Map<String, Column> columns) {
        this.metaData = metaData;
        this.columns = columns;
        this.records = new ArrayList<>();
    }

    @Override
    public String getTableName() {
        return this.metaData.getName();
    }

    @Override
    public void insertRecord(TableRecord tableRecord) throws ConstraintException {
        Map<String, BaseData> rowData = tableRecord.getRow();
        for (Map.Entry<String,BaseData> entry : rowData.entrySet()) {
            Column column = this.columns.get(entry.getKey());
            if (column != null) {
                column.applyConstraints(entry.getValue());
            }
        }
        this.records.add(tableRecord);
    }



    @Override
    public void printRecords() {
        for (TableRecord tableRecord : this.records) {
            Map<String, BaseData> rowData = tableRecord.getRow();
            for (Map.Entry<String,BaseData> entry : rowData.entrySet()) {
                entry.getValue().printData();
                System.out.print("  ");
            }

            System.out.println();
        }
    }
}
