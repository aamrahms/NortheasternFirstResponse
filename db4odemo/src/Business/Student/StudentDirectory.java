/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Student;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author aamrah
 */
public class StudentDirectory {
    private Student student;
    private ArrayList<Student> studentDir;
    
    //Constructor
    public StudentDirectory() {    
        this.studentDir = new ArrayList<Student> ();
    }

    //Check if user exists
    public Student getStudent(String username) {
        for(Student c : studentDir)
        {
            if(c.getUsername().equalsIgnoreCase(username))
            {
                return c;
            }
        }
        return null;
    }
    //creating student
    public Student createStudent(String name, String username, String password, String address, String phone, String email, String neuid, UserAccount ua)
    {
        student=new Student(name, username, password,address, phone, email, neuid, ua);
        studentDir.add(student);
        return student;
    }
    //updating student profile
    public void updateStudent(Student student,String name, String username, String password, String address, String phone, String email, String neuid, UserAccount userAccount)
    {
        for (Student c: studentDir)
        {
            if(c.getUsername().equalsIgnoreCase(student.getUsername()))
            {
                student.setName(name);
                student.setUsername(username);
                student.setPassword(password);
                student.setAddress(address);
                student.setPhone(phone);
                student.setUserAccount(userAccount);
                break;
            }
        }
    }
    //deleting student from dir
    public void deleteStudent(Student student){
                studentDir.remove(student);
        
    }
    //Getters and setters
    public void setStudent(Student student) {
        this.student = student;
    }

    public ArrayList<Student> getStudentDir() {
        return studentDir;
    }

    public void setStudentDir(ArrayList<Student> studentDir) {
        this.studentDir = studentDir;
    }
    
    public Student getStudentWithUserName(String userName) {
        for(Student student : studentDir)
        {
            if(student.getUsername().equals(userName))
            {
                return student;
            }
           
        }
        return null;
    }
    
}