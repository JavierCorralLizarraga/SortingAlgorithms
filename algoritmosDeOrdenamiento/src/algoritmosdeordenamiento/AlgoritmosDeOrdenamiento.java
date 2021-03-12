/*
 * tO Change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosdeordenamiento;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartUtilities; 

public class AlgoritmosDeOrdenamiento {

    public static void main(String[] args) throws IOException {
	Ordenamiento<Pelicula> algoritmos= new Ordenamiento<>();
	ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
	try {
	    File myObj = new File("movie_titles2.txt");

	    Scanner myReader = new Scanner(myObj);
	    myReader.useDelimiter(","); 
	    while (myReader.hasNextLine()) {
		String data = myReader.nextLine();
		String[] arr = data.split(",");
		Pelicula pelicula = new Pelicula(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),arr[2]);
		peliculas.add(pelicula);
	    }
	    myReader.close();
	} catch (FileNotFoundException e) {
	    System.out.println("An error occurred.");
	    e.printStackTrace(); 
	}

	ArrayList<Pelicula> peliculasAux = (ArrayList<Pelicula>)peliculas.clone();

	Pelicula[] arrPelis = new Pelicula[peliculas.size()];
	int i=0;
	while(!peliculas.isEmpty()){
	    arrPelis[i]=peliculas.remove(0);
	    i++;
	}
	//tenemos nuestro arreglo de pelis lleno
	//estan seemingly aleatorios respecto al id

	int [] tamanios = {100, 1000, 2500, 5000, 10000};
	Pelicula[] arrPelisOrdenado = arrPelis.clone();
	algoritmos.MergeSort(arrPelisOrdenado); //arreglo ordenado
	Pelicula[] arrPelisInverso = arrPelis.clone();
	algoritmos.QuickSortInverso(arrPelisInverso); //arreglo inverso
	//merge sort
	//aplicamos sort a todos los sizes de arr random
	ArrayList<Integer> comparacionesMergeRandom = new ArrayList<>();
	ArrayList<Double> elapsedTimeMergeRandom = new ArrayList<>();
	for (int n : tamanios){
	    Pelicula[] arrRecortado = Arrays.copyOfRange(arrPelis, 0, n);
	    double startTime = System.nanoTime();
	    comparacionesMergeRandom.add(algoritmos.MergeSort(arrRecortado));
	    elapsedTimeMergeRandom.add(System.nanoTime() - startTime);	   
	}
	//aplicamos sort a todos los sizes de arr ordenado
	ArrayList<Integer> comparacionesMergeOrdenado = new ArrayList<>();
	ArrayList<Double> elapsedTimeMergeOrdenado = new ArrayList<>();
	for (int n : tamanios){
	    Pelicula[] arrRecortado = Arrays.copyOfRange(arrPelisOrdenado, 0, n);
	    double startTime = System.nanoTime();
	    // cualquier cosa que se quiera medir su tiempo
	    comparacionesMergeOrdenado.add(algoritmos.MergeSort(arrRecortado));
	    elapsedTimeMergeOrdenado.add(System.nanoTime() - startTime);
	}
	//aplicamos sort a todos los sizes de arr inverso
	ArrayList<Integer> comparacionesMergeInverso = new ArrayList<>();
	ArrayList<Double> elapsedTimeMergeInverso = new ArrayList<>();
	for (int n : tamanios){
	    Pelicula[] arrRecortado = Arrays.copyOfRange(arrPelisInverso, 0, n);
	    double startTime = System.nanoTime();
	    // cualquier cosa que se quiera medir su tiempo
	    comparacionesMergeInverso.add(algoritmos.MergeSort(arrRecortado));
	    elapsedTimeMergeInverso.add(System.nanoTime() - startTime);
	}
	//quick sort
	//aplicamos sort a todos los sizes de arr random
	ArrayList<Integer> comparacionesQuickRandom = new ArrayList<>();
	ArrayList<Double> elapsedTimeQuickRandom = new ArrayList<>();
	for (int n : tamanios){
	    Pelicula[] arrRecortado = Arrays.copyOfRange(arrPelis, 0, n);
	    double startTime = System.nanoTime();
	    // cualquier cosa que se quiera medir su tiempo
	    comparacionesQuickRandom.add(algoritmos.QuickSort(arrRecortado));
	    elapsedTimeQuickRandom.add(System.nanoTime() - startTime);
	}
	//aplicamos sort a todos los sizes de arr ordenado
	ArrayList<Integer> comparacionesQuickOrdenado = new ArrayList<>();
	ArrayList<Double> elapsedTimeQuickOrdenado = new ArrayList<>();
	for (int n : tamanios){
	    Pelicula[] arrRecortado = Arrays.copyOfRange(arrPelisOrdenado, 0, n);
	    double startTime = System.nanoTime();
	    // cualquier cosa que se quiera medir su tiempo
	    comparacionesQuickOrdenado.add(algoritmos.QuickSort(arrRecortado));
	    elapsedTimeQuickOrdenado.add(System.nanoTime() - startTime);
	}
	//aplicamos sort a todos los sizes de arr inverso
	ArrayList<Integer> comparacionesQuickInverso = new ArrayList<>();
	ArrayList<Double> elapsedTimeQuickInverso = new ArrayList<>();
	for (int n : tamanios){
	    Pelicula[] arrRecortado = Arrays.copyOfRange(arrPelisInverso, 0, n);
	    double startTime = System.nanoTime();
	    // cualquier cosa que se quiera medir su tiempo
	    comparacionesQuickInverso.add(algoritmos.QuickSort(arrRecortado));
	    elapsedTimeQuickInverso.add(System.nanoTime() - startTime);
	}
	//selection sort
	//aplicamos sort a todos los sizes de arr random
	ArrayList<Integer> comparacionesSelectionRandom = new ArrayList<>();
	ArrayList<Double> elapsedTimeSelectionRandom = new ArrayList<>();
	for (int n : tamanios){
	    Pelicula[] arrRecortado = Arrays.copyOfRange(arrPelis, 0, n);
	    double startTime = System.nanoTime();
	    // cualquier cosa que se quiera medir su tiempo
	    comparacionesSelectionRandom.add(algoritmos.SelectionSort(arrRecortado));
	    elapsedTimeSelectionRandom.add(System.nanoTime() - startTime);
	}
	//aplicamos sort a todos los sizes de arr ordenado
	ArrayList<Integer> comparacionesSelectionOrdenado = new ArrayList<>();
	ArrayList<Double> elapsedTimeSelectionOrdenado = new ArrayList<>();
	for (int n : tamanios){
	    Pelicula[] arrRecortado = Arrays.copyOfRange(arrPelisOrdenado, 0, n);
	    double startTime = System.nanoTime();
	    // cualquier cosa que se quiera medir su tiempo
	    comparacionesSelectionOrdenado.add(algoritmos.SelectionSort(arrRecortado));
	    elapsedTimeSelectionOrdenado.add(System.nanoTime() - startTime);
	}
	//aplicamos sort a todos los sizes de arr inverso
	ArrayList<Integer> comparacionesSelectionInverso = new ArrayList<>();
	ArrayList<Double> elapsedTimeSelectionInverso = new ArrayList<>();
	for (int n : tamanios){
	    Pelicula[] arrRecortado = Arrays.copyOfRange(arrPelisInverso, 0, n);
	    double startTime = System.nanoTime();
	    // cualquier cosa que se quiera medir su tiempo
	    comparacionesSelectionInverso.add(algoritmos.SelectionSort(arrRecortado));
	    elapsedTimeSelectionInverso.add(System.nanoTime() - startTime);
	}
	//insertion sort	
	//aplicamos sort a todos los sizes de arr random
	ArrayList<Integer> comparacionesInsertionRandom = new ArrayList<>();
	ArrayList<Double> elapsedTimeInsertionRandom = new ArrayList<>();
	for (int n : tamanios){
	    Pelicula[] arrRecortado = Arrays.copyOfRange(arrPelis, 0, n);
	    double startTime = System.nanoTime();
	    // cualquier cosa que se quiera medir su tiempo
	    comparacionesInsertionRandom.add(algoritmos.InsertionSort(arrRecortado));
	    elapsedTimeInsertionRandom.add(System.nanoTime() - startTime);
	}
	//aplicamos sort a todos los sizes de arr ordenado
	ArrayList<Integer> comparacionesInsertionOrdenado = new ArrayList<>();
	ArrayList<Double> elapsedTimeInsertionOrdenado = new ArrayList<>();
	for (int n : tamanios){
	    Pelicula[] arrRecortado = Arrays.copyOfRange(arrPelisOrdenado, 0, n);
	    double startTime = System.nanoTime();
	    // cualquier cosa que se quiera medir su tiempo
	    comparacionesInsertionOrdenado.add(algoritmos.InsertionSort(arrRecortado));
	    elapsedTimeInsertionOrdenado.add(System.nanoTime() - startTime);
	}
	//aplicamos sort a todos los sizes de arr inverso
	ArrayList<Integer> comparacionesInsertionInverso = new ArrayList<>();
	ArrayList<Double> elapsedTimeInsertionInverso = new ArrayList<>();
	for (int n : tamanios){
	    Pelicula[] arrRecortado = Arrays.copyOfRange(arrPelisInverso, 0, n);
	    double startTime = System.nanoTime();
	    // cualquier cosa que se quiera medir su tiempo
	    comparacionesInsertionInverso.add(algoritmos.InsertionSort(arrRecortado));
	    elapsedTimeInsertionInverso.add(System.nanoTime() - startTime);
	}
	// bubble sort
	//aplicamos sort a todos los sizes de arr random
	ArrayList<Integer> comparacionesBubbleRandom = new ArrayList<>();
	ArrayList<Double> elapsedTimeBubbleRandom = new ArrayList<>();
	for (int n : tamanios){
	    Pelicula[] arrRecortado = Arrays.copyOfRange(arrPelis, 0, n);
	    double startTime = System.nanoTime();
	    // cualquier cosa que se quiera medir su tiempo
	    comparacionesBubbleRandom.add(algoritmos.BubbleSort(arrRecortado));
	    elapsedTimeBubbleRandom.add(System.nanoTime() - startTime);
	}
	//aplicamos sort a todos los sizes de arr ordenado
	ArrayList<Integer> comparacionesBubbleOrdenado = new ArrayList<>();
	ArrayList<Double> elapsedTimeBubbleOrdenado = new ArrayList<>();
	for (int n : tamanios){
	Pelicula[] arrRecortado = Arrays.copyOfRange(arrPelisOrdenado, 0, n);
	    double startTime = System.nanoTime();
	    // cualquier cosa que se quiera medir su tiempo
	    comparacionesBubbleOrdenado.add(algoritmos.BubbleSort(arrRecortado));
	    elapsedTimeBubbleOrdenado.add(System.nanoTime() - startTime);
	}
	//aplicamos sort a todos los sizes de arr inverso
	ArrayList<Integer> comparacionesBubbleInverso = new ArrayList<>();
	ArrayList<Double> elapsedTimeBubbleInverso = new ArrayList<>();
	for (int n : tamanios){
	    Pelicula[] arrRecortado = Arrays.copyOfRange(arrPelisInverso, 0, n);
	    double startTime = System.nanoTime();
	    // cualquier cosa que se quiera medir su tiempo
	    comparacionesBubbleInverso.add(algoritmos.BubbleSort(arrRecortado));
	    elapsedTimeBubbleInverso.add(System.nanoTime() - startTime);
	}

//    final XYSeries merge = new XYSeries("MergeSort");
//    for(int j=0; j < tamanios.length; j++)
//	merge.add(tamanios[j], (double)elapsedTimeMergeOrdenado.remove(0));
//    final XYSeries quick = new XYSeries("QuickSort");
//    for(int j=0; j < tamanios.length; j++)
//	quick.add(tamanios[j], (double)elapsedTimeQuickOrdenado.remove(0));
//    final XYSeries insertion = new XYSeries("InsertionSort");
//    for(int j=0; j < tamanios.length; j++)
//	insertion.add(tamanios[j], (double)elapsedTimeInsertionOrdenado.remove(0));
//    final XYSeries selection = new XYSeries("SelectionSort");
//    for(int j=0; j < tamanios.length; j++)
//         selection.add(tamanios[j], (double)elapsedTimeSelectionOrdenado.remove(0));
//    final XYSeries bubble = new XYSeries("BubbleSort");
//    for(int j=0; j < tamanios.length; j++)
//	bubble.add(tamanios[j], (double)elapsedTimeBubbleOrdenado.remove(0));
//    
//    final XYSeriesCollection dataset = new XYSeriesCollection( );
//    dataset.addSeries( merge );
//    dataset.addSeries( quick );
//    dataset.addSeries( insertion );
//    dataset.addSeries( selection );
//    dataset.addSeries( bubble );
//    
//    JFreeChart xylineChart = ChartFactory.createXYLineChart(
//    "Sorting en arreglo ordenado", 
//    "tamaño del arreglo",
//    "tiempo (segundos)", 
//    dataset,
//    PlotOrientation.VERTICAL, 
//    true, true, false);
//    
//    int width = 640;   /* Width of the image */
//    int height = 480;  /* Height of the image */ 
//    File XYChart = new File( "Ordenado.png" ); 
//    
//    ChartUtilities.saveChartAsJPEG(XYChart, xylineChart, width, height);
    
    final XYSeries merge = new XYSeries("MergeSort");
    for(int j=0; j < tamanios.length; j++)
	merge.add(tamanios[j], (double)elapsedTimeMergeRandom.remove(0));
    final XYSeries quick = new XYSeries("QuickSort");
    for(int j=0; j < tamanios.length; j++)
	quick.add(tamanios[j], (double)elapsedTimeQuickRandom.remove(0));
    final XYSeries insertion = new XYSeries("InsertionSort");
    for(int j=0; j < tamanios.length; j++)
	insertion.add(tamanios[j], (double)elapsedTimeInsertionRandom.remove(0));
    final XYSeries selection = new XYSeries("SelectionSort");
    for(int j=0; j < tamanios.length; j++)
         selection.add(tamanios[j], (double)elapsedTimeSelectionRandom.remove(0));
    final XYSeries bubble = new XYSeries("BubbleSort");
    for(int j=0; j < tamanios.length; j++)
	bubble.add(tamanios[j], (double)elapsedTimeBubbleRandom.remove(0));
    
    final XYSeriesCollection dataset = new XYSeriesCollection( );
    dataset.addSeries( merge );
    dataset.addSeries( quick );
    dataset.addSeries( insertion );
    dataset.addSeries( selection );
    dataset.addSeries( bubble );
    
    JFreeChart xylineChart = ChartFactory.createXYLineChart(
    "Sorting en arreglo random (tiempo)", 
    "tamaño del arreglo",
    "# de elapsedTime", 
    dataset,
    PlotOrientation.VERTICAL, 
    true, true, false);
    
    int width = 1100;   /* Width of the image */
    int height = 720;  /* Height of the image */ 
    File XYChart = new File( "aaaRandom(tiempo).png" ); 
    
    ChartUtilities.saveChartAsJPEG(XYChart, xylineChart, width, height);
    }
}
