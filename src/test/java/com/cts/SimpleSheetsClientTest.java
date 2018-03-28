package com.cts;

import com.cts.data.Teacher;
import com.cts.sheets.SimpleSheetsClient;
import com.cts.sheets.data.Table;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;


public class SimpleSheetsClientTest
{
    @Test
    public void testGetSpreadSheet() throws Exception
    {
        SimpleSheetsClient simpleSheetsClient = new SimpleSheetsClient();
        Table tableData = simpleSheetsClient.getSpreadsheet("15esEPiQ0jmjy5i0nduPXyfKYo1KsMzrhLy-O8mGynDg");
        Teacher teacher = TableParser.toTeacher(tableData);
        Assert.assertEquals(teacher.getId(), "ww.tom@gmail.com");
        // TODO: Check other fields


        Gson gson = new Gson();
        System.out.println("teacher=" + gson.toJson(teacher));
    }
}
