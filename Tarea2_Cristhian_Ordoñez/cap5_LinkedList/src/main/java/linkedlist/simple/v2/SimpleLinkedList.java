/*

El asunto de esta version es utilizar curr como una referencia de tipo Nodo en
lugar de un entero que ubica las posiciones.

Objetivo: Cambiar en las funciones existentes este rol. También se removió la
función getNode para utilizar directamente curr.
 */

package linkedlist.simple.v2;

import linkedlist.List;
import java.util.NoSuchElementException;

public class SimpleLinkedList<T> implements List<T> {
    // Atributos de la lista enlazada;
    private Nodo<T> head;  // apunta el primer nodo
    private Nodo<T> tail;  // apunta al ultimo nodo
    private int size;  // cantidad de nodos

    private Nodo<T> curr;  // posición del nodo actual

    public SimpleLinkedList(int size) {
        this();
    }
    public SimpleLinkedList() {
        clear();
    }

    /*
    private boolean insertFirstNode(Nodo<T> n) {
        this.head = null;
        this.tail = null;
        this.curr = n;
        this.size++;
        return true;
    }
    */
    @Override
    public void clear() {
        curr = tail = new Nodo<T>(null);
    head = new Nodo<T>(tail);
    size = 0;
    }

    @Override
    public boolean insert(T it) {

        curr.setSiguiente(new Nodo<T>(curr.getDato(), curr.getSiguiente()));
        curr.setDato(it);
        if (tail == curr){
            tail = curr.getSiguiente();
        }
        size++;
        return true;
    }

    @Override
    public boolean append(T it) {
        tail.setSiguiente(new Nodo<T>(null, null)); // crea un nuevo nodo
        tail.setDato(it); //Ingresa valor en el nodo actual
        tail = tail.getSiguiente(); //Apunta al ultimo nodo
        size ++;
        return true;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (curr == tail){
            throw new NoSuchElementException("No se puede elimniar la cola");
        }
        T aux; // almacena temporalmente el nodo
        aux = curr.getDato();
        curr.setDato(curr.getSiguiente().getDato());
        if (curr.getSiguiente() == tail){
            tail = curr; // remueve el ultimo y mueve la cola
        }
        curr.setSiguiente(curr.getSiguiente().getSiguiente());
        size --;
        return aux;
    }

    @Override
    public void moveToStart() {
        curr = head;
    }

    @Override
    public void moveToEnd() {
        curr = tail;
    }

    @Override
    public void prev() {
        if (head.getSiguiente() == curr){
            return;
        }
        Nodo<T> aux = head;
        while (aux.getSiguiente() != curr){
            aux = aux.getSiguiente();
        }
        curr = aux;
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
        if ((pos < 0) || (pos > size)) {
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
            throw new NoSuchElementException("no valido error de getvalue");
        }

        return curr.getDato();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public class Nodo<T> { // clase para nodos
        public Nodo<T> siguiente; // referencia al siguientenodo
        private T dato;// modificador de elementos
        public Nodo(T dato, Nodo<T> siguiente) { // constructores
            this.dato = dato;
            this.siguiente = siguiente;
        }
        public Nodo(Nodo<T> siguiente){
            this.dato = null;
            this.siguiente = siguiente;
        }

        //getter y setters


        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public Nodo<T> setSiguiente(Nodo<T> siguiente) {
            return this.siguiente = siguiente;
        }

        public T getDato() {
            return dato;
        }

        public T setDato(T dato) {
            return this.dato = dato;
        }

        @Override
        public String toString() {
            return dato.toString();
        }

    }
}