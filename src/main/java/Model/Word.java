package Model;

public class Word {
    String WORD;
    // TODO: 25.10.2018 implement word class

    public Word(String word) {
        this.WORD = word;
        System.out.println(this.WORD);
    }
    public String getWORD() {
        return this.WORD;
    }

    public int getLength() {
        return this.WORD.length();
    }

}
