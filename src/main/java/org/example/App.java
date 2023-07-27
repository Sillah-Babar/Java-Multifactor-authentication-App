package org.example;

import com.google.zxing.WriterException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class App implements ActionListener {
     static JFrame window;
     JLabel email;
     JLabel password;
     JLabel fname;
     JLabel lname;
     JTextField fname_text;
     JTextField lname_text;
     JLabel UniversityName;
     JTextField email_text;
     JTextField password_text;
     JButton login;
     JButton signup;
     JTextField OTP;
     JLabel qrcode;
     JLabel secretkey;
     JLabel secretkey_text;

     JTextField new_password_text;
     StudentListener st;

     JLabel new_password;
     JButton enter;
     JButton next;
     JLabel prompt;
    App(){

        next=new JButton("Next");
        next.setName("next");
        window=new JFrame();
        email=new JLabel("Email");
        prompt=new JLabel();
        qrcode=new JLabel();
        secretkey=new JLabel("Secret Key");
        secretkey_text=new JLabel();
        fname=new JLabel("First Name: ");
        lname=new JLabel("Last Name");
        fname_text=new JTextField();
        lname_text=new JTextField();
        UniversityName=new JLabel("University of Bradford");
        UniversityName.setFont(new Font("Serif", Font.BOLD, 28));
        password=new JLabel("Password");
        email_text=new JTextField(20);
        password_text=new JPasswordField(20);
        new_password_text=new JPasswordField(20);
        login=new JButton("Login");//creating instance of JButton
        login.setName("login");
        signup=new JButton("Sign up");//creating instance of JButton
        signup.setName("signup");
        new_password=new JLabel("Renter Password");

        enter=new JButton("enter");
        enter.setName("enter");
        OTP=new JTextField();
        st=new StudentListener();
    }
    public void clearWindow()
    {
        if(window!=null) {
            window.dispose();
            //password_text.setText("");
            lname_text.setText("");
            fname_text.setText("");
            //new_password_text.setText("");
            //email_text.setText("");
            prompt.setText("");
        }
        window=new JFrame();
    }
    public void Homepage()
    {
        clearWindow();

        UniversityName.setBounds(120,50,300,50);
        email.setBounds(100,150,70,20);
        password.setBounds(100,200,70,20);
        email_text.setBounds(170,150,200,20);
        password_text.setBounds(170,200,200,20);
        window.add(UniversityName);
        window.add(email);
        window.add(email_text);
        window.add(password);
        window.add(password_text);
        login.setBounds(250,250,100, 40);//x axis, y axis, width, height
        signup.setBounds(250,350,100, 40);//x axis, y axis, width, height
        login.addActionListener(this);
        signup.addActionListener(this);
        window.add(login);
        window.add(signup);

        showWindow();
    }
    public void googleAuthenticate()
    {
        clearWindow();
        UniversityName.setBounds(120,50,300,50);
        secretkey.setBounds(120,120,70,40);
        secretkey_text.setBounds(190,120,300,40);
        next.setBounds(170,400,60,40);
        if(st!=null)
        {
            String qr=st.getSt().getMfa().getQrcode();
            String secret=st.getSt().getMfa().getSecret_key();
            System.out.println("Qrcode: "+qr);
            System.out.println("Secret Key: "+secret);
            secretkey_text.setText(secret);
            String saved_file=st.getSt().getMfa().getQrcode();
            ImageIcon image_icon=new ImageIcon(saved_file);
            System.out.println(image_icon);
            qrcode.setIcon(image_icon);
            Dimension size = qrcode.getPreferredSize(); //Gets the size of the image
            qrcode.setBounds(150,200, size.width, size.height); //Sets the location of the image


        }
        next.addActionListener(this);
        window.add(UniversityName);
        window.add(secretkey);
        window.add(secretkey_text);
        window.add(qrcode);
        window.add(next);
        window.getContentPane().setBackground(Color.pink);

        showWindow();




    }
    public void showWindow()
    {
        window.setLayout(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setLayout(null);
        window.setVisible(true);
        window.setSize(600,600);
        window.show();

    }
    public void SignUp()
    {
        clearWindow();
        showWindow();
        window.getContentPane().setBackground(Color.pink);

        UniversityName.setBounds(120,50,300,50);
        fname.setBounds(100,100,70,20);
        lname.setBounds(250,100,70,20);
        fname_text.setBounds(170,100,70,20);
        lname_text.setBounds(330,100,70,20);
        email.setBounds(100,150,70,20);
        password.setBounds(100,200,70,20);
        email_text.setBounds(170,150,200,20);
        password_text.setBounds(170,200,200,20);
        new_password.setBounds(60,240,100,20);
        new_password_text.setBounds(170,240,200,20);
        window.add(UniversityName);
        window.add(email);
        window.add(email_text);
        window.add(password);
        window.add(password_text);
        window.add(new_password);
        window.add(new_password_text);
        window.add(fname);
        window.add(lname);
        window.add(fname_text);
        window.add(lname_text);
        JButton login_signupPage =new JButton("Login");
        JButton signup_signupPage=new JButton("Sign up");
        login_signupPage.setName("login_signupPage");
        signup_signupPage.setName("signup_signupPage");
        login_signupPage.setBounds(250,350,100, 40);//x axis, y axis, width, height
        signup_signupPage.setBounds(250,300,100, 40);//x axis, y axis, width, height
        prompt.setBounds(100,450,300,20);
        login_signupPage.addActionListener(this);
        signup_signupPage.addActionListener(this);
        window.add(login_signupPage);
        window.add(signup_signupPage);
        window.add(prompt);

        showWindow();


    }
    public void MFAWindow()
    {
        clearWindow();

        window.getContentPane().setBackground(Color.pink);

        UniversityName.setBounds(120,50,300,50);
        prompt.setBounds(100,450,300,20);
        JLabel otp_label=new JLabel("Enter OTP");
        otp_label.setBounds(100,150,70,20);
        OTP.setBounds(170,150,200,20);
        enter.setBounds(250,200,70,50);
        enter.addActionListener(this);
        window.add(UniversityName);
        window.add(otp_label);
        window.add(OTP);
        window.add(enter);
        window.add(prompt);

        showWindow();

    }
    public void accountWindow()
    {

        clearWindow();
        window.getContentPane().setBackground(Color.pink);
        fname.setBounds(120,120,100,40);
        fname_text.setBounds(220,120,100,20);
        lname.setBounds(120,160,100,40);
        lname_text.setBounds(220,160,60,20);
        fname_text.setText(st.getSt().getFirstName());
        lname_text.setText(st.getSt().getLastName());
        window.add(fname);
        window.add(lname);
        window.add(fname_text);
        window.add(lname_text);

        showWindow();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton o = (JButton)e.getSource();
        String name = o.getName();
        if(name.equalsIgnoreCase("login"))
        {
            System.out.println("sajdha");

            UFB ufb=null;
            try {
                ufb=UFB.getInstance();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("email_text: "+email_text.getText());
            System.out.println("password: "+password_text.getText());
            st=ufb.authenticateUser(email_text.getText(),password_text.getText());
           // st.st.PrintStudent();
            System.out.println(st);
            if(st!=null) {
                this.MFAWindow();
            }
            else
            {
                System.out.println("User didnot enter correct credentials");
            }

        }
        else if(name.equalsIgnoreCase("signup"))
        {
            this.SignUp();
        }
        else if(name.equalsIgnoreCase("enter"))
        {
            UFB uf;
            try {
                uf=UFB.getInstance();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            boolean authenticated=uf.authenticateOTP(OTP.getText(),st);
            if(authenticated) {
                this.accountWindow();
            prompt.setText("You have successfully logged in");
            }
            else
            {
                prompt.setText("WRONG OTP has been entered");
            }
        }
        else if(name.equalsIgnoreCase("login_signupPage"))
        {
             this.Homepage();

        }
        else if(name.equals("next"))
        {
            this.Homepage();
        }
        else if (name.equalsIgnoreCase("signup_signupPage"))
        {

            UFB ufb=null;
            try {
                ufb=UFB.getInstance();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            if(password_text.getText().equals(new_password_text.getText()) && Password.passwordConditions(password_text.getText()))
            {
                boolean correct_details=ufb.setSignupDetails(email_text.getText(),fname_text.getText(),lname_text.getText());
                if(correct_details) {
                    prompt.setText("You have correctly made your account");

                    st.getSt().setFirstName(fname_text.getText());
                    st.getSt().setLastName(lname_text.getText());
                    st.getSt().getPassword().setPassword(password_text.getText());
                    st.getSt().getPassword().setEmail(email_text.getText());
                    try {
                        ufb.registerSt(st);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (WriterException ex) {
                        throw new RuntimeException(ex);
                    }
                    this.googleAuthenticate();
                }
                else {
                    prompt.setText("You have to set the email as firstname + lastname @ufb.com");
                }
            }
            else {
                prompt.setText("You have entered the wrong password while entering or the password has less than 2 digits");
            }

        }
//        System.out.println(name);
//        window.getContentPane().setBackground(Color.pink);


    }
}
