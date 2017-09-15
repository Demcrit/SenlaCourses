import java.sql.Date;

public class Man {

protected  String name;
protected  String surname;
protected  int age;

Man(String name,String surname,int age)
{
this.name= name;
this.surname = surname;
this.age = age;
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
public int getbirthdate(){
return this.age;
}
public void setburthdate(Date birthdate){
this.age = age;
}
}
