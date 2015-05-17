package rest;

import play.data.validation.Constraints;

public class RegisterUI {
    @Constraints.Required
    private int steps;
    @Constraints.Required
    private String emailId;
    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
