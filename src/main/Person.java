package main;

import java.io.Serializable;

public class Person implements Serializable{
	// This UID is to check that we deserialize to the exact same class that was initially used for serializing
	// So if we first write to a binary file and then change the UID, we cannot read to this class any more.
	// notice that it has nothing to do with encription, and this UID is accesible.
	private static final long serialVersionUID = -5009590296174283177L;
	private String name;
	private int id;
	
	Person(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, ID: %d\r\n", name, id);
	}

}
