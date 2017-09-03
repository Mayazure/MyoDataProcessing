package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import time.TimeParser;

public class TimestampWindow extends JFrame{

	private JTextArea console;
	private JButton convertButton;
	private JTextField input;
	private TimeParser timeParser;
	
	public TimestampWindow(){
		super();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		//		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/icon.png"));  
		//		this.setIconImage(imageIcon.getImage()); 
		this.setTitle("Timestamp Tool");
		this.setSize(400,300);
		
		JPanel mainPanel = new JPanel();
		BoxLayout mainPanelLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(mainPanelLayout);
		this.setContentPane(mainPanel);
		
		console = new JTextArea();
		mainPanel.add(console);
		
		Box toolBox = Box.createHorizontalBox();
		input = new JTextField();
//		input.setPreferredSize(new Dimension(00, 20));
		input.setMaximumSize(new Dimension(600, 20));
		convertButton = new JButton("Convert");
		toolBox.add(input);
		toolBox.add(convertButton);
//		toolBox.add(Box.createHorizontalGlue());
		
		mainPanel.add(toolBox);
		
		timeParser = new TimeParser();
		
		convertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String timedtamp = input.getText().toString();
				if(timedtamp==null||timedtamp.equals("")){
					updateConsole("No input!");
					return;
				}
				else{
					timedtamp = timedtamp.trim();
				}
				
				if(timedtamp.contains(":")){
					long time = timeParser.getTimestamp(timedtamp);
					if(time==-1){
						updateError(input.getText().toString());
					}
					else {
						updateConsole(timedtamp + ": " + time);
					}
				}
				else{
					if(timedtamp.length()==16){
						timedtamp = timedtamp.substring(0,13);
					}
					
					if(timedtamp.length()==13){
						String dateTime = timeParser.getDateTime(timedtamp);
						updateConsole(timedtamp + ": " + dateTime);
						input.setText("");
					}
					else{
						updateError(input.getText().toString());
					}
				}
			}
		});
		
		this.setMinimumSize(new Dimension(400,300));
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void updateConsole(String data){
		console.append(data);
		console.append("\r\n");
	}
	
	private void updateError(String data){
		console.append("Error: ");
		console.append(data);
		console.append("\r\n");
	}
	
	public static void main(String[] args) {
		TimestampWindow timestampWindow = new TimestampWindow();
	}
}