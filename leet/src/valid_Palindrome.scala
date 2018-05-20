class Solution(s: String) {
def isPalindrome(s: String): Boolean = {
  println(s)
if (s.isEmpty()) {

return true
}

var head: Int = 0
var tail: Int = s.length() - 1
var cHead: Char = s.charAt(head) 
var cTail: Char = s.charAt(tail)

while (head <= tail) {

var cHead: Char = s.charAt(head) 
var cTail: Char = s.charAt(tail)

if (!Character.isLetterOrDigit(cHead)) {
 head += 1
}else if (!Character.isLetterOrDigit(cTail)){
 tail -= 1;
}else{
if(Character.toLowerCase(cHead) != Character.toLowerCase(cTail)){

  return false
}
head += 1
tail -= 1
}
}
return true
}
}
object Demo {
def main(arg: Array[String]){
val s: String = "A man, a plan, a canal: Panama"
val sol = new Solution(s)
println(sol.isPalindrome(s))
println(sol)
}
}
