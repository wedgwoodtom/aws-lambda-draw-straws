package com.cts;

import com.cts.data.Teacher;

public class TeacherService
{
    private TeacherClient teacherClient = new TeacherClient().init();

    public Teacher findTeacher(String id)
    {
        Teacher teacher = teacherClient.load(id);
        return teacher;
    }

    public void update(Teacher teacher)
    {
        teacherClient.save(teacher);
    }

    public void delete(String id)
    {
        teacherClient.delete(id);
    }
}
