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

    @Override
    public void register(Member obj) {
        this.customers.add(obj);
    }

    @Override
    public void unregister(Member obj) {
        this.customers.remove(obj);
    }

    @Override
    public void insert(int offset, String obj) {
        this.situations.insert(offset, obj);
    }

    @Override
    public void append(String obj) {
        this.situations.append(obj);
    }

    @Override
    public void delete(int start, int end) {
        this.situations.delete(start, end);
    }

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
