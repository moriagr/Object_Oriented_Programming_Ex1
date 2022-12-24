import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    @Test
    void update() {
        ConcreteMember concreteMember = new ConcreteMember();
        UndoableStringBuilder undoableStringBuilder = new UndoableStringBuilder();
        undoableStringBuilder.append("hello");
        concreteMember.update(undoableStringBuilder);
        undoableStringBuilder.append("hello1");

        assertEquals(concreteMember.undoableStringBuilder.toString(), undoableStringBuilder.toString());
    }
}