package software;

import java.awt.Color;
import java.awt.Font;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello from java");
        new GUI();
    }
}

class GUI extends JFrame {

    int TILE_SIZE = 5, ROWS = 200, COLLUMS = 200;
    JPanel background;

    int random = new java.util.Random().nextInt(1000000000);

    public GUI() {

        int OFFSET = 10;
        int WIDTH = 400, HEIGHT = 180-OFFSET;
        background = new JPanel();
        background.setLayout(null);
        background.setBounds(0, 0, WIDTH, HEIGHT);
        background.setBackground(Color.BLACK);

        setSize(WIDTH, HEIGHT);
        setTitle("SOFTWARE");
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JLabel temperature = new JLabel(), humidity = new JLabel();
        temperature.setBounds(50, 30-OFFSET, WIDTH, 50);
        humidity.setBounds(50, 80-OFFSET, WIDTH, 50);

        double temp = 0, humd = 0;
        try {
            temp = DataReader.getTemperature();
            humd = DataReader.getHumidity();
        } 
        catch (IOException e) {}

        temperature.setText("TEMPERATURE: "+temp+"°C");
        temperature.setFont(new Font("Monospaced", Font.PLAIN, 25));
        temperature.setForeground(Color.WHITE);

        humidity.setText("HUMIDITY: "+humd+"%");
        humidity.setFont(new Font("Monospaced", Font.PLAIN, 25));
        humidity.setForeground(Color.WHITE);

        background.add(temperature);
        background.add(humidity);
        add(background);

        setVisible(true);
    }
}


class DataReader {
    public static double getTemperature() throws FileNotFoundException, IOException {
        BufferedReader r = new BufferedReader(new FileReader(new File("dat/temp.txt")));
        double temp = 0;

        try {
            String l = r.readLine();
            if (l != null) temp = Double.parseDouble(l);
        }
        finally {r.close();}
        return temp;
    }

    public static double getHumidity() throws FileNotFoundException, IOException {
        BufferedReader r = new BufferedReader(new FileReader(new File("dat/humid.txt")));
        double temp = 0;

        try {
            String l = r.readLine();
            if (l != null) temp = Double.parseDouble(l);
        }
        finally {r.close();}
        return temp;
    }
}