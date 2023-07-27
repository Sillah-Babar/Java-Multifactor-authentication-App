package org.example;

public class Student {


    private Password password;

    private MFAcredentials mfa;

    private String firstName;
    private String lastName;
    private String address;
    private String number;
    private int numCourses;
    public Student()
    {
        firstName="";
        lastName="";
        address="";
        number="";
        numCourses=0;
        password=new Password();
        mfa=new MFAcredentials();

    }
    public Student(String fn,String ln,String em,String pass,String ad,String num,int numC,String sec,String qrcode)
    {
        firstName=fn;
        lastName=ln;
        address=ad;
        number=num;
        numCourses=numC;
        password=new Password();
        password.email=em;
        password.password=pass;
        mfa=new MFAcredentials();
        mfa.setSecret_key(sec);
        mfa.setQrcode(qrcode);
    }
    public void PrintStudent()
    {
        System.out.println("First Name: "+firstName);
        System.out.println("Last Name: "+lastName);
        System.out.println("Address: "+ address);
        System.out.println("Phone Number: "+ number);
        System.out.println("Enrolled in Coureses: "+ numCourses);
        System.out.println("Email: "+ password.email);
        System.out.println("password: "+ password.password);

    }
    public String convertToString()
    {
        String result=firstName+","+lastName+","+ password.email+","+password.password+","+address+","+number+","+Integer.toString(numCourses)+","+mfa.getSecret_key()+","+mfa.getQrcode()+"\n";

        return result;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setNumCourses(int numCourses) {
        this.numCourses = numCourses;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public int getNumCourses() {
        return numCourses;
    }

    public void setMfa(MFAcredentials mfa) {
        this.mfa = mfa;
    }

    public Password getPassword() {
        return password;
    }

    public MFAcredentials getMfa() {
        return mfa;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

}
