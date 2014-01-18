package db

import anorm._ 
import play.api.db.DB
import play.api.Play.current

// use a case class to model the stuff you save in a table
case class Question(id: Long, text: String, pollID: BigInt)

object Questions {
  // creates the table in the database
  def createTable() {
    DB.withConnection { implicit c => 
      SQL(createStmt).execute()
    } 
  }
  
  def addQuestions(text: String, pollID: BigInt) {
    DB.withConnection { implicit c =>
      SQL(insertStmt).on('text -> text, 'pollID -> pollID).execute()  
    }
  }
  
  val questionQuery = "SELECT id, text, pollID FROM Questions WHERE id={id}"
  def getById(id: Long): Option[Question] = {
    val query = SQL(questionQuery).on('id -> id)
    DB.withConnection { implicit c =>
      query().map {
        case Row(theId: Long, text: String, pollID: BigInt) => Question(theId, text, pollID)
      }.headOption
    }
  }
  
  val textQuery = "SELECT id, text, pollID FROM Questions WHERE text={text}"
  def getBytext(text: String): Option[Question] = {
    val query = SQL(textQuery).on('text -> text)
    DB.withConnection { implicit c => 
      query().map {
        case Row(theId: Long, text: String, pollID: BigInt) => Question(theId, text, pollID)
      }.headOption  
    }
  }
  
  val createStmt = 
    """CREATE TABLE questions (
      |  id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
      |  text VARCHAR(500) NOT NULL,
      |  pollID BIGINT
      |  FOREIGN KEY (pollID) REFERENCES polls (userID)
    )""".stripMargin

  val insertStmt = "INSERT INTO polls (text, pollID) VALUES ({text}, {pollID})"
}