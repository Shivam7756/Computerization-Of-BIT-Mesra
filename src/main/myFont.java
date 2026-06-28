package main;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class myFont extends Font{
    private String path;
    private int size;
    public myFont(String name, int style, int size) throws FontFormatException, IOException {
        super(Font.createFont(Font.TRUETYPE_FONT,new File(name)).deriveFont(size));
        this.path=name;
        this.size=size;
    }
}
