package com.cts.sheets.data;

public class Data
{
    private Object v;
    private String f;

    public Object getV()
    {
        return v;
    }

    public void setV(Object v)
    {
        this.v = v;
    }

    public String getF()
    {
        return f;
    }

    public void setF(String f)
    {
        this.f = f;
    }

    public String getValue()
    {
        if (getF() != null && !getF().isEmpty())
        {
            return getF();
        }

        return ""+getV().toString();
    }
}
