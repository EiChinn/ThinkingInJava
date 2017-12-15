package com.eichinn.typeinfo.example.nullobject;

import sun.misc.PostVMInitHook;

import java.util.ArrayList;

public class Staff extends ArrayList<Position> {
    public void add(String jobTitle, Person employee) {
        add(new Position(jobTitle, employee));
    }

    public void add(String... jobTitles) {
        for (String jobTitle : jobTitles) {
            add(new Position(jobTitle));
        }
    }

    public Staff(String... jobTitles) {
        add(jobTitles);
    }

    public boolean positionAvailable(String title) {
        for (Position position : this) {
            if (position.getJobTitle().equals(title) && position.getEmployee() == Person.NULL) {
                return true;
            }
        }
        return false;
    }

    public void fillPosition(String jobTitle, Person hire) {
        for (Position position : this) {
            if (position.getJobTitle().equals(jobTitle) && position.getEmployee() == Person.NULL) {
                position.setEmployee(hire);
                return;
            }
        }
        throw new RuntimeException("Position: " + jobTitle + " no available");
    }

    public static void main(String[] args) {
        Staff staff = new Staff("President", "CTO", "Marketing Manager", "Product Manager", "Project Lead",
                "Software Engineer", "Software Engineer", "Software Engineer", "Software Engineer", "Test Engineer",
                "Technical Writer");
        staff.fillPosition("President", new Person("Me", "Last", "The top, Lonely At"));
        staff.fillPosition("Project Lead", new Person("Janet", "Planner", "The Burbs"));
        if (staff.positionAvailable("Software Engineer")) {
            staff.fillPosition("Software Engineer", new Person("Bob", "Coder", "Bright Light City"));
        }
        System.out.println(staff);

    }
}
