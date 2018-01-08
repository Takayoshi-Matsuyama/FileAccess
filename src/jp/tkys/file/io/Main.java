package jp.tkys.file.io;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	    try {
	        writeFile("/Users/takayoshi/MyDocuments/Work/Sample.txt");
            readFile("/Users/takayoshi/MyDocuments/Work/Sample.txt");
        } catch (Exception e) {

        } finally {

        }
    }

    private static void writeFile(String fileName) throws IOException {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        try {
            writer = new FileWriter(fileName, false);
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

    private static void readFile(String fileName) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

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

            if (fileReader != null) {
                fileReader.close();
            }
        }
    }
}
