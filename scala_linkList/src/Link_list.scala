
class Node(data1 : Object){
  
  var data: Object = data1;
  var next : Node = null;
  
   def getNext() : Node ={
    return next;
  }
  def setNext(next : Node){
    this.next = next;
  }
  
  
}

class Link_list {
  
  var head1 : Node = null;
  var counter : Int = 0;
  
  def add(data : Object){
   var tempNode : Node = new Node(data);
    if(head1 == null){head1 = tempNode; }
    else{tempNode.setNext(head1)
    head1 = tempNode  
    }
    increamentCounter();
    
  }
   def increamentCounter(){counter += 1;}
   
    def show(node: Node){
    var current : Node = node;
    if(current != null){
       
    while(current!= null){
     
      println(current.data);
       current = current.getNext();
    }
  }
  }
  
}

object mylist {
  
  def main(arg : Array[String]){
    var list = new Link_list();
    
    list.add(1.asInstanceOf[Object]);
    list.add(2.asInstanceOf[Object]);
    list.add(3.asInstanceOf[Object]);
    list.add(4.asInstanceOf[Object]);
    
    list.show(list.head1)
    
  }
  
}