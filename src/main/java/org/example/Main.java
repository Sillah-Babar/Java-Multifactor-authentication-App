package org.example;

import javax.swing.*;
import java.io.IOException;

public class Main extends JFrame{//inheriting JFrame

    public static void main(String[] args) throws IOException {

        Persistence pr=new Persistence();
        pr.readFromFile();
        App app=new App();
        app.Homepage();
        UFB uf=UFB.getInstance();
        pr.saveToFile(uf.getObservers());

    }}
