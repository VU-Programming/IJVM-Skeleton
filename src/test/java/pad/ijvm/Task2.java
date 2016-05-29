package pad.ijvm;


import pad.ijvm.interfaces.IJVMInterface;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class Task2 {

    IJVMInterface machine;



    @Test
    public void testSimpleBipush() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task2/TestBipush1.ijvm"));

        machine.step();
        assertEquals("The top of the stack should be 42", machine.topOfStack(), 42);
    }

    @Test
    public void testSignedBipush() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task2/TestBipush2.ijvm"));

        machine.step();
        assertEquals("The top of the stack should be -42", machine.topOfStack(), -42);
    }

    @Test
    public void testSimpleIadd() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task2/TestIadd1.ijvm"));

        machine.step();
        machine.step();
        machine.step();
        assertEquals("The result of IADD should be 60", machine.topOfStack(), 60);
    }

    @Test
    public void testSignedIadd() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task2/TestIadd2.ijvm"));

        machine.step();
        machine.step();
        machine.step();
        assertEquals("The result of IADD should be -60", machine.topOfStack(), -60);
    }

    @Test
    public void testSimpleIsub() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task2/TestIsub1.ijvm"));

        machine.step();
        assertEquals("The result of ISUB should be 10", machine.topOfStack(), 10);
    }

    @Test
    public void testSignedIsub() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task2/TestIsub2.ijvm"));

        machine.step();
        assertEquals("The result of ISUB should be -10", machine.topOfStack(), -10);
    }

    @Test
    public void testSwap() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task2/TestSwap1.ijvm"));

        machine.step();
        assertEquals("The TOS should be 10", machine.topOfStack(), 10);
        machine.step();
        assertEquals("The TOS should be 20", machine.topOfStack(), 20);
        machine.step();
        assertEquals("Swap should swap the variables", machine.topOfStack(), 10);
        machine.step();
        assertEquals("The top if the stack should now be 20", machine.topOfStack(), 20);
    }

    @Test
    public void testSimpleStackOperations() throws IOException {
        machine = MachineFactory.createIJVMInstance(new File("files/task2/TestPop1.ijvm"));

        machine.step();
        machine.step();
        machine.step();
        assertEquals("Pop should pop the value of the stack", machine.topOfStack(), 10);
        machine.step();
        machine.step();
        machine.step();
        assertEquals("The result of IADD should be 50", machine.topOfStack(), 50);
        machine.step();
        assertEquals("Pop should pop the value of the stack", machine.topOfStack(), 10);
    }


}
