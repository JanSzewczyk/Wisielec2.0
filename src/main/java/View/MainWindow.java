package View;

import Controller.WordController;
import Model.Word;
import Model.WordList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainWindow extends JFrame implements ActionListener {
    private WordController WC;
    private WordList WL;
    private Word W;
    private HangmanPicture picture;

    private String UsW = "";
    private String WORD;
    private int miss = 0;

    public Font fontTitle, fontWord, fontUsW;
    private JLabel LTitle, LWord, LUsW;
    private JTextField TWord;
    private JButton BCheck;

    public MainWindow() throws IOException {
        WL = new WordList();
        W = new Word(WL.getWord());
        WC = new WordController();
        setFont();

        WORD = WC.setWord(W);

        setSize(1000, 600);
        setTitle("Shape Generator");
        setLayout(null);

        LTitle = new JLabel("Wisielec 2.0");
        LTitle.setFont(fontTitle);
        LTitle.setBounds(60,30,600,90);
        add(LTitle);

        LWord = new JLabel(WORD);
        LWord.setFont(fontWord);
        LWord.setBounds(70,180,600,70);
        add(LWord);

        TWord = new JTextField(30);
        TWord.setFont(fontWord);
        TWord.setBounds(60,300,250,60);
        add(TWord);

        BCheck = new JButton("Sprawdź");
        BCheck.setFont(fontWord);
        BCheck.setBounds(60,360,250,70);
        add(BCheck);
        BCheck.addActionListener(this);

        LUsW = new JLabel();
        LUsW.setFont(fontUsW);
        LUsW.setBounds(10,500,300,40);
        add(LUsW);

        picture = new HangmanPicture();
        picture.setBounds(500,30,512,512);
        add(picture);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == BCheck) {
            if(((String)TWord.getText()).equals("")) {
                miss++;
            } else if(((String)TWord.getText()).length() == 1) {
                    if(WC.checkWord(W, ((String) TWord.getText().toLowerCase()))) {
                        WORD = WC.wordControl(WORD, W, ((String) TWord.getText()).toLowerCase());
                        LWord.setText(WORD);
                        TWord.setText("");
                        if (WC.checkWord(W, WORD)) {
                            endGame("WYGRAŁEŚ", W.getWORD());
                        }
                    } else {
                        miss++;
                        UsW += (String) TWord.getText() + ", ";
                        LUsW.setText("Źle: " + UsW);
                        TWord.setText("");
                    }
            } else {
                if (WC.checkWord(W, ((String) TWord.getText()).toLowerCase())) {
                    WORD = ((String) TWord.getText()).toLowerCase();
                    TWord.setText("");
                    LWord.setText(WORD);
                    endGame("WYGRAŁEŚ", W.getWORD());
                } else {
                    UsW += (String) TWord.getText() + ", ";
                    LUsW.setText("Źle: " + UsW);
                    TWord.setText("");
                    miss++;
                }
            }

            try {
                picture.nextPic(miss);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            if(miss == 7) {
                LWord.setText(W.getWORD());
                endGame("PRZEGRAŁEŚ", W.getWORD());
            }
        }

    }

    private void setFont() {
        try {
            fontTitle = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("src/main/resources/Fonts/Galileo Font.ttf"))).deriveFont(Font.PLAIN, 70);
            fontWord = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("src/main/resources/Fonts/Galileo Font.ttf"))).deriveFont(Font.PLAIN, 50);
            fontUsW = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("src/main/resources/Fonts/Galileo Font.ttf"))).deriveFont(Font.PLAIN, 20);
        } catch(IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }

    private void endGame(String s, String w) {
        int ask = JOptionPane.showConfirmDialog(null, s + "\nHasło to: " + w + "\nCzy chcesz zagrać ponownie ?", "Konic gry", JOptionPane.YES_NO_OPTION);

        if(ask == JOptionPane.YES_OPTION){
            W = new Word(WL.getWord());
            this.WORD = WC.setWord(W);
            LWord.setText(this.WORD);
            this.miss = 0;
            LUsW.setText("");
            UsW = "";

            try {
                picture.nextPic(miss);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.exit(0);
        }
    }

}
