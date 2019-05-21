package collections;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StackTest {

    @Test
    void push_pop() {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        Integer i = s.pop();
        assert i.equals(10);
    }

    @Test
    void testPopEmpty(){
        Stack<Integer> s = new Stack<>();
        assertThrows(EmptyStackException.class, s::pop);
    }
}