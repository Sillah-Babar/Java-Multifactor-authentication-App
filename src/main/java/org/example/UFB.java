package org.example;

import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.ArrayList;

//university of bradford
public class UFB  implements  universityInterface{
    static UFB instance;
    private ArrayList<StudentListener> observers;
    private boolean isRegistered;

    private UFB() throws IOException {
        observers = new ArrayList<StudentListener>();
        readObservers();
        isRegistered = false;
    }
    public static UFB getInstance() throws IOException {
        if(instance==null)
        {
            instance=new UFB();

        }
        return instance;
    }
    public StudentListener authenticateUser(String email,String password)
    {
        StudentListener st=new StudentListener();
        for(int i=0 ; i<observers.size() ;i++)
        {
            boolean present=observers.get(i).getSt().getPassword().authenticatePassword(email,password);
            System.out.println("boo: "+present);
            System.out.println(password);
            observers.get(i).getSt().PrintStudent();
            if(present==true)
            {
                st=observers.get(i);
                return st;

            }

        }
        return null;

    }
    public boolean authenticateOTP(String ot,StudentListener st)
    {
        boolean value=false;
      MFA mf=MFA.getInstance();
      value=mf.authenticateOTP(ot,st.getSt().getMfa().getSecret_key());
     return value;
    }


    public void readObservers() throws IOException {
        Persistence pr=new Persistence();
        observers=pr.readFromFile();

    }
    public boolean setSignupDetails(String email,String firstName,String lname)
    {
     return Password.emailConditions(email,firstName,lname);
    }


    public ArrayList<StudentListener> getObservers() {
        return observers;
    }

    public boolean registerSt(StudentListener observer) throws IOException, WriterException {
           observers.add(observer);
           MFA mf=MFA.getInstance();
           if(mf==null)
               return false;
           String secretKey=mf.generateSecretKey();
           observer.getSt().getMfa().setSecret_key(secretKey);
           String email = observer.getSt().getPassword().getEmail();

        String companyName = "ufb";
        String barCodeUrl = mf.getGoogleAuthenticatorBarCode(secretKey, email, companyName);
        System.out.println(barCodeUrl);
        observer.getSt().getMfa().setQrcode("QRCode\\"+secretKey+".png");
        mf.createQRCode(barCodeUrl,"QRCode\\"+secretKey+".png",100,100);
           
       return true;
    }

    @Override
    public void removeStudent(StudentListener observer) {

    }

    @Override
    public void notifyStudents() {

    }
}
