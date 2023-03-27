package org.algo.mak.solution.impl.hashtable;

public class Main {

    public static void main(String[] args) {
        var personJobMap = new HashTable<Person, String>();
        personJobMap.put(new Person("John", 28), "Engineer");
        personJobMap.put(new Person("Albert", 22), "Worker");
        personJobMap.put(new Person("Bill", 42), "Seller");
        personJobMap.put(new Person("Victor", 33), "Director");
        personJobMap.put(new Person("Kelly", 37), "VP");
        personJobMap.put(new Person("Sam", 55), "Driver");
        personJobMap.put(new Person("Bill", 45), "Analyst");
        personJobMap.put(new Person("Bob", 29), "Journalist");
        personJobMap.put(new Person("Kate", 32), "Musician");
        personJobMap.put(new Person("Margaret", 65), "Unemployed");
        personJobMap.put(new Person("Margaret", 65), "Unemployed2");

        System.out.println(personJobMap.get(new Person("Kelly", 37)));
        System.out.println(personJobMap.remove(new Person("Kelly", 37)));
        System.out.println(personJobMap.remove(new Person("John", 28)));
        System.out.println(personJobMap.remove(new Person("Kate", 32)));
    }
}
