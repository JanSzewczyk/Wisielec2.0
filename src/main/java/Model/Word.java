package Model;

public class Word {
    private String WORD;

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
