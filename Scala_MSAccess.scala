//
// 
// To Compile, run the following command:
// scalac -classpath "lib/ucanaccess-5.0.1.jar;lib/jackcess-4.0.5.jar;lib/hsqldb-2.5.0.jar;lib/commons-logging-1.2.jar;lib/commons-lang3-3.8.1.jar" Scala_MSAccess.scala
//
// To Launch the program, run the following command:
// scala -classpath "lib/ucanaccess-5.0.1.jar;lib/jackcess-4.0.5.jar;lib/hsqldb-2.5.0.jar;lib/commons-logging-1.2.jar;lib/commons-lang3-3.8.1.jar" Scala_MSAccess.scala 
//


import java.sql.{Connection, DriverManager, ResultSet}

// NEW NEW
import net.ucanaccess.converters.TypesMap.AccessType;
import net.ucanaccess.ext.FunctionType;
import net.ucanaccess.jdbc.UcanaccessConnection;
import net.ucanaccess.jdbc.UcanaccessDriver;

object ScalaConnectToMSAccess {
  def main(args: Array[String]): Unit = {

    val url = "jdbc:ucanaccess://C:/Projects/MyAccessDB.accdb"
    val username = ""
    val password = ""

    // Load the ODBC driver
    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver")

    // Establish a connection
    val connection: Connection = DriverManager.getConnection(url, username, password)

    // Execute queries or perform database operations
    val statement = connection.createStatement()
    val resultSet: ResultSet = statement.executeQuery("SELECT customer_id, account_status FROM tableOne")

    while (resultSet.next()) {
      val column1Value = resultSet.getInt("customer_id")
      val column2Value = resultSet.getString("account_status")
      // Process retrieved data as needed
      println(s"customer_id: $column1Value, account_status: $column2Value")
    }

    // Close resources
    resultSet.close()
    statement.close()
    connection.close()
  }
}
