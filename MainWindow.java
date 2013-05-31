import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 * @author Andrew Poirier
 *
 */
public class MainWindow extends JFrame{

	public MainWindow(){

		setLayout(new BorderLayout());
		setSize(300, 200);

		//JTextFields
		final JTextField file1 = new JTextField(25);
		final JTextField file2 = new JTextField(25);
		final JTextField file3 = new JTextField(25);
		final JTextField file4 = new JTextField(25);
		file1.setText("example.txt");
		file2.setText("src/MainWindow.java");
		file3.setText("src/Driver.java");
		file4.setText("src/DocWindow.java");

		//JTextField Panel
		JLabel label1 = new JLabel("Enter the filenames of the files to count");
		Container filePanel = new Container();
		filePanel.setLayout(new FlowLayout());
		filePanel.add(label1,FlowLayout.LEFT);
		filePanel.add(file4,FlowLayout.CENTER);
		filePanel.add(file3,FlowLayout.CENTER);
		filePanel.add(file2,FlowLayout.CENTER);
		filePanel.add(file1,FlowLayout.CENTER);
		// Buttons
		JButton countButton = new JButton("Count");
		countButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int tempCount=0;
				String filename1 = file1.getText();
				if(filename1.contains(".")){
					Runnable r = new WindowRun(filename1,tempCount);
					Thread t = new Thread(r);
					t.start();
					tempCount++;
				}
				String filename2 = file2.getText();
				if(filename2.contains(".")){
					Runnable r = new WindowRun(filename2,tempCount);
					Thread t = new Thread(r);
					t.start();
					tempCount++;
				}
				String filename3 = file3.getText();
				if(filename3.contains(".")){
					Runnable r = new WindowRun(filename3,tempCount);
					Thread t = new Thread(r);
					t.start();
					tempCount++;
				}
				String filename4 = file4.getText();
				if(filename4.contains(".")){
					Runnable r = new WindowRun(filename4,tempCount);
					Thread t = new Thread(r);
					t.start();
					tempCount++;
				}

			}
		});
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		// Button Panel
		Container buttonPanel = new Container();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(countButton);
		buttonPanel.add(exitButton);

		// Add frames to container
		//add(shapeLabel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		add(filePanel,BorderLayout.CENTER);
		// Normal Stuff
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(false);
		setLocation(0, 0);
	}
}
