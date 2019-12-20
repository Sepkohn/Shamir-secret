package main;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Secret {
	Scanner scan = new Scanner(System.in);
	
	private BigInteger secret;
	private BigInteger prime;
	private int minParts;
	private int parts;
	private int[] xparts;
	private int[] yparts;
	private BigInteger gcd; 
	
	public void setSecret() {
		System.out.print("Indiquez le nombre de bits : ");
		int nbrebits = scan.nextInt();
		System.out.print("Indiquez le nombre parts minimum : ");
		this.minParts = scan.nextInt();
		System.out.print("Indiquez le nombre de parts voulues : ");
		this.parts = scan.nextInt();
		
		setSecret(nbrebits, minParts, parts);
	}
	private void setSecret(int nbrebits, int minParts, int parts) {
		
		//Génération d'un secret et du nombre premier
		generateRandomKey(nbrebits/8);
		
		//je génère une part x
		xparts = new int[parts];
		for(int i = 0;i<xparts.length;i++ ) {
			xparts[i]=i+1;
		}
		
		//Je trouve le Y
		yparts = new int[parts];
		
		
		
		
	}
	

/**
		 *	INPUT a, b element de Z avec a >= b
		 *	OUTPUT g = gcd(a, b)
		 */
		public static BigInteger multipleInverse(BigInteger a, BigInteger b)
		{
			ArrayList<BigInteger> r = new ArrayList<>();
			ArrayList<BigInteger> q = new ArrayList<>();
			ArrayList<BigInteger> x = new ArrayList<>();
			ArrayList<BigInteger> y = new ArrayList<>();

			r.add(a);
			r.add(b);

			x.add(BigInteger.valueOf(1));
			x.add(BigInteger.ZERO);

			q.add(BigInteger.ZERO);
			y.add(BigInteger.ZERO);
			y.add(BigInteger.valueOf(1));

			int i = 0;

			do {
				i++;

				q.add(i, r.get(i-1).divide(r.get(i)));

				r.add(i+1, r.get(i-1).subtract(r.get(i).multiply(q.get(i))));

				x.add(i+1, x.get(i-1).subtract(x.get(i).multiply(q.get(i))));
				y.add(i+1, y.get(i-1).subtract(y.get(i).multiply(q.get(i))));

			}
			while (r.get(i+1).compareTo(BigInteger.ZERO) > 0) ;

			BigInteger multInverse = y.get(i);

			while (multInverse.compareTo(BigInteger.ZERO) < 0) {
				multInverse = multInverse.add(a);
			}

			return multInverse;
		}
		
	public void generateRandomKey(int byteLength) throws IllegalArgumentException {
			if (byteLength < 16 || byteLength > 512)
				throw new IllegalArgumentException("La clé doit être entre 16 et 512 bytes");

			SecureRandom random = new SecureRandom();
			byte bytes[] = new byte[byteLength]; // 128 bits are converted to 16 bytes;
			random.nextBytes(bytes);
			secret = new BigInteger(bytes);
			
			prime = BigInteger.probablePrime(byteLength*8, random);	
			
			
			
		
		}
	
	
	
}
