package pr;

public class Tablero {
	private int[][] tablero;
	private int ancho;
	private int alto;
	
	public Tablero(int ancho, int alto){
		this.alto=alto;
		this.ancho=ancho;
		this.tablero = new int[ancho][alto];
		this.iniciar();
	}
	
	private void iniciar(){
		for(int i=0; i <this.alto; i++){
			for(int j=0; j <this.ancho; j++){
				this.tablero[j][i] = 2*i+j;
			}
		}
		this.tablero[0][2] = 0;
		this.tablero[1][2] = 1;
		this.tablero[2][2] = 8;
		this.tablero[3][2] = 5;
		this.tablero[4][2] = 0;
		
		this.tablero[0][0] = 0;
		this.tablero[0][1] = 0;
		this.tablero[0][2] = 0;
		this.tablero[0][3] = 0;
		
	}
	
	public String toString(){
		String resp="";
		for(int i=0; i <this.alto; i++){
			resp = resp + "|";
			for(int j=0; j <this.ancho; j++){
				resp = resp + this.tablero[j][i];
			}
			resp = resp + "|\n";
		}
		return resp;
	}
	
	public String comprobar(){
		boolean ok = true,finish=false;;
		int validos = 0,i=0,j=0;
		while(i <this.alto){
			j=0;
			ok = true;
			while(j <this.ancho && !finish){
				if(this.tablero[j][i] == 0 && ok){
					validos++;
					ok = true;
				}else{
					ok = false;
					validos=0;
				}
				if(validos > 3)
					finish=true;
				j++;
			}
			i++;
		}
		i=0;j=0;
		if(validos < 4)
			validos = 0;
		ok=true;
		while(i <this.ancho && !finish){
			j=0;
			ok = true;
			while(j <this.alto){
				if(this.tablero[i][j] == 0 && ok){
					validos++;
					ok = true;
				}else{
					ok = false;
					validos=0;
				}	
				if(validos > 3)
					finish=true;
				j++;			
			}
			i++;
		}
		return ""+validos+"";
	}
}
