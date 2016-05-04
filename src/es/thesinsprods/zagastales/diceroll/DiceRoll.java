package es.thesinsprods.zagastales.diceroll;

import java.util.Random;

public class DiceRoll {
	
	public static int LanzaDadoAleatorio20(){


		int resultado=  (int)Math.floor(Math.random()*20+1); 
		    
		     return resultado; 
			
		}
	
	public static int LanzaDadoAleatorio12(){


		int resultado=  (int)Math.floor(Math.random()*12+1); 
		    
		     return resultado; 
			
		}
	public static int LanzaDadoAleatorio10(){


		int resultado=  (int)Math.floor(Math.random()*10+1); 
		    
		     return resultado; 
			
		}
	public static int LanzaDadoAleatorio8(){


		int resultado=  (int)Math.floor(Math.random()*8+1); 
		    
		     return resultado; 
			
		}
	public static int LanzaDadoAleatorio6(){


		int resultado=  (int)Math.floor(Math.random()*6+1); 
		    
		     return resultado; 
			
		}
	public static int LanzaDadoAleatorio4(){


		int resultado=  (int)Math.floor(Math.random()*4+1); 
		    
		     return resultado; 
			
		}

public static int ComprobarTirada(int tirada,int atributo){
	
	int modificador=0;

int [][] tabla=new int[][]{
	{1,0,0,0,2,3,-1,-1,-1,-1,-1,-1,-1,-1,-2,-2,-2,-2,-3,-3},
	{1,0,0,0,0,2,3,-1,-1,-1,-1,-1,-1,-1,-1,-2,-2,-2,-2,-3},
	{1,0,0,0,0,0,2,3,-1,-1,-1,-1,-1,-1,-1,-1,-2,-2,-2,-3},
	{1,0,0,0,0,0,0,2,3,-1,-1,-1,-1,-1,-1,-1,-1,-2,-2,-3},
	{2,1,0,0,0,0,0,1,2,3,-1,-1,-1,-1,-1,-1,-1,-1,-2,-3},
	{2,1,0,0,0,0,0,0,1,2,3,-1,-1,-1,-1,-1,-1,-1,-2,-3},
	{2,1,0,0,0,0,0,0,0,1,2,3,-1,-1,-1,-1,-1,-1,-2,-3},
	{2,1,1,0,0,0,0,0,0,0,1,2,3,-1,-1,-1,-1,-1,-2,-3},
	{2,1,1,0,0,0,0,0,0,0,0,1,2,3,-1,-1,-1,-1,-2,-3},
	{2,1,1,0,0,0,0,0,0,0,0,1,1,2,3,-1,-1,-1,-2,-3},
	{2,1,1,0,0,0,0,0,0,0,0,0,1,1,2,3,-1,-1,-2,-3},
	{2,1,1,0,0,0,0,0,0,0,0,0,0,1,1,2,3,-1,-2,-3},
	{2,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,2,3,-1,-2},
	{2,2,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,2,3,-1},
	{2,2,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,2,2,3}
	
};

modificador= tabla[atributo-6][tirada-1];

return modificador;
	
}

public static String EnfrentarTirada(int tirada1, int atributo1, int tirada2, int atributo2, int habilidad1, int habilidad2,int modextra){
	
int total=0;
String resultado="";
total=ComprobarTirada(tirada1,atributo1)-ComprobarTirada(tirada2, atributo2)+modextra;
String [][] enfrentadas=new String [][] {
		{"Desastre","Desastre","Desastre","Desastre","Desastre","Desastre"},
		{"Torpe","Desastre","Desastre","Desastre","Desastre","Desastre"},
		{"Fracaso","Torpe","Desastre","Desastre","Desastre","Desastre"},
		{"Correcto","Fracaso","Torpe","Desastre","Desastre","Desastre"},
		{"Bien","Correcto","Fracaso","Torpe","Desastre","Desastre"},
		{"Excelente","Bien","Correcto","Fracaso","Torpe","Desastre"},	
		{"Critico","Excelente","Bien","Correcto","Fracaso","Torpe"},
		{"Critico","Critico","Excelente","Bien","Correcto","Fracaso"},
		{"Critico","Critico","Critico","Excelente","Bien","Correcto"},
		{"Critico","Critico","Critico","Critico","Excelente","Bien"},
		{"Critico","Critico","Critico","Critico","Critico","Excelente"},
		{"Critico","Critico","Critico","Critico","Critico","Critico"}
};

if(habilidad2==0){
	if(habilidad1==0){
		if(3+total<0){
			resultado=enfrentadas[0][0];
		}
		else if(3+total>11){
			resultado=enfrentadas[11][0];
		}
		else {resultado=enfrentadas[3+total][0];}
	}
	if(habilidad1==1){
		if(4+total<0){
			resultado=enfrentadas[0][0];
		}
		else if(4+total>11){
			resultado=enfrentadas[11][0];
		}
		else {resultado=enfrentadas[4+total][0];}
	}
	if(habilidad1==2){
		if(5+total<0){
			resultado=enfrentadas[0][0];
		}
		else if(5+total>11){
			resultado=enfrentadas[11][0];
		}
		else {resultado=enfrentadas[5+total][0];}
	}
	if(habilidad1==3){
		if(6+total<0){
			resultado=enfrentadas[0][0];
		}
		else if(6+total>11){
			resultado=enfrentadas[11][0];
		}
		else {resultado=enfrentadas[6+total][0];}
	}
	if(habilidad1==4){
		if(7+total<0){
			resultado=enfrentadas[0][0];
		}
		else if(7+total>11){
			resultado=enfrentadas[11][0];
		}
		else {resultado=enfrentadas[7+total][0];}
	}
	if(habilidad1==5){
		if(8+total<0){
			resultado=enfrentadas[0][0];
		}
		else if(8+total>11){
			resultado=enfrentadas[11][0];
		}
		else {resultado=enfrentadas[8+total][0];}
	}
}

if(habilidad2==1){
	if(habilidad1==0){
		if(3+total<0){
			resultado=enfrentadas[0][1];
		}
		else if(3+total>11){
			resultado=enfrentadas[11][1];
		}
		else {resultado=enfrentadas[3+total][1];}
	}
	if(habilidad1==1){
		if(4+total<0){
			resultado=enfrentadas[0][1];
		}
		else if(4+total>11){
			resultado=enfrentadas[11][1];
		}
		else {resultado=enfrentadas[4+total][1];}
	}
	if(habilidad1==2){
		if(5+total<0){
			resultado=enfrentadas[0][1];
		}
		else if(5+total>11){
			resultado=enfrentadas[11][1];
		}
		else {resultado=enfrentadas[5+total][1];}
	}
	if(habilidad1==3){
		if(6+total<0){
			resultado=enfrentadas[0][1];
		}
		else if(6+total>11){
			resultado=enfrentadas[11][1];
		}
		else {resultado=enfrentadas[6+total][1];}
	}
	if(habilidad1==4){
		if(7+total<0){
			resultado=enfrentadas[0][1];
		}
		else if(7+total>11){
			resultado=enfrentadas[11][1];
		}
		else {resultado=enfrentadas[7+total][1];}
	}
	if(habilidad1==5){
		if(5+total<0){
			resultado=enfrentadas[0][1];
		}
		else if(5+total>11){
			resultado=enfrentadas[11][1];
		}
		else {resultado=enfrentadas[5+total][1];}
	}
}

if(habilidad2==2){
	if(habilidad1==0){
		if(3+total<0){
			resultado=enfrentadas[0][2];
		}
		else if(3+total>11){
			resultado=enfrentadas[11][2];
		}
		else {resultado=enfrentadas[3+total][2];}
	}
	if(habilidad1==1){
		if(4+total<0){
			resultado=enfrentadas[0][2];
		}
		else if(4+total>11){
			resultado=enfrentadas[11][2];
		}
		else {resultado=enfrentadas[4+total][2];}

	}
	if(habilidad1==2){
		if(5+total<0){
			resultado=enfrentadas[0][2];
		}
		else if(5+total>11){
			resultado=enfrentadas[11][2];
		}
		else {resultado=enfrentadas[5+total][2];}
}
	if(habilidad1==3){
		if(6+total<0){
			resultado=enfrentadas[0][2];
		}
		else if(6+total>11){
			resultado=enfrentadas[11][2];
		}
		else {resultado=enfrentadas[6+total][2];}
}
	if(habilidad1==4){
		if(7+total<0){
			resultado=enfrentadas[0][2];
		}
		else if(7+total>11){
			resultado=enfrentadas[11][2];
		}
		else {resultado=enfrentadas[7+total][2];}
	
	}
	if(habilidad1==5){
		if(8+total<0){
			resultado=enfrentadas[0][2];
		}
		else if(8+total>11){
			resultado=enfrentadas[11][2];
		}
		else {resultado=enfrentadas[8+total][2];}

	}
}

if(habilidad2==3){
	if(habilidad1==0){
		if(3+total<0){
			resultado=enfrentadas[0][3];
		}
		else if(3+total>11){
			resultado=enfrentadas[11][3];
		}
		else {resultado=enfrentadas[3+total][3];}

	}
	if(habilidad1==1){
		if(4+total<0){
			resultado=enfrentadas[0][3];
		}
		else if(4+total>11){
			resultado=enfrentadas[11][3];
		}
		else {resultado=enfrentadas[4+total][3];}
	}
	if(habilidad1==2){
		if(5+total<0){
			resultado=enfrentadas[0][3];
		}
		else if(5+total>11){
			resultado=enfrentadas[11][3];
		}
		else {resultado=enfrentadas[5+total][3];}
	}
	if(habilidad1==3){
		if(6+total<0){
			resultado=enfrentadas[0][3];
		}
		else if(6+total>11){
			resultado=enfrentadas[11][3];
		}
		else {resultado=enfrentadas[6+total][3];}
	}
	if(habilidad1==4){
		if(7+total<0){
			resultado=enfrentadas[0][3];
		}
		else if(7+total>11){
			resultado=enfrentadas[11][3];
		}
		else {resultado=enfrentadas[7+total][3];}
		}
	if(habilidad1==5){
		if(8+total<0){
			resultado=enfrentadas[0][3];
		}
		else if(8+total>11){
			resultado=enfrentadas[11][3];
		}
		else {resultado=enfrentadas[8+total][3];}
	}
}

if(habilidad2==4){
	if(habilidad1==0){
		if(3+total<0){
			resultado=enfrentadas[0][4];
		}
		else if(3+total>11){
			resultado=enfrentadas[11][4];
		}
		else {resultado=enfrentadas[3+total][4];}
	}
	if(habilidad1==1){
		if(4+total<0){
			resultado=enfrentadas[0][4];
		}
		else if(4+total>11){
			resultado=enfrentadas[11][4];
		}
		else {resultado=enfrentadas[4+total][4];}
	
	}
	if(habilidad1==2){
		if(5+total<0){
			resultado=enfrentadas[0][4];
		}
		else if(5+total>11){
			resultado=enfrentadas[11][4];
		}
		else {resultado=enfrentadas[5+total][4];}
		}
	if(habilidad1==3){
		if(6+total<0){
			resultado=enfrentadas[0][4];
		}
		else if(6+total>11){
			resultado=enfrentadas[11][4];
		}
		else {resultado=enfrentadas[6+total][4];}
	
	}
	if(habilidad1==4){
		if(7+total<0){
			resultado=enfrentadas[0][4];
		}
		else if(7+total>11){
			resultado=enfrentadas[11][4];
		}
		else {resultado=enfrentadas[7+total][4];}
	
	}
	if(habilidad1==5){
		if(8+total<0){
			resultado=enfrentadas[0][4];
		}
		else if(8+total>11){
			resultado=enfrentadas[11][4];
		}
		else {resultado=enfrentadas[8+total][4];}
	
	}
}

if(habilidad2==5){
	if(habilidad1==0){
		if(3+total<0){
			resultado=enfrentadas[0][5];
		}
		else if(3+total>11){
			resultado=enfrentadas[11][5];
		}
		else {resultado=enfrentadas[3+total][5];}
	
	}
	if(habilidad1==1){
		if(4+total<0){
			resultado=enfrentadas[0][5];
		}
		else if(4+total>11){
			resultado=enfrentadas[11][5];
		}
		else {resultado=enfrentadas[4+total][5];}
	}
	if(habilidad1==2){
		if(5+total<0){
			resultado=enfrentadas[0][5];
		}
		else if(5+total>11){
			resultado=enfrentadas[11][5];
		}
		else {resultado=enfrentadas[5+total][5];}
	}
	if(habilidad1==3){
		if(6+total<0){
			resultado=enfrentadas[0][5];
		}
		else if(6+total>11){
			resultado=enfrentadas[11][5];
		}
		else {resultado=enfrentadas[6+total][5];}
	}
	if(habilidad1==4){
		if(7+total<0){
			resultado=enfrentadas[0][5];
		}
		else if(7+total>11){
			resultado=enfrentadas[11][5];
		}
		else {resultado=enfrentadas[7+total][5];}
	}
	if(habilidad1==5){
		if(8+total<0){
			resultado=enfrentadas[0][5];
		}
		else if(8+total>11){
			resultado=enfrentadas[11][5];
		}
		else {resultado=enfrentadas[8+total][5];}
	}
}

return resultado;
}

	}


