package pl.snipersoft.wwtanks

import java.sql.DriverManager

import org.jooq.{Record, Result, SQLDialect}
import org.jooq.impl.DSL
import pl.snipersoft.wwtanks.jooq.Tables

class DataManager(private val configuration: DatabaseConfiguration) {
  def start(): Unit = {

  }
}

case class DatabaseConfiguration(url: String, username: String, password: String)

object Database {
  def initDatabase() {
    val configuration = DatabaseConfiguration(url = "jdbc:postgresql://localhost:5432/wwtanks", username = "postgres", password = "admin")
    val connection = DriverManager.getConnection(configuration.url, configuration.username, configuration.password)
    val dslContext = DSL.using(connection, SQLDialect.POSTGRES)
    val result: Result[Record] = dslContext.select().from(Tables.TANKS).fetch()
    println(result)
    val dtos = result.map(it => Tank(id = it.getValue(Tables.TANKS.ID), textId = it.getValue(Tables.TANKS.TEXT_ID),
      name = it.getValue(Tables.TANKS.NAME)))
    println(dtos)
    connection.close()
  }
}

case class Tank(id: Int, textId: String, name: String)