package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    private final String filePath;
    private final String delimiter;


    public CSVParser(String filePath, String delimiter) {
        this.filePath = filePath;
        this.delimiter = delimiter;
    }


    public List<String[]> parse() throws IOException {
        List<String[]> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(delimiter);
                result.add(columns);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Пример использования
        CSVParser parser = new CSVParser("data.csv", ",");

        try {
            List<String[]> rows = parser.parse();

            for (String[] row : rows) {
                System.out.println(String.join("\t", row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
