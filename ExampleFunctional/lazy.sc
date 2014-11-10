object basicTest {
  val whatAmI = {
    println("I am regular")
    "I am regular"
  }
}

object lazyTest {
  lazy val whatAmI = {
    println("I am lazy")
    "I am lazy"
  }
}

val test1 = basicTest
val test2 = lazyTest
test2.whatAmI



def add5(x:Int) = {
  println("adding 5")
  x+5
}

def mul2(x:Int) = {
  println("multiply 2")
  x*2
}

(1 to 10) map (_+5) map (_*2)

(1 to 10) map (add5(_)) map (mul2(_))
(1 to 10).view map (add5(_)) map (mul2(_)) take(10) mkString(",")