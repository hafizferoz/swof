package supportwheel.api.application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import supportwheel.main.APIProgram;

public class MainPanel extends JPanel {

	private JTextField _totalShiftDays;
	private JTextField _totalEngineers;
	private JTextArea _schedule;
	private JButton _process;
	private JPanel _centralPanel;
	private JScrollPane _containerScroll;
	private JPanel _topPanel;
	private JPanel _sidePanel;
	private JLabel _totalShiftDaysLabel;
	private JLabel _totalEngLabel;
	private JPanel _labelPanel;

	public MainPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout());

		_totalShiftDaysLabel = new JLabel("Total Weeks of Shift");
		_totalShiftDays = new JTextField("2", 20);
		_totalEngLabel = new JLabel("Engineers Per Day Per Shift"); 
		_totalEngineers = new JTextField("2", 20); // As per shift Rule two engineers per day
		_totalEngineers.setEnabled(false);
		_schedule = new JTextArea();
		_containerScroll = new JScrollPane(_schedule, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		_containerScroll.setPreferredSize(new Dimension(400, 550));
		_containerScroll.setViewportView(_schedule);
		_schedule.scrollRectToVisible(_containerScroll.getVisibleRect());
		_schedule.setLineWrap(true);
		_schedule.setWrapStyleWord(true);

		_process = new JButton("Process");
		_sidePanel = new JPanel(new GridBagLayout());

		_topPanel = new JPanel();
		_topPanel.add(_totalShiftDaysLabel);
		_topPanel.add(_totalShiftDays);
		_labelPanel = new JPanel();
		_labelPanel.add(_totalEngLabel);
		_labelPanel.add(_totalEngineers);
		// _sidePanel.add(solasWestPanel, BorderLayout.SOUTH);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
		_sidePanel.add(_topPanel, constraints);

		constraints.gridy = 1;
		// _sidePanel.add(eastPanel, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4;
		// _sidePanel.add(_topPanel, constraints);

		constraints.gridx = 0;
		constraints.gridy = 8;
		_sidePanel.add(_labelPanel, constraints);
		constraints.gridx = 1;
		constraints.gridy = 10;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		_sidePanel.add(_process, constraints);

		_centralPanel = new JPanel();
		_centralPanel.add(_containerScroll);

		add(_sidePanel, BorderLayout.NORTH);
		add(_centralPanel, BorderLayout.CENTER);

		// add(_process,BorderLayout.SOUTH);

		_process.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				process();
			}
		});
		process(); // initial generate for 10 days (2 weeks) and 2 engineers

	}

	protected void process() {
		try {
			int totalNumberOfDays = Integer.parseInt(_totalShiftDays.getText());
			totalNumberOfDays =totalNumberOfDays * 5; //five days per week
			int numberOfEngineersPerShift = Integer.parseInt(_totalEngineers.getText());
			APIProgram program = new APIProgram(totalNumberOfDays, numberOfEngineersPerShift);
			String scheduleDays = program.generateSchedule();
			_schedule.setText(scheduleDays);
		} catch (Exception e) {
			showMessage("An Error has occured please retry");
		}
	}

	private void showMessage(final String msg) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	private void showSuccessMessage(final String msg) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JOptionPane.showMessageDialog(null, msg, "INFO", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
