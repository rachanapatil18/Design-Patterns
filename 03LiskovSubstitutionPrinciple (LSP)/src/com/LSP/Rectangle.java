package com.LSP;

public class Rectangle {

	protected int width, height;
	
	public Rectangle(){
	}
	
	public Rectangle(int width, int height){
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Rectangle {"
				+ "width=" +width +
				", Height=" +height +"}";
	}

	public int getArea(){
		return width*height;
	}
}

class Square extends Rectangle{
	
	public Square() {
	}
	
	public Square(int size){
		width = height = size;
	}
	
	@Override
	public void setWidth(int width) {
		super.setWidth(width);
		super.setHeight(width);
	}
	
	@Override
	public void setHeight(int height) {
		super.setWidth(height);
		super.setHeight(height);
	}
	
	public boolean isSquare(){
		return width == height;
	}
}

class RectangleFactory{
	public static Rectangle newRectangle(int width, int height){
		return new Rectangle(width, height);
	}
	
	public static Rectangle newSquare(int side){
		return new Rectangle(side, side);
	}
}
