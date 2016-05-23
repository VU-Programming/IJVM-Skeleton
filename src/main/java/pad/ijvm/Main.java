package pad.ijvm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {

    static void printUsage() {
        System.out.println("Usage: java ijvm file.bin");
    }

    public static void main(String args[]) {

        if (args.length < 1) {
            printUsage();
            System.exit(0);
        }
        try {
            File binary = new File(args[0]);

            // Create the ijvm instance
            MachineFactory.createIJVMMachine(binary).run();
        } catch (FileNotFoundException e) {
            System.err.printf("%s\n", e.getMessage());
        } catch (IOException e) {
            System.err.printf("%s\n", e.getMessage());
        }

    }
}
