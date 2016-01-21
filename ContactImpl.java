/*
*@see Contact
*/
public class ContactImpl implements Contact{
	int id;
	String name;
	String notes;
	
	/** 
	*   A constructor when the user does not have any 
	*   notes about the contact when they are created.
	*/
	
	//note I would like to put the repeated code from botgh constructors into 
	// a helper method but can't as it is not defined in the interface.
	public ContactImpl(int id , String name){
		if(id <= 0){
			throw new IllegalArgumentException();
		}
		if(name == null){
			throw new NullPointerException();
		}
		else{
			this.id = id;
			this.name = name;
			notes = "";
		}
	}
	
	/** 
	* A constructor that takes a third argument for notes
	* that the user wishes to add upon creation of the contact
	*/
	public ContactImpl(int id , String name , String notes){
		if(id <= 0){
			throw new IllegalArgumentException();
		}
		else if(name == null){
			throw new NullPointerException();
		}
		else if(notes == null){
			throw new NullPointerException();
		}
		else{
			this.id = id;
			this.name = name;
			this.notes = notes;
		}
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