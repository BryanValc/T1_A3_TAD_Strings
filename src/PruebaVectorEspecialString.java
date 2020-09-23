import java.util.Arrays;
import java.util.Scanner;

class VectorEspecialString {
	
	Scanner input = new Scanner(System.in);
	private String palabras[];
	
	public VectorEspecialString() {
		this.palabras = null;
	}
	public VectorEspecialString(String[] palabras) {
		this.palabras = palabras;
	}
	public String[] getPalabras() {
		return palabras;
	}
	public void setPalabras(String[] palabras) {
		this.palabras = palabras;
	}
	
	
	public void mostrarCadenaInvertida() {
		String temp[]= this.getPalabras();
		boolean err=false;
		do {
			try {
				for (int i = temp.length-1; i > -1; i--) {
					for (int j = temp[i].length()-1; j > -1 ; j--) {
						System.out.print(temp[i].charAt(j));
					}
					System.out.print("	");
					err=false;
				}
			} catch (java.lang.NullPointerException e) {
				System.out.println("no hay nada, ingrese datos por favor");
				err=true;
			}
		} while (err);
		System.out.println();
	}
	
	public void agregarCaracterPosicionEspecifica(int sub, int pos, char chr) {
		sub=sub-1;
		pos=pos-1;
		String palabras[]=this.getPalabras();
		while(sub>=palabras.length) {
			System.out.println("subcadena fuera del rango, ingrese otro indice para la subcadena: ");
			sub=this.validacionNatural()-1;
		}
		String palabra=palabras[sub];
		while(pos>palabra.length()) {
			System.out.println("caracter fuera del rango, ingrese otro indice para el caracter: ");
			pos=this.validacionNatural()-1;
		}
		if(pos==0) {
			palabra=chr+palabra;
		}else if(pos==palabra.length()) {
			palabra=palabra+chr;
		}else {
			palabra=palabra.substring(0,pos)+chr+palabra.substring(pos);
		}
		palabras[sub]=palabra;
		this.setPalabras(palabras);	
	}
	public void eliminarCaracterPosicionEspecifica(int sub, int pos) {
		sub=sub-1;
		pos=pos-1;
		String palabras[]=this.getPalabras();
		while(sub>=palabras.length) {
			System.out.println("subcadena fuera del rango, ingrese otro indice para la subcadena: ");
			sub=this.validacionNatural()-1;
		}
		String palabra=palabras[sub];
		while(pos>=palabra.length()) {
			System.out.println("caracter fuera del rango, ingrese otro indice para el caracter: ");
			pos=this.validacionNatural()-1;
		}
		if(pos==0) {
			palabra=palabra.substring(1);
		}else if(pos==palabra.length()) {
			palabra=palabra.substring(0, palabra.length()-2);
		}else {
			palabra=palabra.substring(0,pos-1)+palabra.substring(pos);
		}
		palabras[sub]=palabra;
		this.setPalabras(palabras);	
		
	}
	public void agregarSubcadenaPosicionEspecifica(int sub, String str) {
		sub=sub-1;
		String palabras[]= Arrays.copyOf(this.getPalabras(), this.getPalabras().length + 1);
		while(sub>palabras.length-1) {
			System.out.println("subcadena fuera del rango, ingrese otro indice para la subcadena: ");
			sub=this.validacionNatural()-1;
		}
		if(sub==0) {
			for (int i = palabras.length-1; i > 0; i--) {
				palabras[i]=palabras[i-1];
			}
			palabras[0]=str;
		}else if(sub==palabras.length-1) {
			palabras[palabras.length-1]=str;
		}else {
			for (int i = palabras.length-1; i > sub; i--) {
				palabras[i]=palabras[i-1];
			}
			palabras[sub]=str;
		}
		this.setPalabras(palabras);	
		
	}
	public void eliminarSubcadenaPosicionEspecifica(int sub) {
		
	}

	@Override
	public String toString() {
		return "VectorEspecialString [palabras=" + Arrays.toString(this.getPalabras()) + "]";
	}
	public int validacionNatural() {
		int ret = 0;
		boolean err = false;
		do {
			try {
				ret = input.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println("entrada no valida, intente de nuevo:");
				input.nextLine();
				err=true;
				continue;
			}
			if (ret>-1) {
				err=false;
			}else {
				System.out.println("solo números naturales");
				err=true;
			}
		}while(err);
		return ret;
	}
	
}


public class PruebaVectorEspecialString {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String nombres[]= {"bryan", "cesar", "ruby", "denise"};
		VectorEspecialString ves0 = new VectorEspecialString(nombres);
		
		ves0.mostrarCadenaInvertida();

	}

}
