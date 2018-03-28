package com.cts.sheets.data;

import com.cts.sheets.data.Table;

public class Response
{
    private String status;
    private Table table;

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Table getTable()
    {
        return table;
    }

    public void setTable(Table table)
    {
        this.table = table;
    }
}
