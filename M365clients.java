//Written by Anthony Spears
//4/14/21
//provided a .csv with two columns, column A being the SID of an M365 client from the partner portal,
//and column B being the client name, this program will produce a .html file with hyper links to each
//client's M365 admin center. 

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class M365clients {

    public static void main(String[] args) throws IOException {
        Writer outFile = new FileWriter("M365CustomerAdminCenter.html");
        Scanner inFile = new Scanner(new File("Cleaned Customers.csv"));
        String clients = "";
        while (inFile.hasNextLine()) {
            clients += inFile.nextLine()+",";

        }
        String[] sID = clients.split(",");
        String frontHalf = "<a href=\"https://portal.office.com/Partner/BeginClientSession.aspx?CTID=";
        String backHalf = "&CSDEST=o365admincenter\"target=\"_blank\">";

        for (int i = 0; i < sID.length; i++) {
            String MSID = "";
            if (i % 2 == 0) {
                MSID = sID[i];
                outFile.write(frontHalf + MSID + backHalf +sID[i + 1]+"</a><p>\n\n");
                System.out.println(frontHalf + MSID + backHalf +sID[i + 1]+"</a><br>");
            }
        }outFile.close();
    }
}