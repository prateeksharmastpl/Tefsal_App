package com.tefal.Models;

import java.util.ArrayList;

/**
 * Created by Rituparna Khadka on 1/31/2018.
 */

public class GetAssignedItemsResponse
{
    private String message;

    private ArrayList<GetAssignedItemsRecord> record;

    private String status;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public ArrayList<GetAssignedItemsRecord> getRecord ()
    {
        return record;
    }

    public void setRecord (ArrayList<GetAssignedItemsRecord> record)
    {
        this.record = record;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", record = "+record+", status = "+status+"]";
    }
}
