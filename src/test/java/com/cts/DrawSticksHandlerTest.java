package com.cts;

import com.cts.data.Teacher;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class DrawSticksHandlerTest
{
    @Test
    public void testFindTeacher()
    {
        DrawSticksHandler drawSticksHandler = new DrawSticksHandler();
        Teacher teacher = drawSticksHandler.findTeacher("ww.tom@gmail.com");
        Assert.assertNotNull(teacher);
    }

    @Test
    public void testFindCurrentStudents()
    {
        DrawSticksHandler drawSticksHandler = new DrawSticksHandler();
        FindCurrentStudentsRequest request = new FindCurrentStudentsRequest();
        request.setCurrentTime(new Date());
        request.setTeacherId("ww.tom@gmail.com");
        List<String> students = drawSticksHandler.findCurrentStudents(request).getStudents();
        Assert.assertNotNull(students);
        Assert.assertTrue(students.size()>0);
    }

    @Test
    public void testFindCurrentStudentsWhenNoStudents()
    {
        DrawSticksHandler drawSticksHandler = new DrawSticksHandler();
        FindCurrentStudentsRequest request = new FindCurrentStudentsRequest();
        request.setCurrentTime(new Date());
        request.setTeacherId("BAD_ID");
        List<String> students = drawSticksHandler.findCurrentStudents(request).getStudents();
        Assert.assertTrue(students.isEmpty());
    }
}
