import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;

public class MergeXml {

    public static void main(String[] args) throws Exception {

        // Creates file to write to
        Writer output = null;
        output = new BufferedWriter(new FileWriter("/home/sindhuja/NetBeansProjects/sidzz/src/sidzz/persondata.xml"));
        String newline = System.getProperty("line.separator");

        output.write("<persondata>");

        // Read in xml file 1
        FileInputStream in = new FileInputStream("/home/sindhuja/NetBeansProjects/sidzz/src/sidzz/file1.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;

        while ((strLine = br.readLine()) != null) {

            if (strLine.contains("<geodata>")) {
                strLine = strLine.replace("<geodata>", "");
            }
            if (strLine.contains("</geodata>")) {
                strLine = strLine.replace("</geodata>", "");
            }
            output.write(newline);
            output.write(strLine);
        
        }

        // Read in xml file 2
        FileInputStream in2 = new FileInputStream("/home/sindhuja/NetBeansProjects/sidzz/src/sidzz/file2.xml");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
        String strLine2;

        while ((strLine2 = br2.readLine()) != null) {

            if (strLine2.contains("<salarydata>")) {
                strLine2 = strLine2.replace("<salarydata>", "");
            }
            if (strLine2.contains("</salarydata>")) {
                strLine2 = strLine2.replace("</salarydata>", "");
            }

            output.write(strLine2);
            output.write(newline);
        }

        output.write("</persondata>");
        output.close();

        System.out.println("XML files merged successfully");

    }

}