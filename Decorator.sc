trait OutputStream {
  def write(b: Byte)
  def write(b: Array[Byte])
}

class FileOutputStream(path: String) extends OutputStream {
  override def write(stream:Array[Byte]) = println("Writing array")
  override def write(b:Byte) = println("Writing byte")
}

trait Buffering extends OutputStream {
  abstract override def write(b: Byte) {
    println("Im in the enhanced class")
    super.write(b)
  }

  def ImTotallyNew = println("Im totally new")
}

val b:Byte = 'x'
val a:Array[Byte] = Array[Byte](1,2,3,4,5)

//Basic test case
val t1 = new FileOutputStream("foo.txt")
t1.write(b)
t1.write(a)

//Decorating t2 with enhanced functionity in the write case for a byte
val t2 = new FileOutputStream("foo.txt") with Buffering // with Filtering, ...
t2.write(b)
t2.write(a)
t2.ImTotallyNew

//t1.ImTotallyNew   --->This does not work, totally new not defined for t1


