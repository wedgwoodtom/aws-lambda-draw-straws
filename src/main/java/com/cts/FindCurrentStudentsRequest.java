package com.cts;

import java.util.Date;

public class FindCurrentStudentsRequest
{
    private String teacherId;
    private Date currentTime;

    public String getTeacherId()
    {
        return teacherId;
    }

    public void setTeacherId(String teacherId)
    {
        this.teacherId = teacherId;
    }

    public Date getCurrentTime()
    {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime)
    {
        this.currentTime = currentTime;
    }
}
