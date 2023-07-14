import org.hibernate.*;
import org.hibernate.cfg.*;

class Employee
{
private int id;
private String name;

Employee()		//called as default constructor
{


}
public Employee(int id,String name)
{
this.id=id;
this.name=name;
}
public String toString()
{
	return id+" " +name ;
}

public void setId(int id)
{
	this.id = id;
}
public  int getId()
{
	return id ;
}

public void setName(String name )
{
	this.name =name ;
}
public String getName()
{
	return name ;
}
}