package db

import anorm._ 
import play.api.db.DB
import play.api.Play.current

// use a case class to model the stuff you save in a table
case class Polls(id: Long, pollName: String, userID: BigInt)

object Polls {
  // creates the table in the database
  def createTable() {
    DB.withConnection { implicit c => 
      SQL (createStmt).execute()
    } 
  }
  
  val insertStmt = "INSERT INTO polls (pollName, userid) VALUES ({pollName}, {userid})"
  def addPolls(pollName: String, userID: BigInt) {
    DB.withConnection { implicit c =>
      SQL(insertStmt).on('pollName -> pollName, 'userID -> userID).execute()  
    }
  }
  
  val idQuery = "SELECT id, pollName, first, last FROM Polls WHERE id={id}"
  def getById(id: Long): Option[Polls] = {
    val query = SQL(idQuery).on('id -> id)
    DB.withConnection { implicit c =>
      query().map {
        case Row(theId: Long, pollName: String, userID: BigInt) => Polls(theId, pollName, userID)
      }.headOption
    }
  }
  
  val pollNameQuery = "SELECT id, pollName, userID FROM Polls WHERE pollName={pollName}"
  def getBypollName(pollName: String): Option[Polls] = {
    val query = SQL(pollNameQuery).on('pollName -> pollName)
    DB.withConnection { implicit c => 
      query().map {
        case Row(theId: Long, pollName: String, userID: BigInt) => Polls(theId, pollName, userID)
      }.headOption  
    }
  }
  
  def listPolls(): List[Polls] = {
    val query = SQL("SELECT id, pollName, userID FROM Polls")
    DB.withConnection { implicit c =>
      query().map {
        case Row(theId: Long, pollName: String, userID: BigInt) => Polls(theId, pollName, userID)
      }.toList
    }
  }
//  val passwordUpdate = "UPDATE Polls SET pwHash={pwHash} WHERE id={id}"
//  def setPassword(id: Long, newPassword: String) {
//    DB.withConnection { implicit c =>
//      SQL(passwordUpdate).on('pwHash -> PasswordFramework.hash(newPassword), 'id -> id).execute()  
//    }
//  }
//  def setPassword(pollName: String, newPassword: String) {
//    getBypollName(pollName).map((u: Polls) => setPassword(u, newPassword))
//  }
//  def setPassword(Polls: Polls, newPassword: String) {
//    setPassword(Polls.id, newPassword)
//  }
//  
//  val getPassword = "SELECT pwHash FROM Polls WHERE id={id}"
//  def checkPassword(id: Long, password: String): Boolean = {
//    val query = SQL(getPassword).on('id -> id)
//    DB.withConnection { implicit c =>
//      val pwHash: Option[String] = query().map {
//        case Row(Some(pw: String)) => pw
//      }.headOption
//      pwHash.map(encoded => PasswordFramework.checks(password, encoded)).getOrElse(false)
//    }
//  }
//  def checkPassword(pollName: String, password: String): Boolean = {
//    getBypollName(pollName).map((u: Polls) => checkPassword(u, password)).getOrElse(false)
//  }
//  def checkPassword(u: Polls, password: String): Boolean = {
//    checkPassword(u.id, password)
//  }

  // SQL statements
  // Note that these use Scala's multi-line strings and the
  // stripMargin method, so the strings look pretty
  
  val createStmt = 
  """CREATE TABLE polls (
    |  id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    |  pollName VARCHAR(100),
    |  userid BIGINT
    |  FOREIGN KEY (userid) REFERENCES users (id)
  )""".stripMargin

  
}