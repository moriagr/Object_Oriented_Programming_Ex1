import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);

    // stub method to check external dependencies compatibility
    @Test
    public void test() {
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(() -> JvmUtilities.objectFootprint(s1));

        logger.info(() -> JvmUtilities.objectFootprint(s1, s2));

        logger.info(() -> JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    void update() {
        ConcreteMember concreteMember = new ConcreteMember();
        UndoableStringBuilder undoableStringBuilder = new UndoableStringBuilder();
        UndoableStringBuilder undoableStringBuilder1 = new UndoableStringBuilder();
        undoableStringBuilder.append("hello");
        concreteMember.update(undoableStringBuilder);
        undoableStringBuilder.append("hello1");

        assertEquals(undoableStringBuilder.toString(), concreteMember.undoableStringBuilder.toString());

        undoableStringBuilder.append("hello1");
        assertEquals(undoableStringBuilder.toString(), concreteMember.undoableStringBuilder.toString());

        undoableStringBuilder1.append("hey");

        concreteMember.update(undoableStringBuilder1);
        assertEquals(undoableStringBuilder1.toString(), concreteMember.undoableStringBuilder.toString());

        concreteMember.update(null);
        assertNull(concreteMember.undoableStringBuilder);

        concreteMember.update(undoableStringBuilder1);
        assertEquals(undoableStringBuilder1.toString(), concreteMember.undoableStringBuilder.toString());

    }

    @Test
    void register() {
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember concreteMember = new ConcreteMember();
        ConcreteMember concreteMember1 = new ConcreteMember();
        groupAdmin.append("hello");
        logger.info(JvmUtilities::jvmInfo);

        groupAdmin.register(concreteMember);
        assertEquals("[ConcreteMember{undoableStringBuilder=hello}]", groupAdmin.getCustomers().toString());

        groupAdmin.register(concreteMember);
        assertEquals("[ConcreteMember{undoableStringBuilder=hello}]", groupAdmin.getCustomers().toString());

        groupAdmin.register(concreteMember1);
        assertEquals("[ConcreteMember{undoableStringBuilder=hello}, ConcreteMember{undoableStringBuilder=hello}]", groupAdmin.getCustomers().toString());

        groupAdmin.register(null);
        assertEquals("[ConcreteMember{undoableStringBuilder=hello}, ConcreteMember{undoableStringBuilder=hello}]", groupAdmin.getCustomers().toString());
    }

    @Test
    void unregister() {
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember concreteMember = new ConcreteMember();
        ConcreteMember concreteMember1 = new ConcreteMember();
        groupAdmin.append("hello");

        groupAdmin.register(concreteMember);
        assertEquals("GroupAdmin{situations=hello, customers=[ConcreteMember{undoableStringBuilder=hello}]}", groupAdmin.toString());

        groupAdmin.register(concreteMember1);
        assertEquals("GroupAdmin{situations=hello, customers=[ConcreteMember{undoableStringBuilder=hello}, ConcreteMember{undoableStringBuilder=hello}]}", groupAdmin.toString());

        groupAdmin.unregister(concreteMember);
        assertEquals("GroupAdmin{situations=hello, customers=[ConcreteMember{undoableStringBuilder=hello}]}", groupAdmin.toString());

        groupAdmin.unregister(concreteMember);
        assertEquals("GroupAdmin{situations=hello, customers=[ConcreteMember{undoableStringBuilder=hello}]}", groupAdmin.toString());

        groupAdmin.unregister(concreteMember1);
        assertEquals("GroupAdmin{situations=hello, customers=[]}", groupAdmin.toString());

        groupAdmin.unregister(null);
        assertEquals("GroupAdmin{situations=hello, customers=[]}", groupAdmin.toString());
    }

    @Test
    void insert() {
        GroupAdmin testStr = new GroupAdmin();
        testStr.append("A whole world");
        testStr.insert(8, "new ");
        System.out.println(testStr);
        assertEquals("A whole new world", testStr.getSituations().toString());
        testStr.insert(20, "newnew ");
    }

    @Test
    void append() {
        GroupAdmin testStr = new GroupAdmin();
        testStr.append("");
        assertEquals("", testStr.getSituations().toString());
        testStr.append("to be or not to be");
        assertEquals("to be or not to be", testStr.getSituations().toString());
        testStr.append("be");
        assertEquals("to be or not to bebe", testStr.getSituations().toString());
    }

    @Test
    void delete() {
        GroupAdmin testStr = new GroupAdmin();
        testStr.append("incomprehensibility");
        testStr.delete(2, 11);
        assertEquals("insibility", testStr.getSituations().toString());
        testStr.delete(0, 10);
        assertEquals("", testStr.getSituations().toString());
        testStr.append("video games");
        testStr.delete(-1, 3);
        testStr.delete(-1, 20);
    }

    @Test
    void undo() {
        GroupAdmin testUndo = new GroupAdmin();
        testUndo.append("to be or not to be");
        System.out.println(testUndo);
        System.out.println("\nTest for undo: \n");
        testUndo.undo();
        System.out.println(testUndo);
        testUndo.undo();
        System.out.println(testUndo);
    }
}
