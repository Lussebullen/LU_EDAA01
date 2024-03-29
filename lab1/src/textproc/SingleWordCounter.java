package textproc;

public class SingleWordCounter implements TextProcessor {
	private String word;
	private int n;

	public SingleWordCounter(String word) {
		this.word = word;
		this.n = 0;
	}

	public void process(String w) {
		if (w.equals(word)) {
			this.n++;
		}
	}

	public void report() {
		System.out.println(word + ": " + n);
	}

}
