/*
En este caso se usa un Nodo con doble enlace: uno que apunta al siguiente y
otro al anterior.

Reutilizar los métodos existentes pensando en mantener en las operaciones de
inserción y remoción ambos enlaces.
 */
package linkedlist.doble;

import linkedlist.List;
import linkedlist.simple.v2.SimpleLinkedList;

import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    // Atributos de la lista enlazada;
    private Nodo<T> head;  // apunta el primer nodo
    private Nodo<T> tail;  // apunta al ultimo nodo
    private int size;  // cantidad de nodos

    private Nodo<T> curr;  // posicion del nodo actual

    public LinkedList(int size) {
        this();
    }
    public LinkedList() {
        clear();
    }


    private boolean insertFirstNode(Nodo<T> n) {
        this.head = null;
        this.tail = null;
        this.curr = n;
        this.size++;
        return true;
    }

    @Override
    public void clear() {
        curr = tail = new Nodo<T>(head, null);
        head = new Nodo<T>(null, tail);
        size = 0;
    }

    @Override
    public boolean insert(T it) {
        /*
        Algo particular de esta funcion es que no permite insertar al final
        puede ser al inicio o enmedio pero no al final.
         */

        if (curr == head){
            throw new NoSuchElementException();
        }
        curr = new Nodo<T>(it, curr.getPrevio(), curr);
        curr.getPrevio().setSiguiente(curr);
        curr.getSiguiente().setPrevio(curr);
        size++;
        return true;
    }

    @Override
    public boolean append(T it) {
        tail.setPrevio(new Nodo<T>(it, tail.getPrevio(), tail));
        tail.getPrevio().getPrevio().setSiguiente(tail.getPrevio());
        if (curr == tail){
            curr = tail.getPrevio();
        }
        size++;
        return true;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (curr == tail){
            throw new NoSuchElementException();
        }
        T it = curr.getDato();
        curr.getPrevio().setSiguiente(curr.getSiguiente());
        curr.getSiguiente().setPrevio(curr.getPrevio());
        curr = curr.getSiguiente();
        size--;
        return null;
    }

    @Override
    public void moveToStart() {
        curr = head.getSiguiente();
    }

    @Override
    public void moveToEnd() {
        curr = tail.getPrevio();
    }

    @Override
    public void prev() {
        if (curr.getPrevio() != head){
            curr = curr.getPrevio();
        }
    }

    @Override
    public void next() {
        if (curr != tail){
            curr = curr.getSiguiente();
        }
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public int currPos() {
        return currPos();
    }

    @Override
    public boolean moveToPos(int pos) {
        if (pos < 0 || pos > size) {
            return false;
        }
        curr = head.getSiguiente();
        for (int i = 0; i < pos; i++){
            curr = curr.getSiguiente();
        }
        return true;
    }

    @Override
    public boolean isAtEnd() {
        return curr == tail;
    }

    @Override
    public T getValue() throws NoSuchElementException {
        if (curr == tail) {
            throw new NoSuchElementException("no valido curr es igual a la cola");
        }

        return curr.getDato();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //Creacion de la clase nodo

    public static class Nodo<T> {
        private T dato; // Modificador de valores
        private Nodo<T> siguiente;  // enlace al siguiente nodo
        private Nodo<T> previo;  // enlace al nodo previo

        //Constructores


        public Nodo(T dato, Nodo<T> previo, Nodo<T> siguiente) {
            this.dato = dato;
            this.previo = previo;
            this.siguiente = siguiente;

        }
        public Nodo(Nodo<T> previo, Nodo<T> siguiente){
            this.previo = previo;
            this.siguiente = siguiente;
        }


        //Getter y setters


        public T getDato() {
            return dato;
        }

        public T setDato(T dato) {
            return this.dato = dato;
        }

        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public Nodo<T> setSiguiente(Nodo<T> siguiente) {
            return this.siguiente = siguiente;
        }

        public Nodo<T> getPrevio() {
            return previo;
        }

        public Nodo<T> setPrevio(Nodo<T> previo) {
            return  this.previo = previo;
        }

        @Override
        public String toString() {
            return dato.toString();
        }

    }
}
