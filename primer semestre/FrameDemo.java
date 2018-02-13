import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* FrameDemo.java requires no other files. */
public class FrameDemo {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(800, 800));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        JFrame frame2 = new JFrame("Frame2");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JLabel emptyLabel2 = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(1000,1800));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        while(2<3)
        {

        //Display the window.
        frame.pack();
        frame.setVisible(true);

        frame.pack();
        frame.setVisible(true);

      }
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
