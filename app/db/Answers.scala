package db

import anorm._ 
import play.api.db.DB
import play.api.Play.current

// use a case class to model the stuff you save in a table
case class Answers(id: Long, content: String, votes: BigInt, questionID: BigInt)

object Answer {
  // creates the table in the database
  def createTable() {
    DB.withConnection { implicit c => 
      SQL (createStmt).execute()
    } 
  }
  
  val insertStmt = "INSERT INTO answers (content, votes) VALUES ({content}, {votes})"
  def addAnswers(content: String, votes: BigInt, questionID: BigInt) {
    DB.withConnection { implicit c =>
      SQL(insertStmt).on('content -> content, 'votes -> votes).execute()  
    }
  }
  
  val idQuery = "SELECT id, content, first, last FROM Answers WHERE id={id}"
  def getById(id: Long): Option[Answers] = {
    val query = SQL(idQuery).on('id -> id)
    DB.withConnection { implicit c =>
      query().map {
        case Row(theId: Long, content: String, votes: BigInt, questionID: BigInt) => Answers(theId, content, votes)
      }.headOption
    }
  }
  
  val contentQuery = "SELECT id, content, votes FROM Answers WHERE content={content}"
  def getBycontent(content: String): Option[Answers] = {
    val query = SQL(contentQuery).on('content -> content)
    DB.withConnection { implicit c => 
      query().map {
        case Row(theId: Long, content: String, votes: BigInt) => Answers(theId, content, votes)
      }.headOption  
    }
  }
  
  def listAnswers(): List[Answers] = {
    val query = SQL("SELECT id, content, votes FROM Answers")
    DB.withConnection { implicit c =>
      query().map {
        case Row(theId: Long, content: String, votes: BigInt) => Answers(theId, content, votes)
      }.toList
    }
  }

  // SQL statements
  // Note that these use Scala's multi-line strings and the
  // stripMargin method, so the strings look pretty
  
  val createStmt = 
  """CREATE TABLE answers (
    |  id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    |  content VARCHAR(100),
    |  votes BIGINT
    |  FOREIGN KEY (votes) REFERENCES polls (id)
  )""".stripMargin

  
}