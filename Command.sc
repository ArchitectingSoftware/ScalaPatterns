object Invoker {
  private var history: Seq[() => Unit] = Seq.empty

  //Use call by name syntax => pass a function by name that returns a Unit
  def invoke(command: => Unit) = {
    command
    history :+= command _    /* this is a shortcut for history :+= (() => command) */
  }
}

Invoker.invoke(println("foo"))

//because we are passing a function by name, we can pass a code
//block with multiple statements
Invoker.invoke {
  println("bar 1")
  println("bar 2")
}
