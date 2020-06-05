import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

class Main {

	private String nazwaDomu;
	private int liczbaKondygnacji;
	private double cena;
	private String lokalizacja;

	Main(String nazwaDomu, int liczbaKondygnacji, double cena, String lokalizacja) {
		this.nazwaDomu = nazwaDomu;
		this.liczbaKondygnacji = liczbaKondygnacji;
		this.cena = cena;
		this.lokalizacja = lokalizacja;
	}

	public String getNazwaDomu() {
		return nazwaDomu;
	}

	public int getLiczbaKondygnacji() {
		return liczbaKondygnacji;
	}

	public double getCena() {
		return cena;
	}

	public String getLokalizacja() {
		return lokalizacja;
	}

	public void setNazwaDomu(String nazwaDomu) {
		this.nazwaDomu = nazwaDomu;
	}

	public void setLiczbaKondygnacji(int liczbaKondygnacji) {
		this.liczbaKondygnacji = liczbaKondygnacji;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public void setLokalizacja(String lokalizacja) {
		this.lokalizacja = lokalizacja;
	}

	public String toString() {
		return getNazwaDomu() + "\n" + getLiczbaKondygnacji() + "\n" + getCena() + "\n" + getLokalizacja() + "\n";
	}

	public static void main(String[] args) throws IOException {

		final Scanner sc = new Scanner(System.in);
		Scanner fileSc;
		File file;
		String fileName;
		while(true)
		try {
			System.out.print("File name: ");
			fileName = sc.nextLine();
			System.out.print("\n");
			file = new File(fileName);
			fileSc = new Scanner(file);
			break;
		} catch(FileNotFoundException e){
			continue;
		}

		sc.close();
		ArrayList<Main> houses = new ArrayList<Main>();

		while(fileSc.hasNextLine()){
			String nazwa = fileSc.nextLine();
			int kondygnacje = Integer.parseInt(fileSc.nextLine());
			double koszt = Double.parseDouble(fileSc.nextLine());
			String lokalizacja = fileSc.nextLine();
			houses.add( new Main(nazwa, kondygnacje, koszt, lokalizacja));
		}
		fileSc.close();
		for(Main house : houses){
			if(house.getLokalizacja().equals("wies") && house.getLiczbaKondygnacji() == 1){ house.setCena(house.getCena()*0.9); }
			//System.out.println(house);
		}
		
		FileWriter fileWr = new FileWriter(file, false);
		for(Main house : houses){
			fileWr.write(house.getNazwaDomu()+"\n");
			fileWr.write(Integer.toString(house.getLiczbaKondygnacji())+"\n");
			fileWr.write(Double.toString(house.getCena())+"\n");
			fileWr.write(house.getLokalizacja()+"\n");
		}
		fileWr.close();
	}


}
