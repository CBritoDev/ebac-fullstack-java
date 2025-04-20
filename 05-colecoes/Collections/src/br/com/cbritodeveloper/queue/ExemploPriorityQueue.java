package br.com.cbritodeveloper.queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Possui ordenação natural
 *
 * @author carlos.brito
 */
public class ExemploPriorityQueue {

    public static void main(String args[]){
        //Ordenação natural e automática
        Queue<String> queue = new PriorityQueue<String>();
        queue.add("short");
        queue.add("small");
        queue.add("medium");
        while(queue.size() != 0){
            System.out.println(queue.remove());
        }
    }
}
