package com.dip;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.javatuples.Triplet;

public class Person {
	
	public String name;
	
	public Person(String name){
		this.name = name;
	}
}

class Relationships implements RelationshipBrowser{//low  level
	private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();
	
	public List<Triplet<Person, Relationship, Person>> getRelations() {
		return relations;
	}

	public void setRelations(List<Triplet<Person, Relationship, Person>> relations) {
		this.relations = relations;
	}

	public void addParentAndChild(Person parent, Person child){
		relations.add(new Triplet<>(parent, Relationship.PARENT, child));
		relations.add(new Triplet<>(child, Relationship.CHILD, parent));
		
	}

	@Override
	public List<Person> findAllChildren(String name) {
		
		return relations.stream().filter(x -> Objects.equals(x.getValue0().name, name)
				&& x.getValue1() == Relationship.PARENT)
				.map(Triplet::getValue2).collect(Collectors.toList());
	}
}


//Adding abstraction class for DIP

interface RelationshipBrowser{
	List<Person> findAllChildren(String name);
}

class Research{// high level
	/*public Research(Relationships relationships){
		List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
		
		relations.stream().filter(x -> x.getValue0().name.equals("John")
				&& x.getValue1() == Relationship.PARENT)
				.forEach(ch -> System.out.println("John has a child called"+ ch.getValue2().name));
	}*/
	
	
	public Research(RelationshipBrowser relationshipBrowser){
		List<Person> children = relationshipBrowser.findAllChildren("John");
		for (Person child : children) {
			System.out.println("John has a child called : "+child.name);
			
		}
	}
}