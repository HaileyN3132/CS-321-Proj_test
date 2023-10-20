import static org.junit.Assert.*;
import org.junit.jupiter.api.*;

public class ValidationTester {

    @Test
    @DisplayName("Attempt to create new BO.")
    void newBOTest(){
        Business house = Business.createNewBO();
        assertTrue(house instanceof Business);
    }

    @Test
    @DisplayName("Attempt to set a name to the business object.")
    void setBOName(){
        Business house = Business.createNewBO();
        //house.setFirstName("John");
        String output = house.getFirstName();
        assertTrue(output.equals("John"));
    }

    @Test
    @DisplayName("Invalid Reference number to WorkFlow")
    void invalidWorkRef(){
        int status = WorkFlow.addWorkFlow("-1", "Reviewer");
        assertTrue(status == -1);
    }

    @Test
    @DisplayName("Invalid Employee to Workflow")
    void invalidWorkEmployee(){
        int status = WorkFlow.addWorkFlow("123", "Janitorial");
        assertTrue(status == -1);
    }

    @Test
    @DisplayName("Null Reference Number")
    void nullWorkRef(){
        int status = WorkFlow.addWorkFlow(null, "Reviewer");
        assertTrue(status == -1);
    }

    @Test
    @DisplayName("Null Employee")
    void nullWorkEmployee(){
        int status = WorkFlow.addWorkFlow("123", null);
        assertTrue(status == -1);
    }

    @Test
    @DisplayName("Both Null Workflow Input")
    void nullWorkAdd(){
        int status = WorkFlow.addWorkFlow(null, null);
        assertTrue(status == -1);
    }

    


    @Test
    @DisplayName("Attempt to add to the Reviewer's work load.")
    void addReviewWork(){
        int status = WorkFlow.addWorkFlow("123", "Reviewer");
        assertTrue(status == 1);
    }

    @Test
    @DisplayName("Attempt to read back that work.")
    void pullReviewWork(){
        String output = WorkFlow.getNextRef("Reviewer");
        assertTrue(output.equals("123"));
    }

    @Test
    @DisplayName("Attempt to read an empty Reviewer list.")
    void pullEmptyReview(){
        String output = WorkFlow.getNextRef("Reviewer");
        assertTrue(output.equals("Coffee Time"));
    }

    @Test
    @DisplayName("Attempt to add to the Approver's work load")
    void addApproverWork(){
        int status = WorkFlow.addWorkFlow("125", "Approver");
        assertTrue(status == 1);
    }

    @Test
    @DisplayName("Attempt to read back that work")
    void pullApproverWork(){
        String output = WorkFlow.getNextRef("Approver");
        assertTrue(output.equals("125"));
    }

    @Test
    @DisplayName("Attempt to read an empty Approver list.")
    void pullEmptyApprover(){
        String output = WorkFlow.getNextRef("Approver");
        assertTrue(output.equals("Coffee Time"));
    }

}
