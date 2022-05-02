package it.polito.tdp.introGrafi.model;

import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class Prova {

	public void creaGrafo() {
		//Voglio rappresentare un grafo: es di pagina 16 slide Introducion to Graphs:
		//I vertici sono numeri interi, il grafo è non orientato e gli archi non sono pesati.
		Graph<Integer, DefaultEdge> g = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class); //Questo mi crea un grafo semplice vuoto,
		                                                                                          //con zero archi e zero vertici.
		
		//Creo/Aggiungo vertici.
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		
		//Creo/Aggiungo gli archi.
		g.addEdge(1, 2);
		g.addEdge(2, 5);
		g.addEdge(1, 5);
		g.addEdge(3, 6);
		
		System.out.println(g);
		
		//Ipotizzo di chiedere a un vertice con quali percorsi e collegato agli altri vertici.
		System.out.println("Connessioni del vertice 2: ");
		Set<DefaultEdge> archi = g.edgesOf(2);
		for(DefaultEdge e: archi) {
			
			if(g.getEdgeTarget(e)==2) {
				System.out.println(g.getEdgeSource(e));
			}else {
				System.out.println(g.getEdgeTarget(e));
			}
			
			//Per evitare queste linee di codice posso direttamente usare una classe già implementata nella libreria jGraphT
			//ovvero la classe neighboorListOf(g: Graph<V,E>, vertex:V): List<V>, chiedo quindi l?elenco dei vicini nel grafo
			//G che sono vicini del vertice V, quindi mi restituisce una lista dei vicini collegati.
		}
		
		List<Integer> vicini = Graphs.neighborListOf(g, 2);
		System.out.println(vicini);
		
	}
	
	public static void main(String[] args) { 
		
		Prova p = new Prova();
		p.creaGrafo();
	
	}

}
