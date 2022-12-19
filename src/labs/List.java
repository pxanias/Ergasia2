package labs;

import java.util.NoSuchElementException;

public class List<T>  {

        private Node<T> head = null;
        private Node<T> tail = null;

        /**
         * Default constructor
         */
        public List() {
        }

        /**
         * Determine whether list is empty
         *
         * @return true if list is empty
         */

        public boolean isEmpty() {
            return head == null;
        }

        /**
         * Inserts the data at the front of the list
         *
         * @param data the inserted data
         */

        public void insertAtFront(T data) {
            Node<T> n = new Node<>(data);

            if (isEmpty()) {
                head = n;
                tail = n;
            } else {
                n.setNext(head);
                head = n;
            }
        }

        /**
         * Inserts the data at the end of the list
         *
         * @param data the inserted item
         */

        public void insertAtBack(T data) {
            Node<T> n = new Node<>(data);

            if (isEmpty()) {
                head = n;
                tail = n;
            } else {
                tail.setNext(n);
                tail = n;
            }
        }

        /**
         * Returns and removes the data from the list head
         *
         * @return the data contained in the list head
         * @throws NoSuchElementException if the list is empty
         */

        public T removeFromFront() throws NoSuchElementException {
            if (isEmpty())
                throw new NoSuchElementException();

            T data = head.getData();

            if (head == tail)
                head = tail = null;
            else
                head = head.getNext();

            return data;
        }

        /**
         * Returns and removes the data from the list tail
         *
         * @return the data contained in the list tail
         * @throws NoSuchElementException if the list is empty
         */

        public T removeFromBack() throws NoSuchElementException {
            if (isEmpty())
                throw new NoSuchElementException();

            T data = tail.getData();

            if (head == tail)
                head = tail = null;
            else {
                Node<T> iterator = head;
                while (iterator.getNext() != tail)
                    iterator = iterator.getNext();

                iterator.setNext(null);
                tail = iterator;
            }

            return data;
        }

        /**
         * Returns list as String
         */

        public String toString() {
            if (isEmpty()) {
                return "List is empty :(";
            }

            Node current = head;

            StringBuilder ret = new StringBuilder();

            // while not at end of list, output current node's data
            ret.append("HEAD -> ");

            while (current != null) {
                ret.append(current.data.toString());

                if (current.getNext() != null)
                    ret.append(" -> ");

                current = current.next;
            }

            ret.append(" <- TAIL");

            return ret.toString();
        }
    }
