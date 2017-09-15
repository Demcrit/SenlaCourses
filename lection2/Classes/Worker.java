import java.sql.Date;

public class Worker extends Man {
String position;
Idcard card;
Instruments instrument;

public Worker(){
	System.out.println("This is class Worker");
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
}
