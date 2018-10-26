package Model;

import Controller.DownloadFile;

import java.util.List;

public class WordList {
    List<String> LIST;
    // TODO: 25.10.2018 make a words list download from the file and draw a one word and return its 
    public WordList() {
        DownloadFile DF = new DownloadFile("src/main/resources/WORDS.txt");
        this.LIST = DF.getList();
    }

    public String getWord() {

        return
    }
    public void show() {
        for (String word : LIST)
            System.out.println(word);
    }
}
