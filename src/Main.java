
import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {
        ChoiceFrame frame = new ChoiceFrame();
        frame.initialize();
        frame.setTitle("ChoiceTest");
        frame.setSize(500, 300);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
