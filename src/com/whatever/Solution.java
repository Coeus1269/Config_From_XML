package com.whatever;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Solution
    {
    public static void main(String[] args) throws Exception
        {
        Person person = XMLtoPersonExample("person.xml");
        System.out.println(person);
        personToXMLExample("person-output.xml", person);
        }

    private static Person XMLtoPersonExample(String filename) throws Exception
        {
        File file = new File(filename);
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Person) jaxbUnmarshaller.unmarshal(file);
        }

    private static void personToXMLExample(String filename, Person person) throws Exception
        {
        File file = new File(filename);
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(person, file);
        jaxbMarshaller.marshal(person, System.out);
        }
}
