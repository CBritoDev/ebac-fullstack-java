package br.com.cbritodeveloper.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ExemploArrayDeque {
    public static void main(String args[]){
        inserindoNaFila();
        removendoDaFila();
        acessandoFila();
    }

    private static void acessandoFila(){
        System.out.println("*****  ACESSANDO  *****");
        Deque<String> ad = new ArrayDeque<>();
        ad.add("Red");
        ad.add("Blue");
        ad.add("White");
        ad.add("Purple");
        ad.add("Yellow");
        ad.add("Black");

        Deque<String> d = new ArrayDeque<>();
        d.add("Green");
        d.add("Orange");

        ad.addAll(d);

        System.out.println(ad);
        System.out.println(ad.contains("White"));
        System.out.println(d.contains("Cian"));
        System.out.println(d.containsAll(d));

        System.out.println("Output of element: " + ad.element());
        System.out.println("Get first element using getFirst: " + ad.getFirst());
        System.out.println("Get last element using getLast: " + ad.getLast());
        System.out.println("Output of peek: " + ad.peek());
        System.out.println("Get first element using peekFirst: " + ad.peekFirst());
        System.out.println("Get last element using peekLast: " + ad.peekLast());
        System.out.println();
    }

    private static void  removendoDaFila(){
        System.out.println("*****  REMOVENDO  *****");
        Deque<String> ad = new ArrayDeque<>();
        ad.add("Red");
        ad.add("Blue");
        ad.add("White");
        ad.add("Purple");
        ad.add("Yellow");
        ad.add("Black");

        Deque<String> d = new ArrayDeque<>();
        d.add("Pink");
        d.add("Cian");
        d.add("Brown");
        d.add("Gold");
        d.add("Pearl");
        d.add("Translucent");

        ad.addAll(d);
        System.out.println("Elements in the ArrayDeque: " + ad);

        String val = ad.remove();
        ad.remove("Black");

        System.out.println("Elements in the ArrayDeque after remove: " + ad);

        ad.removeFirst();
        ad.removeLast();

        System.out.println("Elements in the ArrayDeque after removeFirst and removeLast: " + ad);

        ad.poll();
        ad.pollFirst();
        ad.pollLast();

        System.out.print("Elements in the ArrayDeque after poll, pollFirst, pollLast: " + ad);

        ad.pop();
        System.out.println("Elements in the ArrayDeque after pop: " + ad);

        ad.retainAll(d);
        System.out.println("Elements in the ArrayDeque after retainAll: " + ad);

        ad.removeAll(d);
        System.out.println("Elements in the ArrayDeque after removeAll: " + ad);
        System.out.println("");
    }

    private static void inserindoNaFila() {
        System.out.println("*****  INSERINDO  *****");

        Deque<String> d = new ArrayDeque<>();
        d.add("Lowpro");
        d.addFirst("Bangalore");
        d.addLast("Channel");

        System.out.println("Elements in the Deque after add, addFirst and addLast: " + d);

        Deque<String> dq = new ArrayDeque<>();
        dq.add("Hydrogen");
        dq.add("Iron");

        d.addAll(dq);

        System.out.println("Elements in the Deque after addAll: " + d);
    }
}
