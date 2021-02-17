/*import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Journal {

	
	private final List<String> 	entries = new ArrayList<>();
	private static int count = 0;
	
	
	public void addEntry(String  text){
		entries.add("" +(++count)+ ":" +text );
		
	}
	
	public void removeEntry(int index){
		entries.remove(index);
	}
	
	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}
	
	public void save(String fileName) throws FileNotFoundException{
		
		try(PrintStream out = new PrintStream(fileName)){
			out.println(toString());
		}
	}
	
	public void load(String fileName){
		
	}
	
	public void load(URL url){
		
	}
}

class Persistence{
	 public void saveToFile(Journal journal, String fileName,boolean overwrite) throws FileNotFoundException{
		 if(overwrite || new File(fileName).exists()){
			 try(PrintStream out = new PrintStream(fileName)){
					out.println(toString());
				}
		 }
	 }
}

class Demo{
	public static void main(String[] args) throws Exception{
		
		Journal journal = new Journal();
		
		journal.addEntry("I cried Today");
		journal.addEntry("I ate a bug");
		
		System.out.println(journal);
		
		
		Persistence persistence = new Persistence();
		
		String fileName = "E:\\Temp\\journal.txt";
		
		persistence.saveToFile(journal, fileName, true);
		
		Runtime.getRuntime().exec("Notepad.exe "+ fileName);
	}
}

 	*/

import static java.lang.System.out;

import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Journal
{
  private final List<String> entries = new ArrayList<>();

  private static int count = 0;

  public void addEntry(String text)
  {
    entries.add("" + (++count) + ": " + text);
  }

  public void removeEntry(int index)
  {
    entries.remove(index);
  }

  @Override
  public String toString() {
    return String.join(System.lineSeparator(), entries);
  }

  // here we break SRP
  public void save(String filename) throws Exception
  {
    try (PrintStream out = new PrintStream(filename))
    {
      out.println(toString());
    }
  }

  public void load(String filename) {}
  public void load(URL url) {}
}

// handles the responsibility of persisting objects
class Persistence
{
  public void saveToFile(Journal journal, 
    String filename, boolean overwrite) throws Exception
  {
    if (overwrite || new File(filename).exists())
      try (PrintStream out = new PrintStream(filename)) {
        out.println(journal.toString());
      }
  }

  public void load(Journal journal, String filename) {}
  public void load(Journal journal, URL url) {}
}

/*class SRPDemo
{
  public static void main(String[] args) throws Exception
  {
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
}*/