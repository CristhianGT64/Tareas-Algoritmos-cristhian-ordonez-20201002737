package linkedlist.doble;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList<Integer> lista;
    @BeforeEach
    void setUp() {
        lista = new LinkedList<>();
    }

    @Test
    void tesprimernodo(){

        lista.append(10);

    }


}