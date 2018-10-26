package Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DownloadFile {
    private List<String> LIST;

    public DownloadFile(String filePath) {
        this.LIST = new ArrayList<String>();

        try {
            // Uworzenie obiektu FileReader
            FileReader fileReader = new FileReader(filePath);

            // Utworzenie obiektu bufferReader
            BufferedReader bufferReader = new BufferedReader(fileReader);

            String word;
            while((word = bufferReader.readLine()) != null) {
                LIST.add(word);
            }
            fileReader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getList() {
        return this.LIST;
    }
}
