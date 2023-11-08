import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Pattern132FinderTest {
    
    @Test
    void testPatternFound() {
        // Test when a pattern is found
        int[] nums = { 3, 1, 4, 2 };
        Pattern132Finder finder = new Solution();
        assertTrue(finder.find132pattern(nums));
    }

    @Test
    void testPatternNotFound() {
        // Test when a pattern is not found
        int[] nums = { 1, 2, 3, 4 };
        Pattern132Finder finder = new Solution();
        assertFalse(finder.find132pattern(nums));
    }

    @Test
    void testPatternNotEnoughElements() {
        // Test when there are not enough elements in the array (less than 3)
        int[] nums = { 1, 2 };
        Pattern132Finder finder = new Solution();
        assertFalse(finder.find132pattern(nums));
    }
}
