import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

 class pair {
	 
	List<Integer> Inbound_List ;
	List<Integer> Outbound_List ;
	
	public pair(){
		 Inbound_List = new LinkedList<Integer>();
		 Outbound_List = new LinkedList<Integer>();
	}
	LinkedList<Integer> getInbound(){
		return (LinkedList<Integer>) Inbound_List;
	}
	LinkedList<Integer> getOutbound(){
		return (LinkedList<Integer>) Outbound_List;
	}
	
}

class GraphAdj1{
	
	   Map<Integer, pair> adj_List;
	 // float dist ;
	  int number_of_vertices ;
	  
	  HashMap<Integer , Float> rank = new HashMap<Integer, Float>();
	  
	  
	  
	   public GraphAdj1(int number_of_vertices){
		   adj_List = new HashMap<Integer, pair>();
		   float val  = (float)1 / number_of_vertices;
		   for(int i = 1; i <= number_of_vertices; i++){
			  // System.out.println(rank.values());
				  rank.put(i, val);
			  }
		   
		   this.number_of_vertices = number_of_vertices;
	
	        for (int i = 1 ; i <= number_of_vertices ; i++)
	        { 
	        	adj_List.put(i, new pair());
	        }
		  
		   
	   }
	   public void addEdge(int src, int dest){
		   
		   if (src > adj_List.size() || dest > adj_List.size())
	       {
	           System.out.println("the vertex entered in not present ");
	           return;
	       }
		   
		     adj_List.get(dest).getInbound().add(src);
		     adj_List.get(src).getOutbound().add(dest);
		  
	   }
	   
	   public void  show(){
		   
		   Iterator<Entry<Integer, pair>> it = adj_List.entrySet().iterator();
		   while(it.hasNext()){
			   Entry<Integer, pair> pair = it.next();
			   System.out.println(" In "+pair.getValue().Inbound_List +" "+pair.getKey()+" "+" Out " + pair.getValue().Outbound_List);
		   }
	   }
	   
	   public HashMap<Integer, Float> pageRank(){
		   
		   for(int i = 1; i <= 30; i++){
			   step(rank);
			 // rank =  normalize(rank);
			  // System.out.println(rank.values());
		   }
		   return rank;
	   }
	   public HashMap<Integer, Float> normalize(HashMap<Integer, Float> rank2){
		   
		   float sqr = 0;
		   float val;
		   Iterator<Entry<Integer, Float>> it = rank2.entrySet().iterator();
		   while(it.hasNext()){
			   val = it.next().getValue();
			   sqr += val * val; 
		   }
		   while(it.hasNext()){
			   val = it.next().getValue();
			   rank2.put(it.next().getKey(), (float) (val / Math.sqrt(sqr)));
		   }
		   return rank2;
				   
		   
	   }
	   public void step(HashMap<Integer, Float> rank){
		   
		 
		   
		   float dampFactor = (float) 0.85;		   
		   float constant = (float)(1 - dampFactor)/number_of_vertices;
		   
		   for(int i = 1; i <= adj_List.size() ; i++){
			  float val = 0;
			  int j = 0;
			  
			   for(int a : adj_List.get(i).getInbound()){
				   //System.out.println("list val  "+i+"  "+ +a);
				   //System.out.println("rank.get(i)  "+rank.get(i)+" adj_List.get(a).getOutbound().size() "+ +adj_List.get(a).getOutbound().size());
				 //val = rank.get(a);
				  val = val+ ( rank.get(a) / adj_List.get(a).getOutbound().size());
				
			   }
			   val *=  dampFactor;
			   val += constant;
			 rank.put(i, val);
			   
		   }
		   
		
	   }
	   
	   
	
	
}

public class pageRank1 {

	public static void main(String arg[] ){
		
		GraphAdj1 ga = new GraphAdj1(11);
		
		ga.addEdge(2, 3);
		ga.addEdge(3, 2);
		ga.addEdge(4, 1);
		ga.addEdge(4, 2);
		ga.addEdge(5, 2);
		ga.addEdge(5, 4);
		ga.addEdge(5, 6);
		ga.addEdge(6, 2);
		ga.addEdge(6, 5);
		ga.addEdge(7, 2);
		ga.addEdge(7, 5);
		ga.addEdge(8, 2);
		ga.addEdge(8, 5);
		ga.addEdge(9, 2);
		ga.addEdge(9, 5);
		ga.addEdge(10, 5);
		ga.addEdge(11, 5);
		ga.addEdge(1, 2);
		ga.addEdge(1, 3);
		ga.addEdge(1, 4);
		ga.addEdge(1, 5);
		ga.addEdge(1, 6);
		ga.addEdge(1, 7);
		ga.addEdge(1, 8);
		ga.addEdge(1, 9);
		ga.addEdge(1, 10);
		ga.addEdge(1, 11);
		
		
		ga.show();
		
		HashMap<Integer, Float> rank = ga.pageRank();
		
		
		Iterator it = rank.entrySet().iterator();
	    while (it.hasNext()) {
	       Map.Entry pair = (Map.Entry)it.next();
	       System.out.println(pair.getKey() + " = " + pair.getValue());
	       it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	
	
	
	
}
