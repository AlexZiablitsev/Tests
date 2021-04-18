package testData;

import enums.ProjectType;
import org.testng.annotations.DataProvider;

public class Provider {

    @DataProvider(name = "Create Project")
    public static Object[][] createData() {
        return new Object[][]{
                {"AZjablicev_01", "project1", false, ProjectType.SINGLE_FOR_ALL_CASES},
                {"AZjablicev_02", "project2", true, ProjectType.SINGLE_FOR_ALL_BASELINE},
                {"AZjablicev_03", "project3", true, ProjectType.MULTIPLE}
        };
    }

    @DataProvider(name = "Update Project")
    public static Object[][] updateData() {
        return new Object[][]{
                {"AZjablicev_01", "AZjablicev_02", "project2", false, ProjectType.MULTIPLE},
                {"AZjablicev_02", "AZjablicev_03", "project3", true, ProjectType.MULTIPLE},
                {"AZjablicev_03", "AZjablicev_04", "project4", false, ProjectType.SINGLE_FOR_ALL_BASELINE}
        };
    }

    @DataProvider(name = "Delete Project")
    public static Object[][] deleteData() {
        return new Object[][]{
                {"AZjablicev"}
        };
    }

}
