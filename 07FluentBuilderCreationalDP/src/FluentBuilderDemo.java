
class Person {
	
	String name;
	String position;
	
	@Override
	public String toString() {
		return "Person{"+ "name= "+name +'\'' +",Position='"+position +'\''+'}';
	}

}

class PersonBuilder<SELF extends PersonBuilder<SELF>>{
	protected Person person = new Person();
	
	public SELF withName(String name){
		person.name = name;
		return self();
	}
	
	public Person build(){
		return person;
	}
	
	protected SELF self(){
		return (SELF)this;
	}
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{
	public EmployeeBuilder worksAs(String position)
	  {
	    person.position = position;
	    return self();
	  }

	  @Override
	  protected EmployeeBuilder self()
	  {
	    return this;
	  }
}
public class FluentBuilderDemo {

		
		public static void main(String [] args){
			
			EmployeeBuilder employeeBuilder = new EmployeeBuilder();
			employeeBuilder.withName("Rachana")
			.worksAs("Developer");
			
			System.out.println(employeeBuilder.build());
		}
}


