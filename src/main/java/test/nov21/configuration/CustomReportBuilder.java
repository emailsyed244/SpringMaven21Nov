package test.nov21.configuration;




import net.cucumber.ReportRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class CustomReportBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(CustomReportBuilder.class);

    private static final Thread THREAD = new Thread() {
        public void run() {
             String cucumberJsonFile =System.getProperty("user.dir")+"/target/cucumber.json";//WebConnect.getCucumberJsonFile();
             String reportOutputRoot = System.getProperty("user.dir")+"/target2/";//WebConnect.getReportOutputRoot();
             String project = "PPI";//WebConnect.getReportProject();
             String env = "QED";//System.getProperty("baseTest").toUpperCase();
             String browser = "firefox";//System.getProperty("driverType").toUpperCase();

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            String dateString = new SimpleDateFormat("dd-MMM-yyyy").format(date);
            String time = new SimpleDateFormat("HH.mm.ss").format(date);

            String reportOutputDirectory = reportOutputRoot + "\\" + dateString + "\\" + time;

            String customText = project + "<h3><BR/> Environment: <font color=\"red\">" + env + "</font>     Browser : <font color=\"blue\">" + browser + "</font>" + "     Run At: <font color=\"blue\">" + dateFormat.format(date) + "</font></h3>";
            System.out.println(System.getProperty("user.dir"));
        //    File reportOutputDirectory = new File("target");//+ "\\" + dateString + "\\" + time);
            List<String> jsonFiles = new ArrayList<>();
            jsonFiles.add("cucumber.json");
            try {

                new ReportRunner(cucumberJsonFile, reportOutputDirectory, customText, date);
            } catch (Exception e) {
                System.out.println("Unable to create Custom Report \n" + e.getMessage());
            }
        }
   };
    private static boolean hookRegistered = false;

    public static void runOnShutDown() {
        if (!hookRegistered) {
            Runtime.getRuntime().addShutdownHook(THREAD);
            hookRegistered = true;
        }
    }

}
