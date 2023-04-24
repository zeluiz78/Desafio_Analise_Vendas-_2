package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Map<String, Double> mapSeller = new TreeMap<>();
		
		System.out.print("Entre o caminho do arquivo: ");
		String path = sc.nextLine();
		
		//D:\workplace\desafioAnaliseVendas2\desafioAnaliseVendas2\in.csv
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String seller = fields[2];
				double total = Double.parseDouble(fields[4]);
				
				if (mapSeller.containsKey(seller)) {
					double sum = mapSeller.get(seller);
					mapSeller.put(seller, total + sum);
				}
				else {
					mapSeller.put(seller, total);
				}
				
				line = br.readLine();
			}
			
			System.out.println();
			System.out.println("Total de vendas por vendedor:");
			for (String key : mapSeller.keySet()) {
				System.out.println(key + ": " + String.format("%.2f", mapSeller.get(key)));
			}	
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			sc.close();
		}
	}
}
