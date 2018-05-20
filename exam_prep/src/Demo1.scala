
class node{
   var index : Int = 2;
   var name : String = "Harman"
   var rank : Float = 1
 var output : String = ""
   override def toString : String  = { output = index.toString() ++ name.toString() ++ rank.toString(); return output }
  
}

object Demo1 {
 
 
  def main(arg : Array[String]){
    var ob : node = new node()
    println(ob.toString())
  }
  
 
}