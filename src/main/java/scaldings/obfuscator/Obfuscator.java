package scaldings.obfuscator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.*;

import org.json.simple.JSONObject;

public class Obfuscator 
{
    private static JSONObject hash = new JSONObject();

    public static void obfuscateFile(String filePath)
    {
        String filePathChecked = filePath.replace('"', ' ');
        File file = new File(filePathChecked);

        if (!file.exists()) 
        {
            try {file.createNewFile();}
            catch (IOException e) {e.printStackTrace();}
        }

        try 
        {
            String data = readFileAsString(filePathChecked);
            String obfuscatedData = "";

            if(data.isEmpty()) {print("\nThe file is empty.\n"); return;}

            for (int i = 0; i < data.length(); ++i)
            {
                char c = data.charAt(i);
                char obfuscated = obfuscateChar(c);
                obfuscatedData = obfuscatedData + String.valueOf(obfuscated);
            }

            String path = filePathChecked.replaceAll(file.getName(), file.getName() + ".obf");
            File fileObf = new File(path);
            fileObf.createNewFile();
            FileWriter writer = new FileWriter(fileObf);
            writer.write(obfuscatedData);
            writer.close();
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
    }

    private static char obfuscateChar(char c)
    {   
        initHash();
        String character = String.valueOf(c);
        String result = (String) hash.get(character);
        if(result.length() > 1) {print("A weird error occured");}
        return result.charAt(0);
    }

    public static void initHash()
    {
        hash.put("A", "K");
        hash.put("B", "X");
        hash.put("C", "V");
        hash.put("D", "N");
        hash.put("E", "R");
        hash.put("F", "W");
        hash.put("G", "J");
        hash.put("H", "T");
        hash.put("I", "E");
        hash.put("J", "G");
        hash.put("K", "Q");
        hash.put("L", "M");
        hash.put("M", "U");
        hash.put("N", "L");
        hash.put("O", "C");
        hash.put("P", "S");
        hash.put("Q", "P");
        hash.put("R", "H");
        hash.put("S", "D");
        hash.put("T", "O");
        hash.put("U", "I");
        hash.put("V", "F");
        hash.put("W", "Y");
        hash.put("X", "Z");
        hash.put("Y", "B");
        hash.put("Z", "A");

        hash.put("a", "k");
        hash.put("b", "x");
        hash.put("c", "v");
        hash.put("d", "n");
        hash.put("e", "r");
        hash.put("f", "w");
        hash.put("g", "j");
        hash.put("h", "t");
        hash.put("i", "e");
        hash.put("j", "g");
        hash.put("k", "q");
        hash.put("l", "m");
        hash.put("m", "u");
        hash.put("n", "l");
        hash.put("o", "c");
        hash.put("p", "s");
        hash.put("q", "p");
        hash.put("r", "h");
        hash.put("s", "d");
        hash.put("t", "o");
        hash.put("u", "i");
        hash.put("v", "f");
        hash.put("w", "y");
        hash.put("x", "z");
        hash.put("y", "b");
        hash.put("z", "a");

        hash.put("1", "í");
        hash.put("2", "ž");
        hash.put("3", "é");
        hash.put("4", "ť");
        hash.put("5", "č");
        hash.put("6", "ľ");
        hash.put("7", "á");
        hash.put("8", "ý");
        hash.put("9", "+");
        hash.put("0", "š");

        hash.put(" ", "-");
    }

    public static String readFileAsString(String fileName) 
    { 
        String data = ""; 
        try {data = new String(Files.readAllBytes(Paths.get(fileName)));}
        catch (IOException e) {e.printStackTrace();}
        return data; 
    } 

    public static void print(Object object) {System.out.print(object);}
}