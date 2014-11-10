val myArray = Array(1,2,3,4,5)

val ma2_v1 = myArray map (i => i*2)
val ma2_2 = myArray map ((i:Int)=> i*2)
val ma2_3 = myArray map (_ * 2)

val ma2_4 = for( i <- myArray) yield (i*2)

def badStuff(a:Array[Int]) = {
  var newArray = new Array[Int](myArray.length)

  for(i <- 0 until newArray.length) {
    newArray(i) = myArray(i) * 2
  }

  newArray
}

def worseStuff(a:Array[Int]) = {
  var newArray = new Array[Int](myArray.length)
  var i = 0

  while(i < newArray.length){
    newArray(i) = myArray(i) * 2
    i = i + 1
  }

  newArray
}

val ma2_5 = badStuff(myArray)
val ma2_6 = worseStuff(myArray)


var mutArray = Array(1,2,3,4,5)

def evenWorseStuff(a:Array[Int]) = {
  var i = 0

  while(i < a.length) {
    a(i) = a(i) * 2
    i = i + 1
  }
}
println(mutArray mkString(","))
evenWorseStuff(mutArray)
println(mutArray mkString(","))
