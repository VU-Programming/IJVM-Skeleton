package pad.ijvm;

import org.junit.Test;
import pad.ijvm.interfaces.IJVMInterface;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class Task4 {

    IJVMInterface machine;

    @Test
    public void testSimpleLdcw() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task4/LoadTest1.ijvm"));
        machine.step();
        assertEquals("The first constant should be 1",machine.topOfStack(), 1);
        machine.step();
        assertEquals("The second constant should be 2", machine.topOfStack(), 2);
        machine.step();
        assertEquals("The third constant shoult be 3", machine.topOfStack(), 3);
    }

    @Test
    public void testSimpleLoad() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task4/LoadTest3.ijvm"));
        machine.step();
        assertEquals("The top of the stack should be 42", machine.topOfStack(), 42);
        machine.step();
        assertEquals("The top of the stack should be 1", machine.topOfStack(), 1);
        machine.step();
        assertEquals("The top of the stack should be 42 again", machine.topOfStack(), 42);
        machine.step();
        assertEquals("The top of the stack should be 2", machine.topOfStack(), 2);
        machine.step();
        assertEquals("The top of the stack should be 42 again", machine.topOfStack(), 42);
        machine.step();
        assertEquals("The top of the stack should be 3", machine.topOfStack(), 3);
        machine.step();
        assertEquals("The top of the stack should be 42 again", machine.topOfStack(), 42);
        machine.step();
        assertEquals("The top of the stack should be 3", machine.topOfStack(), 3);
        machine.step();
        assertEquals("The top of the stack should be 2", machine.topOfStack(), 2);
        machine.step();
        assertEquals("The top of the stack should be 1", machine.topOfStack(), 1);
        machine.step();
        machine.step();
        machine.step();
        assertEquals("The top of the stack should be 42", machine.topOfStack(), 42);
    }

    @Test
    public void testComplexLoad() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task4/LoadTest2.ijvm"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream p = new PrintStream(baos);
        machine.setOutput(p);
        machine.step();
        assertEquals("The top of the stack should be 42", machine.topOfStack(), 42);
        machine.step();
        assertEquals("The top of the stack should be 2", machine.topOfStack(), 2);
        machine.step();
        assertEquals("The top of the stack should be 2", machine.topOfStack(), 2);
        machine.step();
        assertEquals("The top of the stack should be 0", machine.topOfStack(), 0);
        machine.step();
        machine.step();
        assertEquals("The top of the stack should be 3", machine.topOfStack(), 3);
        machine.step();
        assertEquals("The top of the stack should be 42", machine.topOfStack(), 42);
        machine.step();
        assertEquals("The top of the stack should be 0", machine.topOfStack(), 0);
        machine.step();
        assertEquals("The top of the stack should be 3", machine.topOfStack(), 3);
        machine.step();
        assertEquals("The top of the stack should be 79", machine.topOfStack(), 79);
        machine.step();
        assertEquals("The top of the stack should be 3", machine.topOfStack(), 3);
        machine.step();
        assertEquals("The top of the stack should be 75", machine.topOfStack(), 75);
        machine.step();
        assertEquals("The top of the stack should be 3", machine.topOfStack(), 3);
    }

    @Test
    public void testIterationLoad() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task4/LoadTest4.ijvm"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream p = new PrintStream(baos);
        machine.setOutput(p);
        machine.run();
        assertEquals("This test should output 'kjihgfedcbaabcd'", "kjihgfedcbaabcd", baos.toString());
    }

}
