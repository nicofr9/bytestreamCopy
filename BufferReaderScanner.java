package lavorareConiFile;
import java.io.*;
import java.util.Scanner;  

	/**
	 * @author nicolo.frongia
	 *questo programma crea un file di nome helloworld con l'input dell utente e se vuole fermarsi deve scrivere stop,
	 *dopodichè viene creata un altra copia del file tramite il bytestream 
	 *
	 */
	public class BufferReaderScanner{ 
		public static void main(String[] args) {
			writeSave();
			nicoRead();
			try {
				writeToOther();
			}
			catch (IOException e) {
					e.printStackTrace();
			}
		
		}
		private static void nicoRead() {
			System.out.println("now printing the results");
			try {
				FileReader reader = new FileReader("helloworld.txt");
				int data = reader.read();
				while (data != -1) { //restituisce il codice ascii della lettera che viene letta e per questo il while si occupa di ciclare tutti i caratteri 
					//finchè non trova -1 che non corrisponde a nessun codice ascii
					System.out.print((char)data);
					 data = reader.read();	
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public static void writeSave(){
			try {
				InputStreamReader r = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(r);
				FileWriter w = new FileWriter("helloworld.txt");
				System.out.println("write everything you want, \n instructions below ");
				while(true) {
					System.out.println("for stoping writing write stop then press enter");
					String data = br.readLine();
						if(data.equals("stop")) {
							break;
						}
					w.write(data + "\n");
					
				
				}
				
				System.out.println("writing inside helloworld.txt");
				w.close();
				r.close();
				br.close();
			} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public static void writeToOther() throws IOException {
			FileInputStream in = null;
			FileOutputStream out = null;
			try {
				in = new FileInputStream("helloworld.txt");
				out = new FileOutputStream("helloworld-copy.txt");
				int c;
				while((c = in.read()) != -1) {
					out.write((char)c);
				}
			} finally {
				System.out.println("file created ");
				if(in != null) {
					in.close();
				}
				if(out != null) {
					out.close();
				}
			}	
		}

	}