package hwJson2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        String path = "D:\\IdeaProjects\\Proff1\\dmitry_pinchuk_homework\\src\\main\\webapp\\hw2Json\\json.txt";
        String result = parString(path);
        Gson gson = new GsonBuilder().create();
        Jobj json = (Jobj) gson.fromJson(result,Jobj.class);
        System.out.println("JSON: \n\t" + gson.toJson(json));


    }

    private static String parString(String pat) throws  IOException{

        StringBuilder sb = new StringBuilder();
        try(BufferedReader f = new BufferedReader(new FileReader(pat))) {

            String txt;
            for(;(txt=f.readLine())!=null;){
                sb.append(txt).append(System.lineSeparator());
            }
            }catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
