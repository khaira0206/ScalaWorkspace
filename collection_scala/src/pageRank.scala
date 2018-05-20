import java.io._
import scala.collection.mutable._
class pair() {

  var Inbound_List: Link_list = new Link_list()
  var Outbound_List: Link_list = new Link_list()

  def getInbound(): Link_list = { return Inbound_List }
  def getOutbound(): Link_list = { return Outbound_List }

}

class GraphAdj(var number_of_vertices: Int) {

  var adj_List: Map[Integer, pair] = HashMap[Integer, pair]()
  var rank: HashMap[Integer, Float] = HashMap[Integer, Float]()
  var val1: Float = 1f / number_of_vertices

  for (i <- 1 to number_of_vertices) { rank(i) = val1 }
  for (i <- 1 to number_of_vertices) { adj_List(i) = new pair() }

  def addEdge(src: Int, dest: Int) {
    if (src > adj_List.size || dest > adj_List.size) {
      println("the vertex entered in not present ")
      return 
    }

    var pair: pair = new pair()
    var pair1: pair = new pair()
    
        pair.Inbound_List = adj_List.get(dest).get.getInbound()

        pair.Inbound_List.add(src.asInstanceOf[Object])
       
    pair.Outbound_List = adj_List.get(dest).get.getOutbound()
    pair1.Outbound_List = adj_List.get(src).get.getOutbound()
    pair1.Outbound_List.add(dest.asInstanceOf[Object])
    pair1.Inbound_List = adj_List.get(src).get.getInbound()
      
    adj_List.update(dest, pair)
    adj_List.update(src, pair1)

  }
  
    def show() : Unit = {
     var i : Int = 0
     
     adj_List.foreach({case(a,b) => println(" im "+a +" out  "+ b.getInbound().show(b.getInbound().head1))});
     
   
   }

  def pageRank(): HashMap[Integer, Float] = {

    for (i <- 1 to 2) {step(rank)}
    for (i <- 1 to number_of_vertices) { println(rank(i))}

    return rank
  }

  def step(rank: HashMap[Integer, Float]): Unit = {

    var dampFactor: Float = 0.85f
    var div: Float = number_of_vertices.toFloat
    var constant: Float = (1 - dampFactor) / div
  
    for (i <- 1 to adj_List.size) {
      var val1: Float = 0f
      
   var it : Iterator[Node] = adj_List.get(i).get.getInbound().iterator()
    
     
      while(it.hasNext) {
        var a : Integer =it.next().data.asInstanceOf[Integer]
       print(a + " ")
       var val2: Int = adj_List.get(a).get.getOutbound().size1()
       val1 += rank(a) / val2.toFloat

      }
   
     
      val1 *= dampFactor
      val1 += constant
      rank(i) = val1

    }

  }

}

object pageRank {

  def main(args: Array[String]) {
    var ga = new GraphAdj(11)
     ga.addEdge(2, 3)
    ga.addEdge(3, 2)
    ga.addEdge(4, 1)
    ga.addEdge(4, 2)
    ga.addEdge(5, 2)
    ga.addEdge(5, 4)
    ga.addEdge(5, 6)
    ga.addEdge(6, 2)
    ga.addEdge(6, 5)
    ga.addEdge(7, 2)
    ga.addEdge(7, 5)
    ga.addEdge(8, 2)
    ga.addEdge(8, 5)
    ga.addEdge(9, 2)
    ga.addEdge(9, 5)
    ga.addEdge(10, 5)
    ga.addEdge(11, 5)
    ga.addEdge(1, 2)
    ga.addEdge(1, 3)
    ga.addEdge(1, 4)
    ga.addEdge(1, 5)
    ga.addEdge(1, 6)
    ga.addEdge(1, 7)
    ga.addEdge(1, 8)
    ga.addEdge(1, 9)
    ga.addEdge(1, 10)
    ga.addEdge(1, 11)
    ga.show()
    ga.pageRank()
    ga.show()
  }
}