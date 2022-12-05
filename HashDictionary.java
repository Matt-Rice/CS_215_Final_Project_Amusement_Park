 	import java.util.HashMap; 
 	import java.io.IOException;
 	import java.io.FileReader;
 	import java.io.File;
 	import java.util.Scanner;
	/**
	 * @author Matt Rice
	 * @version 11-10-22
	 * Class to read a dictionary file and implement a hash map
	 * HashDictionary.java
	 * Fall 2022
	 */
	public class HashDictionary  {
		//Instance variable
		HashMap<String , String> dictionary;
		
		/**
		 * Creates a constructor that will use a hashmap to implement a dictionary
		 */
		public HashDictionary() {
			 dictionary = new HashMap<String , String>();
		 }//end ArchaicWordDictionary
		
		/**
		 * Fills the dictionary with the contents of the file that is entered in the path
		 * @param path the file path of the file to be read
		 * @throws IOException will be thrown if the file path is not found
		 * @returns void
		 */
		public void fillDictionary(String path) throws IOException{
			File infile = new File(path);
			Scanner scan = new Scanner(new FileReader(infile));
			
			while(scan.hasNext()) {
				 String wordAndDef = scan.nextLine();
				 int tabIndex = 0;
				 tabIndex = wordAndDef.indexOf('\t');
				 String key = wordAndDef.substring(0, tabIndex);
				 String value = wordAndDef.substring(tabIndex+1);
				 dictionary.put(key, value);
			}//end while that puts keys and values into the hashmap
		}//end fillDictionary
		
		/**
		 * Returns the value stored at the key value
		 * @param key that will be used to get the definition
		 * @return the definition stored at the key
		 */
		public String getDefinition(String key) {
			return dictionary.get(key);
		}//end getDefinition
		
		public static void main(String[]args) throws IOException {
			HashDictionary firstNames = new HashDictionary();
			firstNames.fillDictionary("CommonFirstNames.txt");
			System.out.println(firstNames.getDefinition("30"));
		}
}
