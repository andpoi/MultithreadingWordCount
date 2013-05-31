public class WindowRun implements Runnable {
	private String filename;
	private Integer windowCount;

	public WindowRun(String file, Integer count) {
		filename = file;
		windowCount = count;
	}

	public void run() {
		DocWindow d = new DocWindow(filename, windowCount);
	}
}
