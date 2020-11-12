package com.sumit.entity.database;

import com.sumit.entity.table.Table;
import com.sumit.exception.DuplicateResourceException;
import com.sumit.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sumit on 29/10/20.
 */

public class Database implements BaseDatabase {
    private final Map<String, Table> tables;

    public Database() {
        this.tables = new HashMap<>();
    }

    @Override
    public String createTable(Table table) throws DuplicateResourceException {
        if (!this.tables.containsKey(table.getTableName())) {
            this.tables.put(table.getTableName(), table);
            return "Table created successfully!";
        } else {
            throw new DuplicateResourceException(String.format("Table with name %s already exists", table.getTableName()));
        }
    }

    @Override
    public String deleteTable(String tableName) throws ResourceNotFoundException {
        if (this.tables.containsKey(tableName)) {
            this.tables.remove(tableName);
            return "Table deleted successfully!";
        } else {
            throw new ResourceNotFoundException(String.format("Table with name %s is not found", tableName));
        }
    }

    @Override
    public Table getTable(String tableName) throws ResourceNotFoundException {
        if (this.tables.containsKey(tableName)) {
            return this.tables.get(tableName);
        } else {
            throw new ResourceNotFoundException(String.format("Table with name %s is not found", tableName));
        }
    }
}
