package com.cts;

import com.amazonaws.services.lambda.runtime.Context;
import com.cts.data.*;
import com.cts.data.Class;
import com.cts.sheets.SimpleSheetsClient;
import com.cts.client.TeacherService;
import com.cts.sheets.data.Table;

import java.util.*;

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

    public List<String> findCurrentStudents(FindCurrentStudentsRequest request)
    {
        System.out.println("findCurrentStudents with id:"+request.getTeacherId()+", time:"+request.getCurrentTime());
        Teacher teacher = refreshTeacher(request.getTeacherId());
        if (teacher == null)
        {
            return Collections.EMPTY_LIST;
        }

        for (Class scheduled : teacher.getClassList())
        {
            Calendar now = dateToCalendar(request.getCurrentTime());
//            Calendar now = dateToCalendar(new Date(Long.parseLong(request.getCurrentTime())));
            Calendar start = adjustedDateToCalendar(scheduled.getStart());
            Calendar end = adjustedDateToCalendar(scheduled.getEnd());
            System.out.println("Comparing now:"+now.getTimeInMillis()+ ", start:"+start.getTimeInMillis() +", end:"+end.getTimeInMillis());
            if (start.getTimeInMillis() <= now.getTimeInMillis() && now.getTimeInMillis() <= end.getTimeInMillis())
            {
                return scheduled.getStudents();
            }
        }

        return Collections.EMPTY_LIST;
    }

    private Calendar adjustedDateToCalendar(Date date)
    {
        // TODO: Fix timezone bug!
        Calendar adjusted = Calendar.getInstance(TimeZone.getTimeZone("US/Pacific"));
//        System.out.println(date.getHours());
//        System.out.println(date.getMinutes());

        adjusted.set(Calendar.HOUR_OF_DAY, 0);
        adjusted.set(Calendar.MINUTE, 0);
        adjusted.add(Calendar.HOUR_OF_DAY, date.getHours());
        adjusted.add(Calendar.MINUTE, date.getMinutes());

        return adjusted;
    }

    private Calendar dateToCalendar(Date date)
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTime(date);
        return calendar;
    }

}
