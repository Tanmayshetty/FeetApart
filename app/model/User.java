package model;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import play.data.validation.Constraints;
import javax.validation.Constraint;

@Entity
public class User extends Model{
    @Id
    private int id;
    @Constraints.Required
    private int steps;
    @Constraints.Required
    private String emailId;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Finder<Long,User> find=new Finder(Long.class,User.class);
}
