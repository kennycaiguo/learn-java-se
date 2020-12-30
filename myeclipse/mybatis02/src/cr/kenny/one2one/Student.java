package cr.kenny.one2one;

public class Student {
   private Integer id;
   private String name;
   private Card card;//关联属性
   
   public Student(){}

public Student(Integer id, String name, Card card) {
	 
	this.id = id;
	this.name = name;
	this.card = card;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Card getCard() {
	return card;
}

public void setCard(Card card) {
	this.card = card;
}

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", card=" + card + "]";
}
   
}
