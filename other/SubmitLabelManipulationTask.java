import javax.swing.*;
import java.util.concurrent.*;

public class SubmitLabelManipulationTask {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hello Swing");
            final JLabel label = new JLabel("A Label", SwingConstants.CENTER);
            frame.add(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 100);
            frame.setVisible(true);
            Timer timer = new Timer(8000, e -> {
                label.setText("Try this instead");
            });
            timer.setRepeats(false);
            timer.start();
        });
    }
}