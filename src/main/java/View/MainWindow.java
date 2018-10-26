package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.StringBufferInputStream;

public class MainWindow extends JFrame {
    // TODO: 25.10.2018 implement main window of application

    public MainWindow() throws IOException {

        setSize(800, 600);
        setTitle("Shape Generator");
        setLayout(null);

        //JLabel labelFoto = new JLabel();
      //  labelFoto.setBounds(100,0,512,512);

        HangmanPicture elo = new HangmanPicture();
        elo.setBounds(100,0,512,512);
        add(elo);

       // add(labelFoto);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
