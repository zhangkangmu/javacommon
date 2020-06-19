package com.tensquare.demo02_atomic;

import java.util.concurrent.atomic.AtomicReference;

public class Demo5AtomicReference {

    public static void main(String[] args) throws InterruptedException {
        User u1 = new User("张三", 22);
        User u2 = new User("李四", 33);
        User u3 = new User("张六", 22);
        AtomicReference ar = new AtomicReference(u1);
        ar.compareAndSet(u1, u2);

        System.out.println(ar.get());

    }

    static class User {
        private String name;
        public volatile int age;

        public User(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            return ((User)obj).getAge() == this.getAge();
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}