//Example1: Built in tuple
val point_v1 = (1,2)

//Example 2: Using a type alias for tuple
type Point = (Int, Int)
val point_v2 = new Point(1,2)

//Example 3: Using a case class
case class PointClass (x:Int, y:Int)
val point_v3 = PointClass(1,2)
