package Objeto;

import java.io.Serializable;

public class Objeto implements Serializable{
	int num1=0;
	int num2=0;
	String simbolo="";
	int resultado=0;
	
	
	
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String dato) {
		this.simbolo = dato;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	

}
