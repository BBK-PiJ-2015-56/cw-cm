public class ContactImpl implements Contact{
	int id;
	String name;
	String notes;
	
	/** 
	*   A constructor when the user does not have any 
	*   notes about the contact when they are created.
	*/
	public ContactImpl(int id , String name){
		this.id = id;
		this.name = name;
		notes = "";
	}
	
	/** 
	* A constructor that takes a third argument for notes
	* that the user wishes to add upon creation of the contact
	*/
	public ContactImpl(int id , String name , String notes){
		this.id = id;
		this.name = name;
		this.notes = notes;
	}
	
	/**
	* @see Contact
	*/
	public int getId(){
		return id;
	}
	/**
	* @see Contact
	*/
	
	public String getName(){
		return name;
	}
	/**
	* @see Contact
	*/
	public String getNotes(){
			return notes;
	}
	/**
	* @see Contact
	*/
	public void addNotes(String note){
		this.notes += note;
	}
	
}