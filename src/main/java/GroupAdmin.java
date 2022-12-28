import observer.Member;
import observer.Sender;
import observer.UndoableStringBuilder;

import java.util.LinkedList;
import java.util.List;

public class GroupAdmin implements Sender {

    private final UndoableStringBuilder situations;
    private final List<Member> customers;

    public GroupAdmin() {
        this.situations = new UndoableStringBuilder();
        this.customers = new LinkedList<>();
    }

    /**
     * methods to register observers.
     *
     * @param obj is the name of the member we want to register.
     */
    @Override
    public void register(Member obj) {
        if (obj != null && !this.customers.contains(obj)) {
            obj.update(this.situations);
            this.customers.add(obj);
        }
    }

    /**
     * methods to unregister observers.
     *
     * @param obj is the name of the member we want to unregister.
     */
    @Override
    public void unregister(Member obj) {
        if (obj != null) {
            obj.update(null);
            this.customers.remove(obj);
        }
    }

    @Override
    public String toString() {
        return "GroupAdmin{" +
                "situations=" + situations +
                ", customers=" + customers +
                '}';
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
        this.myNotifyAll();
    }

    /**
     * Appends the specified string to this character sequence.
     *
     * @param obj The word you want to attach
     */
    @Override
    public void append(String obj) {
        this.situations.append(obj);
        this.myNotifyAll();
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
        this.myNotifyAll();
    }

    /**
     * Erases the last change done to the document, reverting it to an older state.
     */
    @Override
    public void undo() {
        this.situations.undo();
        this.myNotifyAll();
    }

    /**
     * Update all the members.
     */
    public void myNotifyAll() {
        for (Member customer : this.customers) {
            customer.update(this.situations);
        }
    }

    public UndoableStringBuilder getSituations() {
        return situations;
    }

    public List<Member> getCustomers() {
        return customers;
    }
}
