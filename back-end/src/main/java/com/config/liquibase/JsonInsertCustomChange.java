package com.config.liquibase;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import liquibase.change.ColumnConfig;
import liquibase.change.custom.CustomSqlChange;
import liquibase.database.Database;
import liquibase.exception.ValidationErrors;
import liquibase.resource.ResourceAccessor;
import liquibase.statement.DatabaseFunction;
import liquibase.statement.SqlStatement;
import liquibase.statement.core.InsertStatement;

public class JsonInsertCustomChange implements CustomSqlChange {

    private String file;
    private String tableName;
    private ResourceAccessor fileOpener;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public ResourceAccessor getFileOpener() {
        return fileOpener;
    }

    @Override
    public SqlStatement[] generateStatements(Database database) {
        try {
            JsonNode node = readFile();

            List<InsertStatement> inserts = new ArrayList<>();

            for (int i = 0; i < node.size(); i++) {
                JsonNode element = node.get(i);
                InsertStatement insertStatement = new InsertStatement("","", tableName);
                element.fieldNames().forEachRemaining(field -> {
                    String fieldValue = element.get(field).asText();
                    if (containsFunction(fieldValue)) {
                        DatabaseFunction function = new DatabaseFunction(fieldValue);
                        ColumnConfig columnConfig = new ColumnConfig();
                        columnConfig.setComputed(true);
                        columnConfig.setName(field);
                        columnConfig.setValueComputed(function);
                        insertStatement.addColumn(columnConfig);
                    } else {
                        insertStatement.addColumnValue(field, element.get(field).asText());
                    }
                });
                inserts.add(insertStatement);
            }

            return inserts.toArray(new InsertStatement[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean containsFunction(String field) {
        return field.contains("concat(")
                || field.contains("current_date(");
    }

    private JsonNode readFile() throws Exception {
        InputStream inputStream = fileOpener.getResourcesAsStream(file).stream()
                .findAny().orElseThrow(RuntimeException::new);
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        return new ObjectMapper().readTree(json);
    }

    @Override
    public String getConfirmationMessage() {
        return "Loaded data from " + file;
    }

    @Override
    public void setUp() {
    }

    @Override
    public void setFileOpener(ResourceAccessor resourceAccessor) {
        this.fileOpener = resourceAccessor;
    }

    @Override
    public ValidationErrors validate(Database database) {
        return null;
    }
}