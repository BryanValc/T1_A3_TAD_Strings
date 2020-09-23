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
		}else if(pos==palabra.length()-1) {
			palabra=palabra.substring(0, palabra.length()-1);
		}else {
			palabra=palabra.substring(0,pos)+palabra.substring(pos+1);
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
		sub=sub-1;
		String palabras[]= Arrays.copyOf(this.getPalabras(), this.getPalabras().length + 1);
		while(sub>=palabras.length-1) {
			System.out.println("subcadena fuera del rango, ingrese otro indice para la subcadena: ");
			sub=this.validacionNatural()-1;
		}
		if(sub==0) {
			for (int i = 0; i < palabras.length-1; i++) {
				palabras[i]=palabras[i+1];
			}
		}else if(sub==palabras.length-1) {
		}else {
			for (int i = 0; i < palabras.length-1; i++) {
				palabras[i]=palabras[i];
				if(i>=sub) {
					palabras[i]=palabras[i+1];
				}
			}
		}
		String[] newArray = Arrays.copyOf(palabras, palabras.length-2);
		this.setPalabras(newArray);
		
	}
	public void camelCaseEspecial() {
		String str="";
		String palabras[]=this.getPalabras();
		for (int i = 0; i < palabras.length; i++) {
			str=str+palabras[i]+" ";
		}
		String strUp=str.toUpperCase();
		String strLo=str.toLowerCase();
		int j=0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)!=' ') {
				j++;
			}
			if(j%2!=0) {
				System.out.print(strUp.charAt(i));
			}else {
				System.out.print(strLo.charAt(i));
			}
		}
		System.out.println();
	}
	public void mostrarCapitalizado() {
		String palabras[]=this.getPalabras();
		for (int i = 0; i < palabras.length; i++) {
			System.out.print(palabras[i].toUpperCase().charAt(0));
			if (palabras[i].length()>1) {
				System.out.print(palabras[i].substring(1));
			}
			System.out.print(" ");
		}
		System.out.println();
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
			if (ret>0) {
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
		
		VectorEspecialString ves0 = new VectorEspecialString();
		boolean salir = false;
		byte opc = 0;
		
		System.out.println("tamaño del vector:");
		int sz=ves0.validacionNatural();
		String palabras[]=new String[sz];
		for (int i = 0; i < sz; i++) {
			System.out.println("elemento "+(i+1)+": ");
			palabras[i]=input.nextLine();
		}
		VectorEspecialString ve1 = new VectorEspecialString(palabras);
		
		do {
			System.out.println("1)Mostrar cadena invertida \n 2)Agregar caracter posicion especifica "
					+ "\n 3)Eliminar caracter posicion especifica \n 4)Agregar subcadena posicion especifica"
					+ "\n 5)Eliminar subcadena posicion especifica \n 6)CaMeL CaSe Especial "
					+ "\n 7)Mostrar capitalizado \n 8)Salir");
			opc=(byte) ves0.validacionNatural();
			
			switch (opc) {
			case 1:
				ve1.mostrarCadenaInvertida();break;
			case 2:
				System.out.println("indice de subcadena: ");
				int sub= ves0.validacionNatural();
				System.out.println("indice del caracter dentro de la subcadena: ");
				int pos= ves0.validacionNatural();
				System.out.println("caracter a ingresar: ");
				char chr = input.next().toLowerCase().charAt(0);
				ve1.agregarCaracterPosicionEspecifica(sub, pos, chr);break;
			case 3:
				System.out.println("indice de subcadena: ");
				int sub1= ves0.validacionNatural();
				System.out.println("indice del caracter dentro de la subcadena: ");
				int pos1= ves0.validacionNatural();
				ve1.eliminarCaracterPosicionEspecifica(sub1, pos1);break;
			case 4:
				System.out.println("indice de subcadena: ");
				int sub2= ves0.validacionNatural();
				System.out.println("subcadena a agregar: ");
				String str = input.nextLine().toLowerCase();
				ve1.agregarSubcadenaPosicionEspecifica(sub2, str);break;
			case 5:
				System.out.println("indice de subcadena: ");
				int sub3= ves0.validacionNatural();
				ve1.eliminarSubcadenaPosicionEspecifica(sub3);break;
			case 6:
				ve1.camelCaseEspecial();break;
			case 7:
				ve1.mostrarCapitalizado();break;
			case 8:
				salir=true;break;
			default:break;
			}
			
		} while (!salir);
		System.out.println("fin de la ejecución");

	}

}
