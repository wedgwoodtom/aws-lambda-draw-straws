package com.cts;

import java.util.ArrayList;
import java.util.List;

public class FindStudentsResponse
{
    private List<String> students = new ArrayList<>();

    public FindStudentsResponse()
    {
    }

    public FindStudentsResponse(List<String> students)
    {
        this.students = students;
    }

    public List<String> getStudents()
    {
        return students;
    }

    public void setStudents(List<String> students)
    {
        this.students = students;
    }
}
