package scaldings.obfuscator;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Obfuscator.initHash();
        print("\n 1. Obfuscate");
        print("\nSelect one of the functions above: ");
        mainLoop();
    }

    private static void mainLoop()
    {
        Scanner scanner = new Scanner(System.in);
        print("\nEnter your file path: ");
        String path = scanner.nextLine();
        scanner.close();

        Obfuscator.obfuscateFile(path);
    }

    public static void print(Object object) {System.out.print(object);}
}