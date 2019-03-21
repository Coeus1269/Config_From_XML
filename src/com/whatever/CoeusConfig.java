package com.whatever;


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
//    private List<String>   ListOfStuff;

    // Class to load config settings from an XML file
    // This class will create the XML file when first ran if it doesn't already exist.
    // TODO: get instance for static class single instance usage
    // TODO: Clone this before save


    // if you add variables to this class, for variable matching between this class and the XML file
    // you can either have the same name in the XML as this class, case sensitive
    // or add the following annotation to link mismatched spellings
    @XmlElement(name = "isDeBug")
    public void setDeBug_bln(boolean deBug_bln)
        { this.deBug_bln = deBug_bln;      }

    public boolean isDeBug_bln()
        { return deBug_bln;        }

//    @XmlElementWrapper(name = "ListOfStuff")    // name of the grouping element
//    @XmlElement(name = "element")               // don't need to change, this basically says for each element...
//    public List<String> getListOfStuff() {
//    return ListOfStuff;
//    }


    public String getDbServerConn()
        { return dbServerConn_str;      }

    public void setDbServerConn(String dbServerConn)
        { this.dbServerConn_str = dbServerConn;        }

    public static void main(String[] args)
        {
        // SaveConfig2XML();
        LoadData();
    }

    private static CoeusConfig LoadData()
        {
        File file = new File(ConfigFile_str);
        JAXBContext jaxbContext = null;
        if( !file.exists())
            {
            SaveConfig2XML();
            }

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

    private static void SaveConfig2XML()
        {
        try
            {
            CoeusConfig ConfigTemp = new CoeusConfig();
            SaveConfig2XML(ConfigTemp);
            }
        catch (Exception e)
            {
            e.printStackTrace();
            }
        }


    private static void SaveConfig2XML(CoeusConfig CFG_Temp)
        {
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

//    @Override
//    public String ToString();
//        {
//        jaxbMarshaller.marshal(CFG_Temp, System.out);
//        }
    }
