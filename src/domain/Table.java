package domain;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class Table {
	private static int size;
	private static Casillas[][] table;
	public Table(int percentage,int size) {
		this.size = size;
		table = new Casillas[size][size];
		try {
			createTable(percentage);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void createTable(int percentage) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		int numCasillasEspeciales = percentage/100;
		Random rand = new Random();
		String[] typesCasillas = {"Mortal","Saltarinas","SaltarinaInversa","Escalera","Serpiente"};
		int contador = 1;
		while(contador <= numCasillasEspeciales) {
			String type = typesCasillas[rand.nextInt(typesCasillas.length)];
			int i = rand.nextInt(size);
			int j = rand.nextInt(size);
			table[i][j] = (Casillas) Class.forName("Domain."+type).getConstructor(Integer.TYPE, Integer.TYPE).newInstance(i,j);
		}
		for(int i = 0;i<size;i++) {
			for(int j =0;j<size;j++) {
				if(table[i][j] == null) {
					table[i][j] = (Casillas) Class.forName("Domain.Normal").getConstructor(Integer.TYPE, Integer.TYPE).newInstance(i,j);
				}
			}
		}
	}
}
