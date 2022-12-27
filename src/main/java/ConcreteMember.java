import observer.Member;
import observer.UndoableStringBuilder;

public class ConcreteMember implements Member {

    UndoableStringBuilder undoableStringBuilder;

    @Override
    public String toString() {
        return "ConcreteMember{" +
                "undoableStringBuilder=" + undoableStringBuilder +
                '}';
    }

    @Override
    public void update(UndoableStringBuilder usb) {
        this.undoableStringBuilder = usb;
    }
}
