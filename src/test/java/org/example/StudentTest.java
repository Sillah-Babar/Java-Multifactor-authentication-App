package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    Student st;
    public  StudentTest()
    {
        st=new Student("emma","wilson","emmawilson@ufb.com","Emma22!","456 Oak Avenue","+1 555-234-5678",8,"94320843095","94320843095.png");
    }

    @Test
    public void convertToString() {
        String value=st.convertToString();
        System.out.println(value);

        assertEquals("emma,wilson,emmawilson@ufb.com,Emma22!,456 Oak Avenue,+1 555-234-5678,8,94320843095,94320843095.png".equals(value),false);
    }

    @Test
    public void setFirstName() {
        st.setFirstName("Harris");
        assertEquals("Harris",st.getFirstName());
    }

    @Test
    public void setLastName() {
        st.setLastName("Raees");
        assertEquals("Raees",st.getLastName());
    }

    @Test
    public void setAddress() {
        st.setAddress("dasd");
        assertEquals(st.getAddress(),"dasd");
    }

    @Test
    public void setNumber() {
        st.setNumber("39842o03984");
        assertEquals(st.getNumber(),"39842o03984");
    }

    @Test
    public void setNumCourses() {
        st.setNumCourses(2);
        assertEquals(st.getNumCourses(),2);
    }
}