package com.example.recyclerviewcustomadapterloadingmore.model;

public class Member {
    private String firstName;
    private String lastName;
    private boolean avialable = false;

    public Member(String firstName, String lastName, boolean avialable) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.avialable = avialable;
    }

    public Member() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAvialable() {
        return avialable;
    }

    public void setAvialable(boolean avialable) {
        this.avialable = avialable;
    }
}
