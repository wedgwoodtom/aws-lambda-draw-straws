package com.cts;

import com.cts.data.Class;
import com.cts.data.Teacher;
import com.cts.client.TeacherService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TeacherServiceIntegrationTest
{
    private static TeacherService teacherService;

    @BeforeClass
    public static void setup()
    {
        teacherService = new TeacherService();
    }

    @Test
    public void test01Save()
    {
        Teacher teacher = new Teacher();
        teacher.setId("teacher1");

        Class class1 = new Class();
        class1.setStart(new Date());
        class1.setEnd(new Date());

        List<String> students = new ArrayList<>();
        students.add("Bill K");
        students.add("Sally P");
        class1.setStudents(students);

        teacher.setClassList(Collections.singletonList(class1));

        teacherService.update(teacher);
    }

    @Test
    public void test02Read()
    {
        Teacher teacher = new Teacher();
        teacher.setId("teacher1");

        Teacher fromDb = teacherService.findTeacher(teacher.getId());
        Assert.assertNotNull(fromDb);
        Assert.assertEquals(fromDb.getClassList().size(), 1);
        Assert.assertEquals(fromDb.getClassList().get(0).getStudents().size(), 2);
    }

    @Test
    public void test03Delete() throws Exception
    {
        teacherService.delete("teacher1");

        Teacher fromDb = teacherService.findTeacher("teacher1");
        Assert.assertNull(fromDb);
    }

}
