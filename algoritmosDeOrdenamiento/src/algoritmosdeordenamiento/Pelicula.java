/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosdeordenamiento;

/**
 *
 * @author javie
 */
public class Pelicula implements Comparable<Pelicula>{
	int id;
	int anio;
	String nombre;
	public Pelicula(int a, int anio, String nombre){
		this.id=a;
		this.anio=anio;
		this.nombre=nombre;
	}	
	
	public String toString(){
		String str;
		str = id + " " +  anio + " " + nombre;
		return str;
	}
	
	public int compareTo(Pelicula peli){  
	   if(this.id==peli.id)  
      		return 0;  
	   else if(this.id>peli.id)  
      	 	return 1;  
	  else  
	     return -1;  
	}	
}
