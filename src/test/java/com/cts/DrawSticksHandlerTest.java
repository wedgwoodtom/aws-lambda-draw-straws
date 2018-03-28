package com.cts;

import com.cts.sheets.SimpleSheetsClient;
import org.junit.Test;

public class DrawSticksHandlerTest
{
    @Test
    public void testGetSpreadSheet()
    {
        DrawSticksHandler drawSticksHandler = new DrawSticksHandler();
        drawSticksHandler.refreshTeacher("someId");

    }
}
