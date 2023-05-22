package com.example.tutionfinder2.Model;

public class CourseModel {
    String FullName;
    String Subjects,Search;
    String Qualification;
    String Description;
    String Contact;
    String Fee;
    String Image;
    String ID;

    public CourseModel()
    {

    }

    public void setSubjects(String subjects) {
        Subjects = subjects;
    }

    public String getSearch() {
        return Search;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public CourseModel(String ID, String fullName, String subjects, String qualification, String description, String contact, String fee, String image, String search) {
        this.ID = ID;
        FullName = fullName;
        Subjects = subjects;
        Qualification = qualification;
        Description = description;
        Contact = contact;
        Fee = fee;
        this.Image = image;
    }

    public String getFullName() {
        return FullName;
    }

    public String getSubjects() {
        return Subjects;
    }

    public String getQualification() {
        return Qualification;
    }

    public String getDescription() {
        return Description;
    }

    public String getContact() {
        return Contact;
    }

    public String getFee() {
        return Fee;
    }

    public String getImage() {
        return Image;
    }


    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public void setSearch(String search) {
        Search = search;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public void setFee(String fee) {
        Fee = fee;
    }

    public void setImage(String image) {
        Image = image;
    }
}
