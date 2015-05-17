package controllers;

import com.avaje.ebean.Ebean;
import model.User;
import play.*;

import play.api.libs.Files;
import play.data.Form;
import play.mvc.*;

import rest.RegisterUI;
import views.html.*;

import java.io.File;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }
    public static Result register(){

        Http.RequestBody body=request().body();
        Http.MultipartFormData multipartFormData=body.asMultipartFormData();
        Form<User> userForm= Form.form(User.class);

        User user=userForm.bindFromRequest().get();
        Logger.info("Email ID : "+user.getEmailId()+" Steps "+user.getSteps());
        Ebean.save(user);

        int steps=user.getSteps();

        return ok("Steps"+steps+"Request "+request().body());
    }
    public static  Result uploadfile(){
        File file=request().body().asRaw().asFile();

        return ok("File upload SuccessFully Completed");
    }

}
