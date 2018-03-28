package com.cts;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.cts.data.Teacher;

public class TeacherClient
{
    private DynamoDBMapper mapper;
    private Regions REGION = Regions.US_WEST_2;

    public TeacherClient init()
    {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient();
        client.setRegion(Region.getRegion(REGION));
        mapper = new DynamoDBMapper(client);

        return this;
    }

    public void save(Teacher teacher)
    {
        mapper.save(teacher);
    }

    public Teacher load(String Id)
    {
        return mapper.load(Teacher.class, Id);
    }

    public void delete(String Id)
    {
        Teacher toDelete = new Teacher();
        toDelete.setId(Id);
        mapper.delete(toDelete);
    }

}
