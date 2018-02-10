
package com.me.bean;

/**
 *
 * @author krapa
 */

//We have separet DAAO class as the fetching of data from database is time consuming. So we create seperate data access class.

//This is our bean for user table.
public class User {
    int userId;
    String fname;
    String lname;
    String email;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
