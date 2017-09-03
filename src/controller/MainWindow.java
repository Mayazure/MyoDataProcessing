package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import emgData.FileParser;
import emgData.TimestampFormatter;
import experiment.DataInfo;
import rangeData.DataExtractor;

public class MainWindow extends JFrame{

	private JPanel mainPanel;
	
	private JTextArea console;
	private JButton selectButton;
	private JButton selectRangeButton;
	private JButton startButton;
	private JButton extractButton;
	
	private DataInfo dataInfo = DataInfo.getDataInfoInstance();
	private FileParser fileParser;
	private DataExtractor dataExtractor;
	private TimestampFormatter timestampFormatter;

	public MainWindow(){

		//non-ui part
		fileParser = new FileParser(this);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/icon.png"));  
		//		this.setIconImage(imageIcon.getImage()); 
		this.setTitle("MyoDriving Data Processing");
		this.setSize(800,640);

		mainPanel = new JPanel();
		
		BoxLayout mainPaneLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(mainPaneLayout);
		
		this.setContentPane(mainPanel);

		console = new JTextArea();
		console.setSize(MainWindow.this.getSize());
		console.setMinimumSize(MainWindow.this.getSize());
		console.setMaximumSize(MainWindow.this.getSize());
		
		JScrollPane consoleScrollPane = new JScrollPane(console);
		mainPanel.add(consoleScrollPane);
		
		Box toolPanel = Box.createHorizontalBox();
		mainPanel.add(toolPanel);
		
		selectButton = new JButton("select");
		selectRangeButton = new JButton("range");
		extractButton = new JButton("extract");
		startButton = new JButton("start");
		selectButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String dir = dataInfo.getDataFilePath();
				JFileChooser fc = new JFileChooser(dir);
				fc.showOpenDialog(MainWindow.this);
				File file = fc.getSelectedFile();
				if(file!=null){
					String filePath = file.getAbsolutePath();
					int a = filePath.lastIndexOf("\\");
					String fileName = filePath.substring(a+1);
					filePath = filePath.substring(0, a+1);
					dataInfo.setDataFilePath(filePath);
					dataInfo.setEmgFileName(fileName);
					
					updateSimpleConsole("Data directory: "+dataInfo.getDataFilePath());
					updateSimpleConsole("Select file: "+dataInfo.getEmgFileName());
					
				}
			}
		});
		
		selectRangeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String dir = dataInfo.getDataFilePath();
				JFileChooser fc = new JFileChooser(dir);
				fc.showOpenDialog(MainWindow.this);
				File file = fc.getSelectedFile();
				if(file!=null){
					String filePath = file.getAbsolutePath();
					int a = filePath.lastIndexOf("\\");
					String fileName = filePath.substring(a+1);
					filePath = filePath.substring(0, a+1);
					dataInfo.setDataFilePath(filePath);
					dataInfo.setRangeFileName(fileName);
					
					updateSimpleConsole("Range directory: "+dataInfo.getDataFilePath());
					updateSimpleConsole("Select range file: "+dataInfo.getRangeFileName());
					
				}
				
			}
		});
		
		extractButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timestampFormatter = new TimestampFormatter();
				timestampFormatter.formatAllTimestamp();
				dataExtractor = new DataExtractor(MainWindow.this);
				dataExtractor.extractData();
				updateSimpleConsole("Data extraction done.");
			}
		});
		
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fileParser.parseAll();
			}
		});
		
		toolPanel.add(selectButton);
		toolPanel.add(selectRangeButton);
		toolPanel.add(startButton);
		toolPanel.add(extractButton);
		toolPanel.add(Box.createHorizontalGlue());

		this.setMinimumSize(new Dimension(800,640));
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public void updateSimpleConsole(String data){
		console.append(data);
		console.append("\r\n");
		console.setCaretPosition(console.getDocument().getLength());
	}
}
