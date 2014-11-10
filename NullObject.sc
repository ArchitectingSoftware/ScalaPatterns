trait Sound {
  def play()
}

class Music extends Sound {
  def play(): Unit = {
    println("Im playing music")
  }
}

object SoundSource {
  def getSound: Option[Sound] = {
    val available = true
    //val available = false
    if (available) Some (new Music) else None
  }
}

//option 1: Upack with a for comprehension
for (sound <- SoundSource.getSound) {
  sound.play()
}

//option 2: use map to unpack
SoundSource.getSound map (_.play())

//option 3: use scala pattern matching
SoundSource.getSound match{
  case Some(stuff) => stuff.play();
  case None => println("Nothing to play")
}
