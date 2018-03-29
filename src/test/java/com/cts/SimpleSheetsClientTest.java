package com.cts;

import com.cts.data.Teacher;
import com.cts.sheets.SimpleSheetsClient;
import com.cts.sheets.data.Table;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


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

    @Test
    public void playWithParser() throws Exception
    {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date d = dateFormat.parse("09:55");
        System.out.println(d);

        System.out.println(d.getHours());
        System.out.println(d.getMinutes());

    }
}
