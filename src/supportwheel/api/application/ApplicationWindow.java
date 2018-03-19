package supportwheel.api.application;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * @author Feroz Hafiz
 *
 */
public class ApplicationWindow {
	private JFrame frame;
	private MainPanel mainPanel;
	 public static void main(String[] args) {

	        try {
	            // set look and feel to system dependent
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	 
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	ApplicationWindow window = new ApplicationWindow();
		            window.frame.setVisible(true);
	            	
	            	
	            }
	        });
	    
	    }

	    public ApplicationWindow() {
	        initialize();
	    }

	    private void initialize() {
	        frame = new JFrame("Support Wheel of Fate");
	       // frame.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
	        frame.setBounds(100, 100, 1200, 1000);
	        frame.setResizable(false);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        mainPanel = new MainPanel();
	        mainPanel.setSize(800,100);
//	        logPanel.setAlignmentX(0);
//	        logPanel.setAlignmentY(0);
	        c.fill = GridBagConstraints.NORTHEAST;
			c.gridx = 0;
			c.gridy = 0;
	        frame.getContentPane().add(mainPanel);
	        frame.pack();
	        
	    }
}
