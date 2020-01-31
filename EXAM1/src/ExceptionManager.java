import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

public class ExceptionManager {
    private Date date;
    private String className;
    private int lineNumber;
    private String methodeName;

    public ExceptionManager(Exception e) {
        date = new Date();
        className = e.getStackTrace()[0].getClassName();
        lineNumber = e.getStackTrace()[0].getLineNumber();
        this.methodeName = e.getStackTrace()[0].getMethodName();
    }
    public void saveAsText() {
        try {
            File f = new File("log.txt");
            if (!f.exists()) {
                f.createNewFile();
            }
            FileWriter fr = new FileWriter(f, true);

            BufferedWriter br = new BufferedWriter(fr);
            br.write(date + "   " + className + "   " + lineNumber + "  " + methodeName);
            br.newLine();
            br.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public void saveAsXML() {
        try {

            File f = new File("log.xml");
            if (!f.exists()) {
                f.createNewFile();
            }
            FileWriter fr = new FileWriter(f, true);
            List<String> list = Files.readAllLines(Paths.get("log.xml"));

            if (list.isEmpty()) {
                list.add("<Exceptions>");
                list.add("</Exceptions>");
            }
            list.add(list.size() - 1, "<exception>");
            list.add(list.size() - 1, "<date>" + date.toString() + "</date>");
            list.add(list.size() - 1, "<class>" + className + "</class>");
            list.add(list.size() - 1, "<method>" + methodeName + "</method>");
            list.add(list.size() - 1, "<line>" + lineNumber + "</line>");
            list.add(list.size() - 1, "</exception>");

            Files.write(Paths.get("log.xml"), list);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
