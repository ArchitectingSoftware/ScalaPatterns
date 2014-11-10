case class User(userName:String, password: String, firstName:String, lastName:String)
trait Repository {
  def save(user: User)
}

//we are going to inject this as a dependency
trait DatabaseRepository extends Repository {
  def save(user:User) = {
    println("Saving User Name: "+user.userName+ " to disk")
  }
}

//we are going to inject this as a dependency
trait InMemoryRepository extends Repository {
  def save(user:User) = {
    println("Saving User Name: "+user.userName+ " to memory")
  }
}

//The self:Repository annotation indicates that the User
//service requires a trait to be mixed in that is a repository
//or inherits from a Repository
trait UserService { self: Repository => // requires Repository
  def create(user: User) = {
    // works becuase a respository  was injected
    save(user)
  }
}

val userInDatabase = new UserService with DatabaseRepository
userInDatabase.create(new User("brian","foo","brian","mitchell"))

val userInMemory = new UserService with InMemoryRepository
userInMemory.create(new User("brian","foo","brian","mitchell"))
