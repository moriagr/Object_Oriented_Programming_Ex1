import observer.Member;
import observer.Sender;
import observer.UndoableStringBuilder;

import java.util.LinkedList;
import java.util.List;

public class GroupAdmin implements Sender {

    private UndoableStringBuilder situations;
    private List<Member> customers;


    public GroupAdmin() {
        this.situations = new UndoableStringBuilder();
        this.customers = new LinkedList<>();
    }

    /**
     * methods to register observers
     *
     * @param obj is the name of the member we want to register.
     */
    @Override
    public void register(Member obj) {
        if (!this.customers.contains(obj)) {
            this.customers.add(obj);
        }
    }

    /**
     * methods to unregister observers
     *
     * @param obj is the name of the member we want to unregister.
     */
    @Override
    public void unregister(Member obj) {
        this.customers.remove(obj);
    }

    /**
     * Inserts the string into this character sequence.
     *
     * @param offset the index where the word is entered
     * @param obj    is the word you want to insert
     */
    @Override
    public void insert(int offset, String obj) {
        this.situations.insert(offset, obj);
    }

    /**
     * Appends the specified string to this character sequence.
     *
     * @param obj The word you want to attach
     */
    @Override
    public void append(String obj) {
        this.situations.append(obj);
    }

    /**
     * Removes the characters in a substring of this sequence.
     *
     * @param start the first index of which we would like to perform deletion
     * @param end   the last index of which we would like to perform deletion
     */
    @Override
    public void delete(int start, int end) {
        this.situations.delete(start, end);
    }

    /**
     * Erases the last change done to the document, reverting it to an older state.
     */
    @Override
    public void undo() {
        this.situations.undo();
    }

    public UndoableStringBuilder getSituations() {
        return situations;
    }

    public void setSituations(UndoableStringBuilder situations) {
        this.situations = situations;
    }

    public List<Member> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Member> customers) {
        this.customers = customers;
    }
}
