package com.cts.sheets.data;

import java.util.List;

public class Table
{
    private List<Header> cols;
    private List<Column> rows;

    public List<Column> getRows()
    {
        return rows;
    }

    public void setRows(List<Column> rows)
    {
        this.rows = rows;
    }

    public List<Header> getCols()
    {
        return cols;
    }

    public void setCols(List<Header> cols)
    {
        this.cols = cols;
    }
}
