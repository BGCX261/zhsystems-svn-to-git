package com.ehs.common;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Properties;

public class PropertiesLoader 
{
    public static Properties getPropertiesFromFile(final String propertiesFile)
    throws IOException
    {
        java.util.Properties props = new java.util.Properties();
        InputStream url = PropertiesLoader.class.getClassLoader().getResourceAsStream(propertiesFile);
        System.err.println("PROPS: " + propertiesFile + " : " + url);
        if(url != null)
            props.load(url);
        else
            props.load(new FileReader(propertiesFile));
        return props;
    }
    public static Properties getPropertiesFromString(final String propertiesString)
    throws IOException
    {
        java.util.Properties props = new java.util.Properties();
        props.load(new StringReader(propertiesString));
        return props;
    }
}
