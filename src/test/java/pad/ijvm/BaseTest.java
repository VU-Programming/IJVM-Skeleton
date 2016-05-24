package pad.ijvm;

import pad.ijvm.interfaces.IJVMInterface;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;

public class BaseTest {

    IJVMInterface machine;

    @Before
    public void setUp() throws Exception {
        machine = MachineFactory.createIJVMMachine(new File("files/testmem.bin"));
    }

    @After
    public void tearDown() throws Exception {

    }

    // BEGIN Test scenarios
    @Test
    public void testBipush() throws Exception {
        assertEquals(true, true);
    }

    @Test
    public void testBipushSignedness() throws Exception {

    }

    @Test
    public void testStackSize() throws Exception {

    }



    @Test
    public void testIadd() throws Exception {

    }

    @Test
    public void testLdcw() throws Exception {

    }




    // END Test scenarios

    @Test
    public void testTopOfStack() throws Exception {

    }

    @Test
    public void testGetProgramCounter() throws Exception {

    }

    @Test
    public void testGetStackPointer() throws Exception {

    }

    @Test
    public void testGetLocalVariable() throws Exception {

    }

    @Test
    public void testGetConstant() throws Exception {

    }

    @Test
    public void testStep() throws Exception {

    }

    @Test
    public void testRun() throws Exception {

    }
}
