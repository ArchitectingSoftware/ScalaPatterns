lazy val x = {
  print("(computing x) ")
  42
}

print("x = " )
println(x)
// output is: x = (computing x) 42
//run :load Lazy.sc from terminal