
public class SRPDemo {

	public static void main(String[] args) throws Exception {
		  Journal j = new Journal();
		    j.addEntry("I cried today");
		    j.addEntry("I ate a bug");
		    System.out.println(j);

		    Persistence p = new Persistence();
		    String filename = "c:\\temp\\journal.txt";
		    p.saveToFile(j, filename, true);

		    // windows!
		    Runtime.getRuntime().exec("notepad.exe " + filename);
	}

}
