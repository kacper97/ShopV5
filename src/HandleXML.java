import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;

public class HandleXML {

	public static void write(ArrayList<Product> products, String filename) throws Exception{
		XMLEncoder encoder = 
				new XMLEncoder(
						new BufferedOutputStream(
							new FileOutputStream(filename)));
		encoder.writeObject(products);
		encoder.close();						
	}
	
	public static ArrayList<Product> read(String filename) throws Exception{
		XMLDecoder decoder =
				new XMLDecoder(new BufferedInputStream(
						new FileInputStream(filename)));
		ArrayList<Product> products = (ArrayList<Product>) decoder.readObject();
		decoder.close();
		return products;
	}
}
