package com.cts;

import com.cts.sheets.SimpleSheetsClient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SimpleSheetsClientTest
{

    @Test
    public void testGetSpreadSheet() throws Exception
    {
        SimpleSheetsClient simpleSheetsClient = new SimpleSheetsClient();
        simpleSheetsClient.getSpreadsheet("15esEPiQ0jmjy5i0nduPXyfKYo1KsMzrhLy-O8mGynDg");
    }
}
