package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class serializing {
	public static void main(String[] args) {
		String fileName = "myBinaryFile.bin";
		Person person = new Person("Alen", 254);
		writeBinary(person, fileName);
		
		System.out.println("write done");
		Person readPearson = (Person) readBinary(fileName);
		System.out.println(readPearson);
	}

	private static void writeBinary(Object object, String fileName) {

		ObjectOutputStream os = null;

		try (FileOutputStream fs = new FileOutputStream(fileName)) {
			os = new ObjectOutputStream(fs);
			os.writeObject(object);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static Object readBinary(String fileName) {
		ObjectInputStream os = null;
		Object object = null;

		try (FileInputStream fs = new FileInputStream(fileName)) {
			os = new ObjectInputStream(fs);
			object = os.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return object;
	}
}