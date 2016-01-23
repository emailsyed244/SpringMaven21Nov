package test.nov21.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by UC181137 on 23/01/2016.
 */
@Component
public class Util {

    public static String cucumberJsonFile;
    public static String reportOutputRoot;
    public static String reportProject;
    public static String baseTest;


    @Value("${baseTest}")
    public void setBaseTest(String baseTest1) {
        baseTest=baseTest1;
        System.out.println("Test Base in method : "+baseTest);
    }

    @Value("${cucumberJsonFile}")
    public void setCucumberJsonFile(String cucumberJsonFile1) {
        cucumberJsonFile = cucumberJsonFile1;
        System.out.println("CucumberJasonFile in method : "+cucumberJsonFile);
    }

    @Value("${reportOutputRoot}")
    public void setReportOutputRoot(String reportOutputRoot1) {
        reportOutputRoot = reportOutputRoot1;
    }

    @Value("${reportProject}")
    public void setReportProject(String reportProject1) {
        reportProject = reportProject1;
    }
//    @Value("${project}")
//    public void setProject(String project1) {
//        project=project1;
//        System.out.println("Project in method : "+project);
//    }

}
