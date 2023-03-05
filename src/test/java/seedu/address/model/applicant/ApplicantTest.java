package seedu.address.model.applicant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_APPLICANT_NAME_BENEDICT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_APPLICANT_NAME_CHRIS;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalApplicants.BENEDICT;
import static seedu.address.testutil.TypicalApplicants.CHRIS;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.ApplicantBuilder;

public class ApplicantTest {

    @Test
    public void isSamePerson() {
        // same object -> returns true
        assertTrue(BENEDICT.isSameApplicant(BENEDICT));

        // null -> returns false
        assertFalse(BENEDICT.isSameApplicant(null));

        // name differs in case -> false
        Applicant editedChris = new ApplicantBuilder(CHRIS).withName(VALID_APPLICANT_NAME_CHRIS.toLowerCase()).build();
        assertFalse(CHRIS.isSameApplicant(editedChris));

        // name has trailing spaces -> true
        String nameWithTrailingSpaces = VALID_APPLICANT_NAME_CHRIS + " ";
        editedChris = new ApplicantBuilder(CHRIS).withName(nameWithTrailingSpaces).build();
        assertTrue(CHRIS.isSameApplicant(editedChris));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Applicant benedictCopy = new ApplicantBuilder(BENEDICT).build();
        assertTrue(BENEDICT.equals(benedictCopy));

        // same object -> returns true
        assertTrue(BENEDICT.equals(BENEDICT));

        // null -> returns false
        assertFalse(BENEDICT.equals(null));

        //different type -> return false
        assertFalse(BENEDICT.equals(5));

        //different applicant -> return false
        assertFalse(BENEDICT.equals(CHRIS));

        //different name -> return false
        Applicant editedBenedict = new ApplicantBuilder(BENEDICT).withName(VALID_APPLICANT_NAME_CHRIS).build();
        assertFalse(BENEDICT.equals(editedBenedict));
    }
}
