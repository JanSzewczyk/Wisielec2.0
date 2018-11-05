package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HangmanPicture extends JLabel {
    private File file;
    private BufferedImage bi;
    private ImageIcon imgIcon;

    public HangmanPicture() throws IOException {
        file = new File("src/main/resources/hangman0.png");
        bi = ImageIO.read(file);
        imgIcon = new ImageIcon(bi);
        setIcon(imgIcon);
    }

    public void nextPic(int number) throws IOException {
        String path = "";

        switch (number) {
            case 0:
                    path = "src/main/resources/hangman0.png";
                    break;
                case 1:
                    path = "src/main/resources/hangman1.png";
                    break;
                case 2:
                    path = "src/main/resources/hangman2.png";
                    break;
                case 3:
                    path = "src/main/resources/hangman3.png";
                    break;
                case 4:
                    path = "src/main/resources/hangman4.png";
                    break;
                case 5:
                    path = "src/main/resources/hangman5.png";
                    break;
                case 6:
                    path = "src/main/resources/hangman6.png";
                    break;
                case 7:
                    path = "src/main/resources/hangman7.png";
                    break;
        }

        file = new File(path);
        bi = ImageIO.read(file);
        imgIcon = new ImageIcon(bi);
        setIcon(imgIcon);
    }
}
