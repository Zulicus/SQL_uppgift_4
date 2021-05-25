package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ResultBean;

public class SQL_connection {

	static Connection conn = null;
	static PreparedStatement stmt = null;
	static ResultSet rs = null;
	public static ArrayList<ResultBean> list;

	public static boolean connectSQL() {

		try {
			// Driver setup
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Exception Driver: " + e.getMessage());
			return false;
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dumble", DatabaseLogin.getuName(),
					DatabaseLogin.getuPass());
			return true;
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
			System.out.println("SQL State: " + e.getSQLState());
			System.out.println("Vendor Error: " + e.getErrorCode());
			return false;
		}
	}

	// returns an Array of results
	public static ArrayList<ResultBean> stateSQL(String input) {
		list = new ArrayList<ResultBean>();
		try {
			searchIcp(input);
			searchBear(input);
			searchIkea(input);
			if (input.contains(" ")) {
				String[] inputArray = input.split(" ");
				for (int i = 0; i < inputArray.length; i++) {
					if (inputArray[i].length() > 3) {
						searchIcp(inputArray[i]);
						searchBear(inputArray[i]);
						searchIkea(inputArray[i]);
					}
				}
			}
			conn.endRequest();
			conn.close();
		} catch (SQLException e) {
			displayErrorMesage(e);
		}
		return list;
	}

	private static void displayErrorMesage(SQLException e) {
		System.out.println("SQL Exception: " + e.getMessage());
		System.out.println("SQL State: " + e.getSQLState());
		System.out.println("Vendor Error: " + e.getErrorCode());

	}

	private static ArrayList<ResultBean> search(String requestQuery, String input) {
		try {
			stmt = conn.prepareStatement(requestQuery);
			stmt.setString(1, "%" + input + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				ResultBean bean = new ResultBean();
				for (int i = 1; i <= 17; i++) {
					try {
						switch (i) {
						case 1:
							if (rs.getString(i) != null) {
								bean.setColumn1("\"" + rs.getString(i) + "\"");
							}
							break;
						case 2:
							if (rs.getString(i) != null) {
								bean.setColumn2("\"" + rs.getString(i) + "\"");
							}
							break;
						case 3:
							if (rs.getString(i) != null) {
								bean.setColumn3("\"" + rs.getString(i) + "\"");
							}
							break;
						case 4:
							if (rs.getString(i) != null) {
								bean.setColumn4("\"" + rs.getString(i) + "\"");
							}
							break;
						case 5:
							if (rs.getString(i) != null) {
								bean.setColumn5("\"" + rs.getString(i) + "\"");
							}
							break;
						case 6:
							if (rs.getString(i) != null) {
								bean.setColumn6("\"" + rs.getString(i) + "\"");
							}
							break;
						case 7:
							if (rs.getString(i) != null) {
								bean.setColumn7("\"" + rs.getString(i) + "\"");
							}
							break;
						case 8:
							if (rs.getString(i) != null) {
								bean.setColumn8("\"" + rs.getString(i) + "\"");
							}
							break;
						case 9:
							if (rs.getString(i) != null) {
								bean.setColumn9("\"" + rs.getString(i) + "\"");
							}
							break;
						case 10:
							if (rs.getString(i) != null) {
								bean.setColumn10("\"" + rs.getString(i) + "\"");
							}
							break;
						case 11:
							if (rs.getString(i) != null) {
								bean.setColumn11("\"" + rs.getString(i) + "\"");
							}
							break;
						case 12:
							if (rs.getString(i) != null) {
								bean.setColumn12("\"" + rs.getString(i) + "\"");
							}
							break;
						case 13:
							if (rs.getString(i) != null) {
								bean.setColumn13("\"" + rs.getString(i) + "\"");
							}
							break;
						case 14:
							if (rs.getString(i) != null) {
								bean.setColumn14("\"" + rs.getString(i) + "\"");
							}
							break;
						case 15:
							if (rs.getString(i) != null) {
								bean.setColumn15("\"" + rs.getString(i) + "\"");
							}
							break;
						case 16:
							if (rs.getString(i) != null) {
								bean.setColumn16("\"" + rs.getString(i) + "\"");
							}
							break;
						case 17:
							if (rs.getString(i) != null) {
								bean.setColumn17("\"" + rs.getString(i) + "\"");
							}
							break;
						default:
							break;
						}
					} catch (Exception e) {
						// System.out.println(e);
					}
				}
				boolean noDuplicate = true;

				for (int i = 0; i < list.size(); i++) {

					if (list.get(i).getColumn1().equals(bean.getColumn1())
							&& list.get(i).getColumn2().equals(bean.getColumn2())
							&& list.get(i).getColumn3().equals(bean.getColumn3())
							&& list.get(i).getColumn4().equals(bean.getColumn4())
							&& list.get(i).getColumn5().equals(bean.getColumn5())
							&& list.get(i).getColumn6().equals(bean.getColumn6())
							&& list.get(i).getColumn7().equals(bean.getColumn7())
							&& list.get(i).getColumn8().equals(bean.getColumn8())
							&& list.get(i).getColumn9().equals(bean.getColumn9())
							&& list.get(i).getColumn10().equals(bean.getColumn10())
							&& list.get(i).getColumn11().equals(bean.getColumn11())
							&& list.get(i).getColumn12().equals(bean.getColumn12())
							&& list.get(i).getColumn13().equals(bean.getColumn13())
							&& list.get(i).getColumn14().equals(bean.getColumn14())
							&& list.get(i).getColumn15().equals(bean.getColumn15())
							&& list.get(i).getColumn16().equals(bean.getColumn16())
							&& list.get(i).getColumn17().equals(bean.getColumn17())) {
						noDuplicate = false;
					}
				}

				if (noDuplicate) {
					list.add(bean);
				}
			}
			rs.close();
		} catch (SQLException e) {
			displayErrorMesage(e);
		}
		return null;
	}

	private static void searchIcp(String input) {
		String requestQuery = "SELECT `Character`,`Origin`,`Creator`,`Notes` FROM bearbase WHERE CONCAT_WS( `Character`, `Origin`, `Creator`, `Notes` ) LIKE ?";
		search(requestQuery, input);

	}

	private static void searchIkea(String input) {
		String requestQuery = "SELECT `name`,`description`,`Column_3`,`Column_4`,`Column_5` FROM ikea_names WHERE CONCAT_WS( `name`, `description`, `Column_3`, `Column_4`, `Column_5` ) LIKE ?";
		search(requestQuery, input);

	}

	private static void searchBear(String input) {
		String requestQuery = "SELECT `SCP`, `Title`, `rating`, `Classification`, `Type`, `Related_GOI_s`, `Location_Notes`, `Author`, `Leaked_info`, `Humanoid_or_Structure`, `Animal_Computer_or_Extradimensional`, `Autonomous_or_Cognitohazard`, `Artifact_Location_or_Sentient`, `Summary`, `Gender`, `None`, `Ethnicity_Origins` FROM masterscplist WHERE CONCAT_WS( `SCP`, `Title`, `rating`, `Classification`, `Type`, `Related_GOI_s`, `Location_Notes`, `Author`, `Leaked_info`, `Humanoid_or_Structure`, `Animal_Computer_or_Extradimensional`, `Autonomous_or_Cognitohazard`, `Artifact_Location_or_Sentient`, `Summary`, `Gender`, `None`, `Ethnicity_Origins` ) LIKE ?";
		search(requestQuery, input);
	}

}
