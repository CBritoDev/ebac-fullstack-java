package br.com.cbritodeveloper.set;

import br.com.cbritodeveloper.domain.Aluno;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

public class TestesPerformanceSet {

    public static void main(String args[]) {
        Random r = new Random();

        HashSet<Aluno> hashSet = new HashSet<Aluno>();
        TreeSet<Aluno> treeSet = new TreeSet<Aluno>();
        LinkedHashSet<Aluno> linkedSet = new LinkedHashSet<Aluno>();

        // start time
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100000000; i++) {
            int x = r.nextInt(100000000 - 10) + 10;
            hashSet.add(new Aluno("João da Silva", "Linux básico", x));
        }
        // end time
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("HashSet: " + duration);




        // start time
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 100000000; i++) {
            int x = r.nextInt(100000000 - 10) + 10;
            treeSet.add(new Aluno("João da Silva", "Linux básico", x));
        }
        // end time
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("TreeSet: " + duration);




        // start time
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 100000000; i++) {
            int x = r.nextInt(100000000 - 10) + 10;
            linkedSet.add(new Aluno("João da Silva", "Linux básico", x));
        }
        // end time
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("LinkedHashSet: " + duration);
    }
}