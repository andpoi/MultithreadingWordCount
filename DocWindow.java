import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.*;

public class DocWindow extends JFrame {
	private int count = 0;
	private JTextArea textArea = new JTextArea();

	public DocWindow(String file, Integer windowCount) {
		setLayout(new BorderLayout());
		setVisible(true);
		setSize(400, 400);

		JScrollPane textScroll = new JScrollPane(textArea);
		count = count(file);

		Integer x = windowCount;
		// Labels
		JLabel docLabel = new JLabel();
		JLabel countLabel = new JLabel();
		docLabel.setText("WordCount DocWindow: " + '"' + file + '"');
		countLabel.setText("WordCount: " + count);

		textArea.setEditable(false);

		// Add stuff to pane
		add(docLabel, BorderLayout.NORTH);
		add(textScroll, BorderLayout.CENTER);
		add(countLabel, BorderLayout.SOUTH);
		// Normal Stuff
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int y = 0;
		if (windowCount > 1) {
			y++;
			x = 0;
		}
		if (windowCount > 2)
			x = 1;
		setLocation(370 + (x * 400), y * 430);
	}

	private Integer count(String location) {
		BufferedReader r = null;
		try {
			r = new BufferedReader(new FileReader(location));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found: "+location);
		}
		try {
			while (r.ready()) {
				String tempLine = r.readLine();
				StringTokenizer ok = new StringTokenizer(tempLine);
				while (ok.hasMoreTokens()) {
					ok.nextToken();
					count++;
				}
				textArea.append(tempLine + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Exception - DocWindow:count()");
		}
		return count;
	}

}
