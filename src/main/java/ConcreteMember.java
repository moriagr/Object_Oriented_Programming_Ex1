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

    /**
     * This function shallowCopy the undoableStringBuilder to current undoableStringBuilder.
     *
     * @param usb is the undoableStringBuilder that we want to shallow copy.
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.undoableStringBuilder = usb;
    }
}
