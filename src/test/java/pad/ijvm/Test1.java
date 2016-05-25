package pad.ijvm;

import pad.ijvm.interfaces.IJVMInterface;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

public class Test1 {

    IJVMInterface machine;

    @Test
    public void testMachineFactory() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task1/program1.ijvm"));
        assertNotNull("MachineFactory not implemented, returned null.", machine);
    }

    @Test
    public void testProgram1() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task1/program1.ijvm"));
        byte[] text = machine.getText();

        assertTrue("Length of 'method' block should be equal to 6.", text.length == 6);
        assertTrue("First instruction should be equal to 'BIPUSH'.", text[0] == (byte) 0x10);
        assertTrue("Second instruction should be equal to 'BIPUSH'.", text[2] == (byte) 0x10);
        assertTrue("Third instruction should be equal to 'IADD'.", text[4] == (byte) 0x31);
        assertTrue("Fourth instruction should be equal to 'OUT'.", text[5] == (byte) 0x60);
    }

    @Test
    public void testProgram2() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task1/program2.ijvm"));
        byte[] text = machine.getText();

        assertTrue("Length of 'method' block should be equal to 12.", text.length == 6);
        assertTrue("First instruction should be equal to 'NOP'.", text[0] == (byte) 0x00);
        assertTrue("Second instruction should be equal to 'LDC_W'.", text[1] == (byte) 0x13);
        assertTrue("Third instruction should be equal to 'DUP'.", text[3] == (byte) 0x59);
        assertTrue("Fourth instruction should be equal to 'LDC_W'.", text[4] == (byte) 0x13);
        assertTrue("Fifth instruction should be equal to 'IADD'.", text[6] == (byte) 0x60);
        assertTrue("Sixth instruction should be equal to 'LDC_W'.", text[7] == (byte) 0x13);
        assertTrue("Seventh instruction should be equal to 'IADD'.", text[9] == (byte) 0x60);
        assertTrue("Eight instruction should be equal to 'OUT'.", text[10] == (byte) 0xFD);
        assertTrue("Ninth instruction should be equal to 'NOP'.", text[11] == (byte) 0x00);
    }

    @Test
    public void testProgramCounter() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task1/program2.ijvm"));

        assertTrue("Program counter should be initialized to 0", machine.getProgramCounter() == 0);
    }
}
