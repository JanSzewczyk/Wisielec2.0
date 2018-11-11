package Controller;

import Model.Word;

public class WordController {
    public String setWord(Word W) {
        String WORD = "";

        for (int i = 0; i < W.getLength(); i++)
            WORD += "_";
        return WORD;
    }

    public String wordControl(String word, Word W, String guess) {
        String newWORD = "";
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != '_'){
                newWORD += word.charAt(i);
            }else if (guess.charAt(0) == W.getWORD().charAt(i)) {
                newWORD += guess;
            } else {
                newWORD += "_";
            }
        }
        return newWORD;
    }

    public boolean checkWord(Word W, String word) {
        if(word.length() == 1) {
            for (int i = 0; i < W.getLength(); i++)
                if(W.getWORD().charAt(i) ==  word.charAt(0))
                    return true;
        } else {
            if (W.getWORD().equals(word)) {
                return true;
            }
        }
        return false;
    }

}
