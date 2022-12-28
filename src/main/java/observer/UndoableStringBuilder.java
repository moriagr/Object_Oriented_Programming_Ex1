package observer;

import java.util.*;
import java.lang.StringBuilder;

public class UndoableStringBuilder {

    Stack<String> my_stack;
    StringBuilder strBuild = new StringBuilder();


    public UndoableStringBuilder() {
        my_stack = new Stack<>();
    }

    /**
     * Appends the specified string to this character sequence.
     *
     * @param str The word you want to attach
     * @return the string after append
     */
    public UndoableStringBuilder append(String str) {
        try {
            strBuild.append(str);
            my_stack.push(strBuild.toString());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.err.println("Please enter a String variable");
        }
        return this;
    }

    /**
     * Removes the characters in a substring of this sequence. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     * pushes the string after deletion to a stack.
     *
     * @param start the first index of which we would like to perform deletion
     * @param end   the last index of which we would like to perform deletion
     * @return returns the string after deletion
     */
    public UndoableStringBuilder delete(int start, int end) {
        try {
            strBuild.delete(start, end);
            my_stack.push(strBuild.toString());
        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
            System.err.println("Please check your start and end indexes");
        }
        return this;
    }

    /**
     * Inserts the string into this character sequence.
     *
     * @param offset the index where the word is entered
     * @param str    is the word you want to insert
     * @return the current string builder after insert
     */
    public UndoableStringBuilder insert(int offset, String str) {
        try {
            strBuild.insert(offset, str);
            my_stack.push(strBuild.toString());
        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
            System.err.println("StringIndexOutOfBoundsException is found in the program");
        }
        return this;
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in the specified String.
     * The substring begins at the specified start and extends to the character at index end - 1 or to the end
     * of the sequence if no such character exists. First the characters in the substring are removed
     * and then the specified String is inserted at start. (This sequence will be lengthened to accommodate
     * the specified String if necessary)
     *
     * @param start the beginning index, inclusive
     * @param end   the ending index, exclusive
     * @param str   String that will replace previous contents
     * @return this object
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        try {
            strBuild.replace(start, end, str);
            my_stack.push(strBuild.toString());
        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
            System.err.println("Please check your start and end indexes");
        } catch (NullPointerException nullPointerException) {
            System.err.println("NullPointerException Caught");
        }
        return this;
    }

    /**
     * Causes this character sequence to be replaced by the reverse of the
     * sequence.
     *
     * @return the current string builder after reverse
     */
    public UndoableStringBuilder reverse() {
        try {
            strBuild.reverse();
            my_stack.push(strBuild.toString());
        } catch (Exception e) {
            System.err.println("You entered a wrong format, please try again");
        }
        return this;
    }

    /**
     * reverses the action of an earlier action
     *
     * @return returns the previous string.
     */
    public void undo() {
        try {
            my_stack.pop();
        } catch (EmptyStackException emptyStackException) {
            System.err.println("EmptyStackException is found in the program");
        }
    }

    /**
     * Returns a string representation of the object.
     *
     * @return string representation of the object.
     */
    @Override
    public String toString() {
        if (my_stack.isEmpty()) {
            return "EmptyStackException is found in the program";
        } else {
            return my_stack.peek();
        }
    }
}