import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BuilderDemo {
	
	public static void main(String[] args) {
		
	//	StringBuilder stringBuilder = new StringBuilder();
		//stringBuilder.append("foo").append("bar");//Fluent Interface will allow you very long chain
		// builder.addChild("Test", "Fluent").addChild("Test2", "Testfluent");
		HtmlBuilder builder = new HtmlBuilder("ul");
		builder.addChild("li", "hello");
        builder.addChild("li", "World");
		
		builder.addChildFluent("Test", "Fluent").addChildFluent("Test2", "Testfluent");
		System.out.println(builder);
		
		
		
	    // we want to build a simple HTML paragraph
		String hello = "Hello";
		System.out.println(hello);
		
		String [] words = {"Good", "morning"};
		
		StringBuilder sb = new StringBuilder();
		sb.append("<ul");
		for (String word : words) {
			sb.append(String.format("<li>%s</li>\n", word));
		}
		sb.append("</sb>");

		System.out.println(sb);

	}

}

class HtmlElement{
	
	public String name, text;
	public ArrayList<HtmlElement> elements = new ArrayList<>();
	private final int indentSize = 2;
	private final String newLine = System.lineSeparator();
	
	public HtmlElement(){
	}
	
	public HtmlElement(String name, String text){
		this.name = name;
		this.text = text;
	}
	
	private String toStringImpl(int indent){
		
		StringBuilder sb = new StringBuilder();
		String i = String.join("", Collections.nCopies(indent * indentSize, ""));
		sb.append(String.format("%s</%s>%s", i, name, newLine));
		if(text != null && !text.isEmpty()){
			sb.append(String.join("",	 Collections.nCopies(indentSize * (indent+1), "")))
			.append(text).append(newLine);
		}
		for (HtmlElement htmlElement : elements) 
			sb.append(htmlElement.toStringImpl(indent+1));
			sb.append(String.format("%s</%s>%s", i, name, newLine));
			return sb.toString();
	}
	@Override
	public String toString() {
		return toStringImpl(0);
	}
}


class HtmlBuilder{
	private String rootName;
	private HtmlElement  root = new HtmlElement();
	
	public HtmlBuilder(String rootName) {
		
		this.rootName = rootName;
		root.name = rootName;
	}
	
	public HtmlBuilder addChildFluent(String childName, String childText){
		
		HtmlElement htmlElement = new HtmlElement(childName, childText);
		root.elements.add(htmlElement);
		
		return this;
	}
	
	 // not fluent
	  public void addChild(String childName, String childText)
	  {
	    HtmlElement e = new HtmlElement(childName, childText);
	    root.elements.add(e);
	  }
	public void clear(){
		root = new HtmlElement();
		root.name = rootName;
	}
	
	@Override
	public String toString() {
		return root.toString();
	}
	
}

