package Data;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    public  String firstName , lastName , email , password ;

    public void JsonReader () throws ParseException, IOException {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\Data\\userdata.json";
        File  srcfile = new File(filePath);

        JSONParser parser = new JSONParser();
        JSONArray JSArray = (JSONArray) parser.parse(new FileReader(srcfile));
        for (Object jsobject : JSArray) {
            JSONObject person = (JSONObject) jsobject;
            firstName = (String) person.get("firstName");
            System.out.println(firstName);
            lastName = (String)person.get("lastName");
            System.out.println(lastName);
            email  = (String) person.get("email");
            System.out.println(email);
            password = (String)person.get("password");
            System.out.println(password);

        }
    }
}
