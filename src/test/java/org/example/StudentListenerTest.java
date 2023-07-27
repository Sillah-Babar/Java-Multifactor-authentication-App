package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentListenerTest {
    StudentListener st;

    @Test
    public void isRegisteredTest()
    {
        st=new StudentListener();
        String value=st.updateRegistrationStatus(true);
        assertEquals(value,"Student has been registered.\n");
        value=st.updateRegistrationStatus(false);
        assertEquals(value,"Student registration has been canceled.\n");
    }

}