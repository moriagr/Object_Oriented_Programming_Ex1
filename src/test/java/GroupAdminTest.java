import observer.Member;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

    @Test
    void register() {
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember concreteMember = new ConcreteMember();
        groupAdmin.register(concreteMember);
    }

    @Test
    void unregister() {
    }

    @Test
    void insert() {
        UndoableStringBuilder testStr = new UndoableStringBuilder();
        testStr.append("A whole world");
        testStr.insert(8, "new ");
        System.out.println(testStr);
        assertEquals("A whole new world", testStr.toString());
        testStr.insert(20, "newnew ");
    }

    @Test
    void append() {
        UndoableStringBuilder testStr = new UndoableStringBuilder();
        testStr.append("");
        assertEquals("", testStr.toString());
        testStr.append("to be or not to be");
        assertEquals("to be or not to be", testStr.toString());
        testStr.append("be");
        assertEquals("to be or not to bebe", testStr.toString());
    }

    @Test
    void delete() {
        UndoableStringBuilder testStr = new UndoableStringBuilder();
        testStr.append("incomprehensibility");
        testStr.delete(2, 11);
        assertEquals("insibility", testStr.toString());
        testStr.delete(0, 10);
        assertEquals("", testStr.toString());
        testStr.append("video games");
        testStr.delete(-1, 3);
        testStr.delete(-1, 20);
    }

    @Test
    void undo() {
        UndoableStringBuilder testUndo = new UndoableStringBuilder();
        testUndo.append("to be or not to be");
        System.out.println(testUndo);
        System.out.println("\nTest for undo: \n");
        testUndo.undo();
        System.out.println(testUndo);
        testUndo.undo();
        System.out.println(testUndo);
//        testUndo.undo();
//        System.out.println(testUndo);
//        testUndo.undo();
//        System.out.println(testUndo);
    }
}