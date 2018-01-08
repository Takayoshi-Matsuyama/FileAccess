package tech.tkys.file.io;

import java.io.*;

/**
 * Main class of file I/O application.
 */
public class Main {

    /**
     * Entry point of this application.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
	    try {
	        writeFile("/Users/takayoshi/MyDocuments/Work/Sample.txt", false);
            readFile("/Users/takayoshi/MyDocuments/Work/Sample.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes sample text to the specified file.
     * @param fileName      The file name to write.
     * @param append        Mode of appending. true: append, false: overwrite.
     * @throws IOException  Thrown if failed to close file writers.
     */
    private static void writeFile(String fileName, boolean append) throws IOException {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        try {
            writer = new FileWriter(fileName, append);
            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(String.format("ABC%n"));
            bufferedWriter.write(String.format("DEF%n"));
            bufferedWriter.write(String.format("GHI%n"));

            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * Reads text from the specified file.
     * @param fileName      The file name to read.
     * @throws IOException  Thrown if failed to close file readers.
     */
    private static void readFile(String fileName) throws IOException {
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader(fileName);
            bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }

            if (reader != null) {
                reader.close();
            }
        }
    }
}
