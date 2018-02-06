package com.tefal.Models;

/**
 * Created by Rituparna Khadka on 12/27/2017.
 */

public class ProductCountryRecordModel
{

    private String id;

    private String name;

    private String image;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", name = "+name+", image = "+image+"]";
    }
}
