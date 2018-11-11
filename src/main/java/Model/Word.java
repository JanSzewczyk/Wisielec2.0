package Model;

public class Word {
    private String WORD;

    public Word(String word) {
        this.WORD = word;
    }
    public String getWORD() {
        return this.WORD;
    }

    public int getLength() {
        return this.WORD.length();
    }

}
