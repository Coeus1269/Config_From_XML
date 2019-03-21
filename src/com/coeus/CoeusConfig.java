package com.coeus;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.File;
import java.util.List;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlRootElement
public class CoeusConfig
    {
    private boolean isLoaded_bln = false;
    private boolean deBug_bln = false;
    private String dbServerConn_str = "Some DB Conn String";
    private static String ConfigFile_str = "CoeusConfig.xml";
    private int someOtherIntValue = 0;
//    private List<String>   ListOfStuff;

    // Class to load config settings from an XML file, utilizing Static functionality as much as possible.
    // This class will create the XML file when first ran if it doesn't already exist.
    // TODO: Add exception logging
    // TODO: ToString output

    // if you add variables to this class, for variable matching between this class and the XML file
    // you can either have the same name in the XML as this class, case sensitive
    // or add the @XmlElement(name = "XML Value")  annotation to link mismatched spellings, Example below for isDeBug
    // initializing the variable with a default value makes sure it is saved in the XML even if it is never set.
    // some data types will not create an XML element if they are NULL.


    // Example of a LIST
//    @XmlElementWrapper(name = "ListOfStuff")    // name of the grouping element
//    @XmlElement(name = "element")               // don't need to change, this basically says for each element...
//    public List<String> getListOfStuff()
//      { return ListOfStuff; }


    public static void main(String[] args)
        {
        CheckFileExists(ConfigFile_str);
        // SaveConfig2XML();
        LoadDataFromXML();
//        System.out.println("ugh");
        }

    public static CoeusConfig LoadDataFromXML()
        {
        return LoadDataFromXML(CheckFileExists(ConfigFile_str));
        }

    private static CoeusConfig LoadDataFromXML(File file)
        {
        // This method does not load this instantiated class, but returns a loaded class
        // usage example:
        //     CoeusConfig yourClass = CoeusConfig.LoadDataFromXML();

        JAXBContext jaxbContext;
        try
            {
            jaxbContext = JAXBContext.newInstance(CoeusConfig.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (CoeusConfig) jaxbUnmarshaller.unmarshal(file);
            }
        catch (JAXBException e)
            {
            e.printStackTrace();
            }

        return null;
        }

    public static void SaveData2XML()
        {
        try
            {
            CoeusConfig ConfigTemp = new CoeusConfig();
            SaveData2XML(ConfigTemp);
            }
        catch (Exception e)
            {
            e.printStackTrace();
            }
        }


    public static void SaveData2XML(CoeusConfig CFG_Temp)
        {
        // save config settings to the XML
        // usage example:
        //   CoeusConfig.SaveData2XML(yourClass);
        try
            {
            // save or create an xml file
            File file = new File(ConfigFile_str);
            JAXBContext jaxbContext = JAXBContext.newInstance(CoeusConfig.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(CFG_Temp, file);
            jaxbMarshaller.marshal(CFG_Temp, System.out);
            }
        catch (JAXBException e)
            {
            e.printStackTrace();
            }
        }

    private static File CheckFileExists(String TempConfigFile_str)
        {
        // Check if the XML exists and creates one if not
        File file = new File(TempConfigFile_str);
        if( !file.exists())
            {
            SaveData2XML();
            }

        return file;
        }

    /* -------------------------------- Getters & Setters  -------------------------------- */

    public String getDbServerConn()
        { return dbServerConn_str; }

    public void setDbServerConn(String dbServerConn)
        { this.dbServerConn_str = dbServerConn; }

    @XmlElement(name = "isDeBug")
    public void setDeBug_bln(boolean deBug_bln)
        { this.deBug_bln = deBug_bln;}

    public boolean isDeBug_bln()
        { return deBug_bln; }

    @XmlElement(name = "SomeInt")
    public int getSomeOtherIntValue()
        { return someOtherIntValue;  }

    public void setSomeOtherIntValue(int someOtherIntValue)
        { this.someOtherIntValue = someOtherIntValue; }


    /* ------------------------------ End Getters & Setters  ------------------------------ */
    }
