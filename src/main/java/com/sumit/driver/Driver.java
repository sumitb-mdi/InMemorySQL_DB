package com.sumit.driver;

import com.sumit.entity.column.Column;
import com.sumit.entity.column.constraint.*;
import com.sumit.entity.data.BaseData;
import com.sumit.entity.data.DataType;
import com.sumit.entity.data.IntData;
import com.sumit.entity.data.StringData;
import com.sumit.entity.database.Database;
import com.sumit.entity.meta.BaseMetaData;
import com.sumit.entity.meta.ColumnMetaData;
import com.sumit.entity.meta.TableMetaData;
import com.sumit.entity.table.Table;
import com.sumit.entity.table.TableRecord;
import com.sumit.exception.ConstraintException;
import com.sumit.exception.DuplicateResourceException;
import com.sumit.exception.ResourceNotFoundException;

import java.util.*;

/**
 * Created by sumit on 29/10/20.
 */
public class Driver {
    public static void main(String[] args) {

        Database db = createDatabase("emp_db");  // we can create in any order.

        Table t = createSampleEmployeeTable();
        try {
            db.createTable(t);
        } catch (DuplicateResourceException e) {
            e.printStackTrace();
        }

        try {
            Table table = db.getTable("employee");
            table.insertRecord(createSampleTableRecord("123", "bob", 42));
            table.insertRecord(createSampleTableRecord("345", "mike", 34));
            table.insertRecord(createSampleTableRecord("123", "john", 45));

            table.printRecords();

        } catch (ResourceNotFoundException e) {
            System.out.println("Table not found.");
        } catch (ConstraintException e) {
            System.out.println("Constraint exception.");
        }


    }


    private static Table createSampleEmployeeTable() {
        BaseConstraint requiredConstraint = createRequiredConstraint();
        BaseConstraint limitConstraint = createLimitConstraint(0, 100);
        BaseConstraint lengthConstraint = createLengthConstraint(20);

        Column idColumn = createColumn("id", DataType.STRING, Arrays.asList(requiredConstraint));
        Column nameColumn = createColumn("name", DataType.STRING, Arrays.asList(lengthConstraint));
        Column ageColumn = createColumn("age", DataType.INT, Arrays.asList(limitConstraint));


        List<Column> columns = new ArrayList<>();
        columns.add(idColumn);
        columns.add(nameColumn);
        columns.add(ageColumn);

        Table table = createTable("employee", columns);


        return table;
    }

    private static TableRecord createSampleTableRecord (String id, String name, int age) {
        Map<String, BaseData> row = new HashMap<>();
        row.put("id", new StringData(id));
        row.put("name", new StringData(name));
        row.put("age", new IntData(age));

        return new TableRecord(row);
    }



    private static Database createDatabase(String name) {
        return new Database();
    }

    private static Table createTable(String name, List<Column> columns) {
        BaseMetaData metaData = createTableMetaData(name);
        Map<String, Column> columnMap = new HashMap<>();
        for (Column column : columns) {
            columnMap.put(column.getColumnName(), column);
        }
        return new Table(metaData, columnMap);
    }



    private static Column createColumn(String name, DataType type, List<BaseConstraint> constraints) {
        BaseMetaData metaData = createColumnMetaData(name);
        return new Column(metaData, type, constraints);
    }

    private static BaseMetaData createColumnMetaData (String name) {
        return new ColumnMetaData(name);
    }

    private static BaseMetaData createTableMetaData (String name) {
        return new TableMetaData(name);
    }

    private static BaseConstraint createRequiredConstraint () {
        return new RequiredConstraint();
    }

    private static BaseConstraint createLimitConstraint (int lower, int upper) {
        return new LimitConstraint(lower, upper);
    }

    private static BaseConstraint createLengthConstraint (int length) {
        return new LengthConstraint(length);
    }
}
