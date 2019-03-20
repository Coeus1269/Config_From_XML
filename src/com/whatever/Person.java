package com.whatever;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Person
    {
    private String name;
    private Integer age;
    private boolean isMarried =false;
    private List<String> hobbies;
    private List<Person> kids;

    public Person()
        {

        }

public Person(String name, int age, boolean isMarried, List<String> hobbies, List<Person> kids)
    {
    this.name = name;
    this.age = age;
    this.isMarried = isMarried;
    this.hobbies = hobbies;
    this.kids = kids;
    }

public Person(String name, int age)
    { this(name, age, false, null, null); }


public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public int getAge() {
return age;
}

public void setAge(int age) {
this.age = age;
}

public boolean isMarried() {
return isMarried;
}

@XmlElement(name = "isMarried")
public void setMarried(boolean married) {
isMarried = married;
}

@XmlElementWrapper(name = "hobbies")
@XmlElement(name = "element")
public List<String> getHobbies() {
return hobbies;
}

public void setHobbies(List<String> hobbies) {
this.hobbies = hobbies;
}

public List<Person> getKids() {
return kids;
}

@XmlElementWrapper(name = "kids")
@XmlElement(name = "person")
public void setKids(List<Person> kids) {
this.kids = kids;
}

@Override
public String toString() {
return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", isMarried=" + isMarried +
        ", hobbies=" + hobbies +
        ", kids=" + kids +
        '}';
}
}
