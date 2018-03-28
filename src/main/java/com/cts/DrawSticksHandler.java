package com.cts;

import com.cts.data.Teacher;
import com.cts.sheets.SimpleSheetsClient;
import com.cts.sheets.data.Table;

// This is the Lambda
public class DrawSticksHandler
{
    private TeacherService service = new TeacherService();
    private SimpleSheetsClient sheetsClient = new SimpleSheetsClient();

    public Teacher findTeacher(String id)
    {
        return service.findTeacher(id);
    }

    public Teacher refreshTeacher(String id)
    {
        // TODO: Retrieve the spreadsheet and update the classes and student lists

        // TODO: Get sheets id from teacher

        Table teacherClassDataTable = sheetsClient.getSpreadsheet("15esEPiQ0jmjy5i0nduPXyfKYo1KsMzrhLy-O8mGynDg");
        Teacher teacher = TableParser.toTeacher(teacherClassDataTable);

        service.update(teacher);

        return service.findTeacher(id);
    }
}
