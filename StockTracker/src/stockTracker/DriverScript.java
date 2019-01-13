package stockTracker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

import net.ucanaccess.converters.TypesMap.AccessType;
import net.ucanaccess.ext.FunctionType;
import net.ucanaccess.jdbc.UcanaccessConnection;
import net.ucanaccess.jdbc.UcanaccessDriver;

public class DriverScript {

	public static void main(String args[]) throws ClassNotFoundException, SQLException {

/*		String url = "";
		String temp = "";
		url = "https://secure.icicidirect.com/IDirectTrading/Trading/FNO/GetQuote.aspx?FFO_PRDCT_TYP=F"
				+ "&FFO_UNDRLYNG=NIFTY&FFO_EXER_TYP=E&FFO_EXPRY_DT=26-Jul-2018&FFO_STRK_PRC=0"
				+ "&FFO_OPT_TYP=*&FFO_CTGRY_INDSTK=I&FFO_XCHNG_CD=NFO&FFO_MIN_LOT_QTY=75";
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		temp = driver.findElement(By.id("pnlGetQuote")).getText();
		System.out.println(temp.substring(temp.indexOf("LAST TRADED DATE"), temp.indexOf("LAST TRADED TIME")));
		System.out.println(temp.substring(temp.indexOf("LAST TRADED TIME"), temp.indexOf("Explain") - 1));
		System.out.println(temp.substring(temp.indexOf("LAST TRADE PRICE"), temp.indexOf("BEST BID PRICE")));
*/
		
		String databaseURL = "jdbc:ucanaccess://C:\\Users\\Aravinth\\DB\\Futures_detail.accdb";

		try (Connection connection = DriverManager.getConnection(databaseURL)) {

			String sql = "insert into Futures(ID,Date,Price,Time) VALUES ('1', ?, '89998', '15:29:59')";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setString(1, "1");
			//preparedStatement.setString(2, "26-07-2018");
			//preparedStatement.setDate(1, LocalDate.now().);
			//preparedStatement.setString(3, "89998");
			//preparedStatement.setString(4, "15:29:59");

			int row = preparedStatement.executeUpdate();

			if (row > 0) {
				System.out.println("A row has been inserted successfully.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}