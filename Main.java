import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

class Main {

	private String nazwaDomu;
	private int liczbaKondygnacji;
	private double cena;
	private String lokalizacja;

	Main(String nazwaDomu, int liczbaKondygnacji, double cena, String lokalizacja){
		this.nazwaDomu = nazwaDomu;
		this.liczbaKondygnacji = liczbaKondygnacji;
		this.cena = cena;
		this.lokalizacja = lokalizacja;
	}

	public String getNazwaDomu(){return nazwaDomu;}
	public int getLiczbaKondygnacji(){return liczbaKondygnacji;}
	public double getCena(){return cena;}
	public String getLokalizacja(){return lokalizacja;}

	public void setNazwaDomu(String nazwaDomu){this.nazwaDomu = nazwaDomu;}
	public void setLiczbaKondygnacji(int liczbaKondygnacji){this.liczbaKondygnacji = liczbaKondygnacji;}
	public void setCena(double cena){this.cena = cena;}
	public void setLokalizacja(String lokalizacja){this.lokalizacja = lokalizacja;}

	public String toString(){
		return getNazwaDomu() + " " + getLiczbaKondygnacji() + " " + getCena() + " " + getLokalizacja();
	}
	public static void main(String[] args) {

		final Scanner sc = new Scanner(System.in);

		String fileName;
		RandomAccessFile file;
		
			while(true){
			try {
				System.out.print("File name: ");
				fileName = sc.nextLine();
				System.out.print("\n");
				file = new RandomAccessFile(fileName, "r");
				break;
			} catch (FileNotFoundException e) {
				System.out.println("-----Invalid input----- \n");
				continue;
			}
		}
		sc.close();

		ArrayList<Main> houses = new ArrayList<Main>();

		while(true){
			try {
				String nazwa = file.readLine();
				int kondygnacje = file.readInt();
				double koszt = file.readDouble();
				String lokalizacja = file.readLine();
				houses.add( new Main(nazwa, kondygnacje, koszt, lokalizacja));
			} catch(IOException e){
				break;
			}
		}
		System.out.println(houses.isEmpty());

	}


}
