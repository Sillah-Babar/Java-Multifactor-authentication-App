package org.example;

public class StudentListener implements  observerInterface {
        private Student st;

    public void setSt(Student st) {
        this.st = st;
    }

    public Student getSt() {
        return st;
    }

    public StudentListener()
    {
        st=new Student();
    }
        public StudentListener(Student student)
        {
            st=student;
        }
        @Override
        public String updateRegistrationStatus(boolean isRegistered) {
            if (isRegistered) {
                String positive="Student has been registered.\n";
                System.out.println(positive);
                return positive;
                // Perform any additional actions or logic
            } else {
                String negative="Student registration has been canceled.\n";
                System.out.println(negative);
                return negative;
                // Perform any additional actions or logic
            }
        }

}
