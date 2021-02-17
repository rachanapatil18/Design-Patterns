package com.LSP;

public class LSPDemo {

	public static void main(String[] args) {
		
		Rectangle r = new Rectangle(2,3);
		useIt(r);
		
		Rectangle sq = new Square();
		sq.setWidth(5);
		useIt(sq);
	}
	
	static void useIt(Rectangle r){
		int width = r.getWidth();
		r.setHeight(10); // area = width *10;
		System.out.println("Expected area of "+(width*10) + ", got "+r.getArea());
	}

}
