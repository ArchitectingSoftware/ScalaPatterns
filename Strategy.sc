type Strategy = (Int, Int) => Int

class Context(stratImpl: Strategy) {
  def use(a: Int, b: Int) = {
    stratImpl(a, b)
  }
}

val add: Strategy = _ + _
val multiply: Strategy = _ * _

new Context(multiply).use(2, 3)
new Context(add).use(2,3)
