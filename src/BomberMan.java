import javax.swing.*;

public class BomberMan {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        Gameplay gameplay = new Gameplay();
        frame.setBounds(0,0,600,600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BomberMan!");
        frame.add(gameplay);
    }
}
