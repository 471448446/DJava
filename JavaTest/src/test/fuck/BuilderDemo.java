package test.fuck;

public class BuilderDemo {
    static class Person {
        String name;

        // ?? 这样也行？
        static class Builder<T extends Builder> {
            String name;

            T name(String n) {
                this.name = n;
                return (T) this;
            }

            Person build() {
                Person p = new Person();
                p.name = this.name;
                return p;
            }
        }
    }

    static class Solder extends Person {
        String knife;

        static class Builder extends Person.Builder<Builder> {
            String knife;

            Builder knife(String n) {
                this.knife = n;
                return this;
            }

            @Override
            Solder build() {
                Solder s = new Solder();
                s.name = this.name;
                s.knife = knife;
                return s;
            }
        }
    }

    public static void main(String[] args) {
        Person p = new Person.Builder().name("Lili").build();
        Solder s = new Solder.Builder().name("AS").knife("dabaojian").build();
    }
}
