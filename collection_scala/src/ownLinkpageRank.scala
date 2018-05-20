

import java.io._
import scala.collection.mutable._ 



class Node1(data1 : Object){
  
  var data : Object = data1;
  var next : Node1 = null;
  
  def getNext() : Node1 ={
    return next;
  }
  def setNext(next : Node1){
    this.next = next;
  }
  
}

class myLinkedList extends Iterable[Node]{
  
  var head1 : Node = new Node(0.asInstanceOf[Object]);
  var counter : Int = 0;
  var start : Int = 0;
  var curser : Int = 0;
  
  
  def iterator: Iterator[Node] = null;
  
  // Members declared in myLinkedList
  //def Iterator(): Iterator[Node] = { return null};
    
  
 // def hasNext() : Boolean ={
   // return  this.curser < size1();
 // }
 // def next() : Node = {
  //  if(this.hasNext()){
 //     var current : Node = head1.next;
 //     curser += 1;
  //    return current;
  /// throw new NoSuchElementException();
  //}
 // def remove(){
    
 // }
  
  def getCounter() : Int ={
    return counter;
  }
  def increamentCounter(){
    counter += 1;
  }
  def decreamentCounter(){
    counter -= 1;
  }
  
  def add(data : Object){
    
    if(head1 == null){
      head1 = new Node(data);
    }
    
    var tempNode : Node = new Node(data);
    var current : Node  = head1;
    if(current == null){
      while(current.getNext() != null){
        current = current.getNext();
      }
      current.setNext(tempNode);
    }
    increamentCounter();
    
  }
  
  def size1() : Int ={
    return counter;
  }
  def show(node: Node){
    var current : Node = node;
    if(current != null){
      current = node.getNext();
    while(current!= null){
     
      println(current.data);
       current = current.getNext();
    }
  }
  }
  
}

class pair1(){
  
  var Inbound_List: myLinkedList = new  myLinkedList();
  var Outbound_List: myLinkedList = new  myLinkedList();
 
	def getInbound() : myLinkedList = { return  Inbound_List;}
	def getOutbound() : myLinkedList = { return  Outbound_List;}
		 
	
  
}

 class GraphAdj1(var number_of_vertices : Int){
  
  var adj_List : Map[Integer,pair1] = HashMap[Integer, pair1]();
 
	
	var rank : HashMap[Integer,Float] = HashMap[Integer, Float]();
	var val1 : Float  = 1f /number_of_vertices ;
	
   for(i <- 1 to number_of_vertices){ rank(i) = val1; }
   for(i <- 1 to number_of_vertices){ adj_List(i) = new pair1(); }
   
   
   def addEdge(src :Integer, dest :Integer){
     if (src > adj_List.size || dest > adj_List.size)
	       {
	           println("the vertex entered in not present ");
	           return;
	       }
     
      var pair: pair1 = new pair1()
    var pair1: pair1 = new pair1()
    
        pair.Inbound_List = adj_List.get(dest).get.getInbound()
         print(pair.Inbound_List)
        pair.Inbound_List.add(src)
       
    pair.Outbound_List = adj_List.get(dest).get.getOutbound()
    pair1.Outbound_List = adj_List.get(src).get.getOutbound()
    pair1.Outbound_List.add(dest)
    pair1.Inbound_List = adj_List.get(src).get.getInbound()
      
    adj_List.update(dest, pair)
    adj_List.update(src, pair1)
     
     
   }
   
   def show() : Unit = {
     
     var Key: Int = 0;
     adj_List.foreach({case(a,b) => println(a +""+ b.getInbound().show(b.getInbound().head1)+ b.getOutbound().show(b.getOutbound().head1))});
     
   
   }
   
   def  pageRank() : HashMap[Integer, Float] = {
		   
		   for(i <- 1 to 30){
			   step(rank);
			  
		   }
		   
		   for(i <- 1 to number_of_vertices){
			  
   println(rank(i));
		    
		}
		   
		   return rank;
	   }
   
  def step(rank : HashMap[Integer, Float] ) : Unit= {
		   
		 
		   
		   var dampFactor : Float = 0.85f ;		   
		   var  constant : Float = 1 - dampFactor / number_of_vertices;
		   
		   for(i <- 1 to  adj_List.size){
			  var val1 : Float = 0f;
			 var j: Int = 0;
			 // var list : myLinkedList = adj_List.get(i).get.getInbound();
			  var hell : Boolean = true;
			   //for(a  <- adj_List.get(i).get.getInbound())
			   while(hell){
				  
			     
			     // adj_List.get(i).get.getInbound().show(adj_List.get(i).get.getInbound().head1);
			    // var a : Node = adj_List.get(i).get.getInbound().next();
			    // println(b);
			    // var val2 : Int = adj_List.get(a.data.asInstanceOf[Integer]).get.getOutbound().size1();
				  //val1 = val1 +  rank(a.asInstanceOf[Integer]) / val2;
				hell = false;
			   }
			   val1 *=  dampFactor;
			   val1 += constant;
			 rank(i) =  val1;
			   
		   }
		   
		
	   }
	   
 }

object pageRank1 {
  
   def main(args: Array[String]) {
     var ga = new GraphAdj1(11);
    ga.show();
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
		
		
		//ga.pageRank();
		
   }
  
}