package com.sumit.entity.database;

import com.sumit.entity.table.Table;
import com.sumit.exception.DuplicateResourceException;
import com.sumit.exception.ResourceNotFoundException;

/**
 * Created by sumit on 29/10/20.
 */
public interface BaseDatabase {
    String createTable(Table table) throws DuplicateResourceException;
    String deleteTable(String tableName) throws ResourceNotFoundException;
    Table getTable(String tableName) throws ResourceNotFoundException;
}
