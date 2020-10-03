package pl.snipersoft.wwtanks

import java.sql.DriverManager

import org.jooq.SQLDialect
import org.jooq.impl.DSL

class DataManager(private val configuration: DatabaseConfiguration) {
  def start(): Unit = {

  }
}

case class DatabaseConfiguration(url: String, username: String, password: String)

object Database {
  def initDatabase() {
    val configuration = DatabaseConfiguration(url = "jdbc:postgresql://localhost:5432/wwtanks", username = "postgres", password = "admin")
    val connection = DriverManager.getConnection(configuration.url, configuration.username, configuration.password)
    val dslContext = DSL.using(SQLDialect.POSTGRES)
  }
}