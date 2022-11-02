package pack
object Multiple {
  def main(args: Array[String]): Unit = {
    
    
 var a=0
    val odds=List(1,3,5,7,9,11,13,15,17,19)
    var ret=for{a<-odds
        if a>3; if a<15} yield a
    for(a<-ret)
    {
        println(a)
    }
}

  
}
