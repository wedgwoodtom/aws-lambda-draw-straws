package com.cts;

import com.cts.data.Teacher;
import com.cts.sheets.SimpleSheetsClient;
import com.cts.client.TeacherService;
import com.cts.sheets.data.Table;

// This is the Lambda - com.cts.DrawSticksHandler::findTeacher
public class DrawSticksHandler
{
    private TeacherService service = new TeacherService();
    private SimpleSheetsClient sheetsClient = new SimpleSheetsClient();

    public Teacher findTeacher(String id)
    {
        // TODO: Decide how to use the id, for now, just use email
//        return service.findTeacher(id);

        // TODO: For now, always update
        return refreshTeacher(id);
    }

    public Teacher refreshTeacher(String id)
    {
        // TODO: Retrieve the spreadsheet and update the classes and student lists

        // TODO: Get sheets id from teacher
        System.out.println("refreshTeacher with id=" + id);

        Table teacherClassDataTable = sheetsClient.getSpreadsheet("15esEPiQ0jmjy5i0nduPXyfKYo1KsMzrhLy-O8mGynDg");
        Teacher teacher = TableParser.toTeacher(teacherClassDataTable);

        service.update(teacher);

        return service.findTeacher(id);
    }
}
