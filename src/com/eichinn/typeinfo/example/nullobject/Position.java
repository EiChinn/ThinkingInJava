package com.eichinn.typeinfo.example.nullobject;

public class Position {
    private String jobTitle;
    private Person employee;

    public Position(String jobTitle, Person employee) {
        this.jobTitle = jobTitle;
        this.employee = employee;
        if (employee == null) {
            employee = Person.NULL;
        }
    }

    public Position(String jobTitle) {
        this.jobTitle = jobTitle;
        this.employee = Person.NULL;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Person getEmployee() {
        return employee;
    }

    public void setEmployee(Person employee) {
        this.employee = employee;
        if (employee == null) {
            employee = Person.NULL;
        }
    }

    @Override
    public String toString() {
        return "Position: " + jobTitle + " " + employee;
    }
}
