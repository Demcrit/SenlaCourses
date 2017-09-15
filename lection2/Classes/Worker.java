import java.sql.Date;

public class Worker extends Man {
String position;
Idcard card;
Instruments instrument;

public Worker(String name,String surname,int age,String position,
		Idcard card,Instruments instrument){
	super(name,surname,age);
	this.position = position;
	this.card = card;
	this.instrument=instrument; 
	}

public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public Idcard getCard() {
	return card;
}
public void setCard(Idcard card) {
	this.card = card;
}
public Instruments getInstrument() {
	return instrument;
}
public void setInstrument(Instruments instrument) {
	this.instrument = instrument;
}

@Override
public String toString() {
		return "Name: " + super.name + " Surname: " + super.surname +" Age: "+
        super.age + " Position: " + this.position +" Card: " + this.card + " Instrument: " + this.instrument;
}

}
