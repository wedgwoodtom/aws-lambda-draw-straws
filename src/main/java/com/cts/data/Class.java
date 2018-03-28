package com.cts.data;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@DynamoDBDocument
public class Class
{
    private String title;
    private Date start;
    private Date end;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    private List<String> students = new ArrayList<>();

    public Date getStart()
    {
        return start;
    }

    public void setStart(Date start)
    {
        this.start = start;
    }

    public Date getEnd()
    {
        return end;
    }

    public void setEnd(Date end)
    {
        this.end = end;
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
