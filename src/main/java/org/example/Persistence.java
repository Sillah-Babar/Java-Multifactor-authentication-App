package org.example;

import java.io.*;
import java.util.ArrayList;

public class Persistence {

    public ArrayList<StudentListener> readFromFile() throws IOException {
        ArrayList<StudentListener> result = new ArrayList<StudentListener>();
        File file=new File("Students.txt");    //creates a new file instance
        FileReader fr=new FileReader(file);   //reads the file
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
        StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
        String line;
        while((line=br.readLine())!=null)
        {
            String[] split_line=line.split(",");
            Student student=new Student(split_line[0],split_line[1],split_line[2],split_line[3],split_line[4],split_line[5],Integer.parseInt(split_line[6]),split_line[7],split_line[8]);
            StudentListener st_ls=new StudentListener(student);
            result.add(st_ls);
            sb.append(line);
            sb.append("\n");     //line feed
        }
        fr.close();    //closes the stream and release the resources
        System.out.println("Contents of File: ");
        System.out.println(sb.toString());   //returns a string that textually represents the object

        return result;
    }
    public void saveToFile(ArrayList<StudentListener> students) throws IOException {
        File file = new File("Students.txt");
        FileWriter filewriter = null;

        filewriter = new FileWriter(file);
        for (int i = 0; i < students.size(); i++) {

            String val = students.get(i).getSt().convertToString();
            filewriter.write(val);
        }
        filewriter.close();
        System.out.println("File writing done.");
    }


    }
