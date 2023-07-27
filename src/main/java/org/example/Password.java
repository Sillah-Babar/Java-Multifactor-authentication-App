package org.example;

public class Password {
    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    String password;
    String email;

    public Password()
    {
        password="";
        email="";
    }
    public boolean authenticatePassword(String em,String pass)
    {

        if(password.equals(pass) && email.equals(em))
        {
            return true;
        }
        return false;
    }
    public static boolean passwordConditions(String pass)
    {
        boolean numbers=false;
        int count=0;
        for(int i=0 ; i<pass.length() ;i++)
        {
              if(pass.charAt(i)>=48 && pass.charAt(i)<=57)
              {
                  count+=1;
              }
        }

        if(count>=2)
            return true;
        else
            return false;
    }
    public static boolean emailConditions(String email,String fname,String lname)
    {
        String prompt_Email=fname.toLowerCase()+lname.toLowerCase()+"@ufb.com";
        if(email.equals(prompt_Email))
            return true;
        return false;
    }
}
