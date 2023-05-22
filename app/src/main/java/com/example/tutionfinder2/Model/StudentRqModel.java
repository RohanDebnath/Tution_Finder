package com.example.tutionfinder2.Model;

public class StudentRqModel {
String PreferableTime,Active_Ph,Current_Sem,Stream,College_Name,FullNameStudent,Age,Gender,State,Query;

    public StudentRqModel(String preferableTime, String active_Ph, String current_Sem, String stream, String college_Name, String fullNameStudent, String age, String gender, String state,String query) {
        PreferableTime = preferableTime;
        Active_Ph = active_Ph;
        Current_Sem = current_Sem;
        Stream = stream;
        College_Name = college_Name;
        FullNameStudent = fullNameStudent;
        Age = age;
        Gender = gender;
        State = state;
        Query=query;
    }

    public String getQuery() {
        return Query;
    }

    public  StudentRqModel()
{

}

    public String getPreferableTime() {
        return PreferableTime;
    }

    public String getActive_Ph() {
        return Active_Ph;
    }

    public String getCurrent_Sem() {
        return Current_Sem;
    }

    public String getStream() {
        return Stream;
    }

    public String getCollege_Name() {
        return College_Name;
    }

    public String getFullNameStudent() {
        return FullNameStudent;
    }

    public String getAge() {
        return Age;
    }

    public String getGender() {
        return Gender;
    }

    public String getState() {
        return State;
    }
}
