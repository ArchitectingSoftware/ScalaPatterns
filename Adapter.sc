case class Level(msg:String)
object Level{
  val WARNING = new Level("WARNING>> ")
  val ERROR = new Level("ERROR>> ")
}
//Scala trick import the object to get access to the methods/properties
import Level._

trait Log {
  def warning(message: String)
  def error(message: String)
}

final class Logger {
  def echo(level: Level, message: String) { println(level.msg +" "+message) }
}

implicit class LoggerToLogAdapter(logger: Logger) extends Log {
  def warning(message: String) { logger.echo(WARNING, message) }
  def error(message: String)   { logger.echo(ERROR, message) }
}


val log: Log = new Logger() //basically equals                             //val log = new LoggerToLogAdapter(new Logger())
log.error("Something Bad has happened!")
log.warning("Just a warning to consider...")