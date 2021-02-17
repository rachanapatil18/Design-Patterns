// A. High level modules should not depend on low level module
// both should depend on abstraction

// B. Abstractions should not depend on details
//Details should depend on abstractions


package com.dip;

public class DemoDIP {

	public static void main(String[] args) {

		
		Person parent = new Person("John");
		Person child1 = new Person("Chris");
		Person child2 = new Person("Matt");
		
		Relationships relationships = new Relationships();
		relationships.addParentAndChild(parent, child1);
		relationships.addParentAndChild(parent, child2);
		
		new Research(relationships);
	}

}
