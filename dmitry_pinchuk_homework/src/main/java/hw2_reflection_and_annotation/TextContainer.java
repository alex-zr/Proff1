package hw2_reflection_and_annotation;

import java.io.*;

@SaveTo(path = "c:\\act\\asd.txt")
public class TextContainer {
    private String s = "prog.kiev.ua";

    @Saver
    public  void save(String text,String path) throws IOException {

        FileWriter file = new FileWriter(path);
        file.write(text);
        file.close();
    }

}
