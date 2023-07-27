package org.example;

import com.google.zxing.WriterException;

import java.io.IOException;

public interface universityInterface {
    public boolean registerSt(StudentListener observer) throws IOException, WriterException;
    void removeStudent(StudentListener  observer);
    void notifyStudents();
}