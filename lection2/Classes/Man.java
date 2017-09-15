import java.sql.Date;

public class Man {

private String name;
private String surname;
private Date birthdate;


public Man ()
{
System.out.println("This is class Man");
}

public String getName(){
return this.name;
}
public void setName(String name){
this.name = name;
}
public String getsurname(){
return this.surname;
}
public void setsurname(String surname){
this.surname = surname;
}
public Date getbirthdate(){
return this.birthdate;
}
public void setburthdate(Date birthdate){
this.birthdate = birthdate;
}
}
