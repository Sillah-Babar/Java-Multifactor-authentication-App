package org.example;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class PersistenceTest {

    Persistence pr;
    public PersistenceTest()
    {
        pr=new Persistence();
    }

    @Test
    public void readFromFile() throws IOException {
        ArrayList<StudentListener> str = new ArrayList<StudentListener>();
        Student sin=new Student("emma","wilson","emmawilson@ufb.com","Emma22!","456 Oak Avenue","+1 555-234-5678",8,"94320843095","94320843095.png");

        StudentListener st=new StudentListener(sin);
        str.add(st);

        pr.saveToFile(str);

        str= pr.readFromFile();
        assertEquals(str.get(str.size()-1).getSt().getFirstName(),"emma");
        assertEquals(str.get(str.size()-1).getSt().getLastName(),"wilson");
        assertEquals(str.get(str.size()-1).getSt().getPassword().getEmail(),"emmawilson@ufb.com");
        assertEquals(str.get(str.size()-1).getSt().getPassword().getPassword(),"Emma22!");

    }

    @Test
    public void saveToFile() throws IOException {
        ArrayList<StudentListener> str = new ArrayList<StudentListener>();
        Student sin=new Student("oliver","thompson","oliverthompson@ufb.com","Oliver23!","456 Oak Avenue","+1 555-234-5678",3,"94320843095","94320843095.png");

        StudentListener st=new StudentListener(sin);
        str.add(st);

        pr.saveToFile(str);
        str=pr.readFromFile();
        assertEquals(str.get(str.size()-1).getSt().convertToString(),st.getSt().convertToString());
    }
}