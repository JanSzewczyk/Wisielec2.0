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


public class MainWindow extends JFrame implements ActionListener {
    private WordController WC;
    private WordList WL;
    private Word W;

    private String WORD;
    private int miss = 0;
    public Font fontTitle, fontWord;
    private JLabel LTitle, LWord;
    private JTextField TWord;
    private JButton BCheck;

    // TODO: 25.10.2018 implement main window of application

    public MainWindow() throws IOException {
        WL = new WordList();
        W = new Word(WL.getWord());
        WC = new WordController();
        setFont();

        this.WORD = WC.setWord(W);

        System.out.println(W.getLength());
        setSize(1000, 600);
        setTitle("Shape Generator");
        setLayout(null);

        LTitle = new JLabel("Wisielec 2.0");
        LTitle.setFont(fontTitle);
        LTitle.setBounds(60,30,600,60);
        add(LTitle);

        LWord = new JLabel(WORD);
        LWord.setFont(fontWord);
        LWord.setBounds(30,120,600,60);
        add(LWord);

        TWord = new JTextField(30);
        TWord.setBounds(60,300,100,20);
        add(TWord);

        BCheck = new JButton("Ustaw");
        BCheck.setBounds(60,400,100,40);
        add(BCheck);
        BCheck.addActionListener(this);

        HangmanPicture elo = new HangmanPicture();
        elo.setBounds(500,30,512,512);
        add(elo);

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
                    if(WC.checkWord(W, (String) TWord.getText())) {
                        WORD = WC.wordControl(WORD, W, ((String) TWord.getText()).toLowerCase());
                        LWord.setText(WORD);
                        TWord.setText("");
                        if (WC.checkWord(W, WORD)) {
                            System.out.println("Wygrałeś");
                        }
                    } else {
                        miss++;
                        TWord.setText("");
                    }
            } else {
                if(WC.checkWord(W,((String)TWord.getText()).toLowerCase())){
                    WORD = ((String)TWord.getText()).toLowerCase();
                    TWord.setText("");
                    LWord.setText(WORD);
                    System.out.println("Wygrałeś");                                                 //Tu się cos pierdoli X(
                } else{
                    TWord.setText("");
                    miss++;
                }
            }
            System.out.println("MISS :" + miss);

            if(miss == 7) {
                System.out.println("Przejebałeś");
                LWord.setText(W.getWORD());
            }
        }

    }

    private void setFont() {
        try {
            fontTitle = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("src/main/resources/Fonts/Rise & Shine.ttf"))).deriveFont(Font.PLAIN, 50);
            fontWord = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("src/main/resources/Fonts/Rise & Shine.ttf"))).deriveFont(Font.PLAIN, 30);
        } catch(IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }
}
