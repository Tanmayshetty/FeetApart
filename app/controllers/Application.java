package controllers;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import model.User;
import model.UserImg;
import org.apache.commons.io.FileUtils;
import play.*;

import play.api.libs.Files;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;

import rest.RegisterUI;
import views.html.*;

import java.io.File;
import java.io.IOException;

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
        session("Id",String.valueOf(user.getId()));
        Logger.info("User ID : "+user.getId());
        JsonNode jsonNode=request().body().asJson();
        ObjectNode objectNode= Json.newObject();
        objectNode.put("Result","Success");
        return ok(objectNode);
    }
    public static  Result uploadfile(){
        int id=Integer.parseInt(session("Id"));
        String uploadedFileName;
        UserImg userImg=new UserImg();
       Http.MultipartFormData body=request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart filePart=body.getFile("file");
      /*  File file=request().body().asRaw().asFile();*/
        if(filePart!=null){
            String fileName=filePart.getFilename();
            File file=filePart.getFile();
            Logger.info("File Path "+file.getAbsolutePath());
            uploadedFileName=file.getAbsolutePath().split("/")[1];
            File dir=new File(Play.application().path().getAbsolutePath()+"/public/images/");
            if(!dir.exists())
            {
                dir.mkdirs();
            }
        try {
            FileUtils.copyFileToDirectory(file,dir);
        } catch (IOException e) {
            e.printStackTrace();
        }

            userImg.setImgpath(uploadedFileName);
            userImg.setUserId(id);

        }

        Ebean.save(userImg);
        ObjectNode node=Json.newObject();
        node.put("result","success1");
        return ok(node);
    }

}
