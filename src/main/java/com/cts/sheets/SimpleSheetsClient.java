package com.cts.sheets;

import com.cts.sheets.data.Response;
import com.cts.sheets.data.Table;
import com.google.gson.Gson;

public class SimpleSheetsClient
{
    static final String SPREADSHEET_URL = "http://spreadsheets.google.com/tq?tq=select%20A%2CB%2CC%2CD";

    public Table getSpreadsheet(String sheetId)
    {
        try
        {
            String responseStr = org.apache.http.client.fluent.Request.Get(SPREADSHEET_URL + "&key=" + sheetId)
                    .execute()
                    .returnContent()
                    .asString();
            String marker = "setResponse(";
            if (responseStr.contains(marker)) {
                int i = responseStr.indexOf(marker);
                responseStr = responseStr.substring(i + marker.length(), responseStr.length() - 2);
            }

            Gson gson = new Gson();
            return gson.fromJson(responseStr, Response.class).getTable();
        }
        catch(Exception error)
        {
            throw new RuntimeException(error);
        }
    }
}
