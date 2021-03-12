package algoritmosdeordenamiento;

import java.lang.reflect.Array;

public class Ordenamiento<T extends Comparable<T>>{

    public int SelectionSort(T[] arreglo){
	int min;
	T temp;
	int numComparaciones=0;
	for(int j=0; j<arreglo.length-1;j++){
	    min=j;
	    for(int i=j+1; i<arreglo.length;i++){
		if(arreglo[min].compareTo(arreglo[i])>0){
		    min=i;
		}
		numComparaciones++;
	    }
	    temp=arreglo[min];
	    arreglo[min]=arreglo[j];
	    arreglo[j]=temp;
	}
	return numComparaciones;
    }

    public int InsertionSort(T[] arreglo){
	int j;
	T temp;
	int numComparaciones=0;
	for(int i=1;i<arreglo.length; i++){  
	    j=i;
	    while(j>=1 && arreglo[j].compareTo(arreglo[j-1])<0){
		temp=arreglo[j];
		arreglo[j]=arreglo[j-1];
		arreglo[j-1]=temp;
		j--;
		numComparaciones++;
	    }
	}
	return numComparaciones;
    }

    public void swap(T[] arreglo,int i,int j){
	T temp=arreglo[i];
	arreglo[i]=arreglo[j];
	arreglo[j]=temp;
    }

    private int[] particion(T[] arreglo,int min,int max){
	int i=min, j=max;//sustituir lo qu ehay en min el elemento en	    //alguna posiscion entre min y max elegida al azar
	int numComparaciones=0;
	while(i<j){
	    if(arreglo[i+1].compareTo(arreglo[i])<=0){
		swap(arreglo,i,i+1);
		i++;
	    }else{
		swap(arreglo,i+1,j);
		j--;
	    }
	    numComparaciones++;
	}
	return new int[] {i, numComparaciones};

    }

    private int QuickSort(T[] arreglo,int min,int max){
	if (max-min <=1)
	    return 0;
	int[] valores=particion(arreglo,min,max);
	int pivote = valores[0];
	int contadorComparaciones = valores[1];
	contadorComparaciones += QuickSort(arreglo,min,pivote-1);
	contadorComparaciones += QuickSort(arreglo,pivote+1,max);
	return contadorComparaciones;
    }

    public int QuickSort(T[] arreglo){
	return QuickSort( arreglo,0,arreglo.length-1);

    }
    
    private int QuickSortInverso(T[] arreglo,int min,int max){
	if (max-min <=1)
	    return 0;
	int[] valores=particion(arreglo,min,max);
	int pivote = valores[0];
	int contadorComparaciones = valores[1];
	contadorComparaciones += QuickSort(arreglo,min,pivote-1);
	contadorComparaciones += QuickSort(arreglo,pivote+1,max);
	return contadorComparaciones;
    }

    public int QuickSortInverso(T[] arreglo){
	return QuickSort( arreglo,0,arreglo.length-1);

    }

    private int[] particionInversa(T[] arreglo,int min,int max){
	int i=min, j=max;//sustituir lo qu ehay en min el elemento en	    //alguna posiscion entre min y max elegida al azar
	int numComparaciones=0;
	while(i<j){
	    if(arreglo[i+1].compareTo(arreglo[i])>0){
		swap(arreglo,i,i+1);
		i++;
	    }else{
		swap(arreglo,i+1,j);
		j--;
	    }
	    numComparaciones++;
	}
	return new int[] {i, numComparaciones};

    }
    
    public int MergeSort(T[] arreglo){
	return MergeSort( arreglo,0,arreglo.length);

    }

    private int MergeSort(T[] arreglo, int min, int max ){
	int contadorComparaciones=0;
	if(max - min <= 1)
	    return 0;
	int mitad = (max + min) / 2;
	contadorComparaciones += MergeSort(arreglo, min, mitad);
	contadorComparaciones += MergeSort(arreglo, mitad, max);
	contadorComparaciones += Merge(arreglo, min, max, mitad);
	return contadorComparaciones;
    }

    private int Merge(T[] arreglo, int min, int max, int mitad){
	T aux[];
	aux = (T[])new Comparable[1+ max - min]; 
	int i = min, j = mitad, k = 0;
	int numComparaciones=0;
	while(i < mitad && j < max){
	    if(arreglo[i].compareTo(arreglo[j]) < 0){
		aux[k] = (T)arreglo[i];
		i ++;
	    }
	    else{
		aux[k] = (T)arreglo[j];
		j ++;
	    }
	    k++;	
	    numComparaciones++;
	}
	while(j < max){
	    aux[k] = (T)arreglo[j];
	    j ++;
	    k ++;
	}
	while(i < mitad){
	    aux[k] = (T)arreglo[i];
	    i ++;
	    k ++;
	}
	// copiar al original
	k=0;
	for(i=min;i<max;i++)
	    arreglo[i]=aux[k++];
	return numComparaciones;
    }
    
    public int BubbleSort(T elements[]){
	int numComparaciones=0;
	for(int i = 0; i < elements.length - 1; i++){
	    for(int j = 0; j < elements.length - 1 - i; j++){
		if(elements[j].compareTo(elements[j + 1]) > 0){
		    swap(elements, j, j + 1);
		}
		numComparaciones++;
	    }
	}
	return numComparaciones;
    }
    
//    public  void prueba(int size){
//	T[] aux;
//	Integer[] myStringArray = {1,2,3,4};
//	aux =  (T[])new Comparable[myStringArray.length];
//	// aux= (T[])Array.newInstance(clase, myStringArray.length);
//	for(int i=0;i<aux.length;i++){
//	    aux[i]=(T)myStringArray[i];
//	}
//
//	if(aux[0].compareTo(aux[1])<0){
//	    System.out.println("si");
//	}
//    } 
}

