
import java.io.*;
import java.sql.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class Sidzz {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "sindhu", "root");
            Statement st = con.createStatement();
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

//            BufferedReader br = new BufferedReader(new FileReader(new File("/home/sindhuja/NetBeansProjects/sidzz/src/sidzz/persondata.xml")));
//            String line;
//            StringBuilder sb = new StringBuilder();
//
//            while ((line = br.readLine()) != null) {
//                sb.append(line.trim());
//            }
//            String strFileContent = sb.toString();
            
         
            Document doc = docBuilder.parse(new File("/home/sindhuja/NetBeansProjects/sidzz/src/sidzz/persondata.xml"));

            doc.getDocumentElement().normalize();
            System.out.println("Root element of the doc is "
                    + doc.getDocumentElement().getNodeName());

            NodeList listOfPersons = doc.getElementsByTagName("row");
          

            for (int s = 0; s < listOfPersons.getLength(); s++) {
                Node firstPersonNode = listOfPersons.item(s);
                if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element firstPersonElement = (Element) firstPersonNode;
                    // -------------------------------------------------------------------------------------

                    NodeList NameList = firstPersonElement.getElementsByTagName("person_name");
                    Element NameElement = (Element) NameList.item(0);

                    NodeList textNMList = NameElement.getChildNodes();
                    String Name = ((Node) textNMList.item(0)).getNodeValue().trim();

                    NodeList AddrList = firstPersonElement.getElementsByTagName("address");
                    Element AddrElement = (Element) AddrList.item(0);

                    NodeList textADList = AddrElement.getChildNodes();
                    String Address = ((Node) textADList.item(0)).getNodeValue()
                            .trim();

                    NodeList PhoneList = firstPersonElement.getElementsByTagName("phonenumber");
                    Element PhoneElement = (Element) PhoneList.item(0);

                    NodeList textCTList = PhoneElement.getChildNodes();
                    String PhoneNumber = ((Node) textCTList.item(0)).getNodeValue().trim();

                    NodeList SalaryList = firstPersonElement.getElementsByTagName("salary");
                    Element SalaryElement = (Element) SalaryList.item(0);

                    NodeList textSAList = SalaryElement.getChildNodes();
                    String Salary = ((Node) textSAList.item(0)).getNodeValue().trim();

                    NodeList PensionList = firstPersonElement.getElementsByTagName("pension");
                    Element PensionElement = (Element) PensionList.item(0);

                    NodeList textPTList = PensionElement.getChildNodes();
                    String Pension = ((Node) textCTList.item(0)).getNodeValue().trim();

                    int i = st.executeUpdate(
                            "insert into persondata(person_name,address,phonenumber,salary,pension) values('"
                            + Name
                            + "','"
                            + Address
                            + "','"
                            + PhoneNumber
                            + "','"
                            + Salary
                            + "','"
                            + Pension
                            + "')");
                }
            }
            System.out.println("Data is successfully inserted!");

        } catch (Exception err) {
            System.out.println(" " + err.getMessage());
        }
    }
}
