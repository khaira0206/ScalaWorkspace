
import java.io._
import scala.collection.mutable._
import Array._
import scala.util.Random
class pair(value: Float) {

  var Inbound_List: List[Int] = List()
  var Outbound_List: List[Int] = List()
  var rank: Float = value

  def getInbound(): List[Int] = { return Inbound_List }
  def getOutbound(): List[Int] = { return Outbound_List }

}

class GraphAdj(var number_of_vertices: Int) {

  var adj_List: Map[Integer, pair] = HashMap[Integer, pair]()

  var val1: Float = 1f / number_of_vertices

  for (i <- 1 to number_of_vertices) { adj_List(i) = new pair(val1) }

  def addEdge(src: Int, dest: Int) {
    if (src > adj_List.size || dest > adj_List.size) {
      println("the vertex entered in not present ")
      return
    }

    var pair: pair = new pair(val1)
    var pair1: pair = new pair(val1)
    pair.Inbound_List = adj_List.get(dest).get.getInbound().+:(src)
    pair.Outbound_List = adj_List.get(dest).get.getOutbound()
    pair1.Outbound_List = adj_List.get(src).get.getOutbound().+:(dest)
    pair1.Inbound_List = adj_List.get(src).get.getInbound()

    adj_List.update(dest, pair)
    adj_List.update(src, pair1)

  }

  def pageRank() {

    for (i <- 1 to 30) { step(adj_List) }
    for (i <- 1 to number_of_vertices) { println(adj_List(i).rank) }

  }

  def step(adj_List: Map[Integer, pair]): Unit = {

    var dampFactor: Float = 0.85f
    var div: Float = number_of_vertices.toFloat
    var constant: Float = (1 - dampFactor) / div

    for (i <- 1 to adj_List.size) {
      var val1: Float = 0f
      for (a <- adj_List.get(i).get.getInbound()) {

        var val2: Int = adj_List.get(a.asInstanceOf[Integer]).get.getOutbound().size
        val1 += adj_List.get(a).get.rank / val2.toFloat

      }

      val1 *= dampFactor
      val1 += constant
      adj_List(i).rank = val1

    }

  }

}
class randomGraph(var seed: Int, var size: Int, var prob: Double) extends GraphAdj(size) {
  val randomGen = new Random(seed)

  def addRandEdges() {
    for (i <- 1 to size) {
      for (j <- 1 to size) {
        if (i != j && randomGen.nextFloat() < prob) {
          addEdge(i, j)
        }
      }
    }
  }

}

object pageRank {

  def main(args: Array[String]) {

    var randga = new randomGraph(42, 10, .2)
    randga.addRandEdges()
    randga.pageRank()
    for (i <- 100 to 1001 by 100) {
      println("graph size " + i + "\n\n")
      var randga = new randomGraph(42, i, .2)
      randga.addRandEdges()
      randga.pageRank()
    }

    println("--------Wikipedia Example---------");
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
    ga.pageRank()

  }
}