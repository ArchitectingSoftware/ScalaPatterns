//basic function
def addFn(x:Int, y:Int) = x+y
addFn(2,3)

//annonymous fn
val anonFn = (x:Int,y:Int) => x+y
anonFn(2,3)

//passing a function
def doMath(f : (Int)=>Int, x:Int): Int = f(x)
def plusTwice = (x:Int) => x+x
def mulTwice = (x:Int)=> x*x

//lets try
doMath(plusTwice, 3)
doMath(plusTwice, 4)
doMath(mulTwice,  3)
doMath(mulTwice,  4)

//using anonymous fn
doMath( (x)=>x-x, 3)
doMath( (x)=>x+x, 3)

//putting function last as a second arg makes it look a bit better
def doMath2(x:Int) (f : (Int)=>Int): Int = f(x)
doMath2(2) {
  (x)=>x*x
}
doMath2(3) {
  (x)=>x*x
}

//returning a function
def retAddByFn(x:Int) : Int=>Int = {
  (n:Int) => x+n
}
val addByFive = retAddByFn(5)
addByFive(3)
(retAddByFn(5))(3)
retAddByFn(5)(3) //dont need the added parens

//calling a function as an arguement
def callArgFn(x : Unit => Unit) = {
  x()
}
callArgFn{
  f => println("Hello")
}
//COMPOSITION
def f(s: String) = "f(" + s + ")"
def g(s: String) = "g(" + s + ")"

val fComposeG = f _ compose g _   //f(g(x)) g compose with x
val fAndThenG = f _ andThen g _   //g(f(x)) f and then g

fComposeG("cool")
fAndThenG("cool")
