package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HangmanPicture extends JLabel {
    private BufferedImage img;

    public HangmanPicture() throws IOException {

        File file = new File("src/main/resources/hangman7.png");
        BufferedImage bi = ImageIO.read(file);
        ImageIcon imgIcon = new ImageIcon(bi);
        setIcon(imgIcon);

    }
}
