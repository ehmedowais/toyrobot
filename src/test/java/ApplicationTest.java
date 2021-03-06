import com.ows.dto.GameDTO;
import com.ows.modal.enums.CardinalDirection;
import com.ows.modal.enums.Command;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'muhammadahmed' at '14/06/21 1:49 PM' with Gradle 2.14-rc-5
 *
 * @author muhammadahmed, @date 14/06/21 1:49 PM
 */
public class ApplicationTest {
    @Test public void testSetDTOIfCommandLineValid() {
        String commandLine = "PLACE 1,2,NORTH";
        Optional<GameDTO> dtoUnderTest;
        dtoUnderTest = Application.setDTOIfCommandLineValid(commandLine);
        assertEquals(dtoUnderTest.get().getCommand(), Command.PLACE);
        assertEquals(dtoUnderTest.get().getDirection(), CardinalDirection.NORTH);
        assertEquals(dtoUnderTest.get().getPosition().getX(), 1);
        assertEquals(dtoUnderTest.get().getPosition().getY(), 2);
    }
}
