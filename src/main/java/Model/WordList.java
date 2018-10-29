package Model;

import Controller.DownloadFile;

import java.util.List;
import java.util.Random;

public class WordList {
    List<String> LIST;

    public WordList() {
        DownloadFile DF = new DownloadFile("src/main/resources/WORDS.txt");
        this.LIST = DF.getList();
    }

    public String getWord() {
        Random rand = new Random();
        return  LIST.get(rand.nextInt(LIST.size()));
    }

    public void show() {
        for (String word : LIST)
            System.out.println(word);
    }
}
