class Person{
	//Address
	
	public String streetAddress, postcode, city;
	public String companyName, position;
	public int annualIncome;
	
	@Override
	  public String toString()
	  {
	    return "Person{" +
	      "streetAddress='" + streetAddress + '\'' +
	      ", postcode='" + postcode + '\'' +
	      ", city='" + city + '\'' +
	      ", companyName='" + companyName + '\'' +
	      ", position='" + position + '\'' +
	      ", annualIncome=" + annualIncome +
	      '}';
	  }

	
}


//builder facade

class PersonBuilder{
	protected Person person = new Person();
	
	public PersonAddressBuilder lives(){
		return new PersonAddressBuilder(person);
	}
	public PersonJobBuilder works()
	  {
	    return new PersonJobBuilder(person);
	  }
	
	public PersonJobBuilder jobBuilder(){
		return new PersonJobBuilder(person);
	}
	public Person build()
	{
		return person;
	}
}

class PersonAddressBuilder extends PersonBuilder{
	public PersonAddressBuilder(Person person){
		this.person = person;
	}
	
	public PersonAddressBuilder at(String streetAddress){
		person.streetAddress = streetAddress;
		return this;
	}
	  public PersonAddressBuilder withPostcode(String postcode)
	  {
	    person.postcode = postcode;
	    return this;
	  }

	  public PersonAddressBuilder in(String city)
	  {
	    person.city = city;
	    return this;
	  }
	
}

class PersonJobBuilder extends PersonBuilder
{
  public PersonJobBuilder(Person person)
  {
    this.person = person;
  }

  public PersonJobBuilder at(String companyName)
  {
    person.companyName = companyName;
    return this;
  }

  public PersonJobBuilder asA(String position)
  {
    person.position = position;
    return this;
  }

  public PersonJobBuilder earning(int annualIncome)
  {
    person.annualIncome = annualIncome;
    return this;
  }
}



public class FacetedDemo {

	public static void main(String[] args) {

		
		PersonBuilder personBuilder = new PersonBuilder();
		Person person = personBuilder
				.lives()
				.at("123 area")
				.in("Pune")
				.withPostcode("123456")
				.works()
				.at("abc")
				.asA("Developer")
				.earning(100).build();
		System.out.println(person);
				
	}

}
