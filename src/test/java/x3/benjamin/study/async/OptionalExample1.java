package x3.benjamin.study.async;


import x3.benjamin.study.async.data.entity.Student;

import java.util.Optional;


public class OptionalExample1 {
    public static void main(String[] args) {
        OptionalExample1 example = new OptionalExample1();
        Optional<Student> op = example.getStudent();

        // Sample #1
        if (op.isPresent())
            System.out.println("Case 1 : " + op.get().toString());

        // Sample #2
        // Return the value if present, otherwise return other.
        Student student1 = op.orElse(new Student());
        System.out.println("Case 2 : " + student1.toString());

        // Sample #3
        // Return the value if present, otherwise invoke other and return the result of that
        // invocation.
        Student student2 = op.orElseGet(() -> {
            Student s = new Student();
            s.setAddress("123");
            s.setName("Anonymous");
            return s;
        });
        System.out.println("Case 3 : " + student2.toString());

        // Sample #4
        // If a value is present, and the value matches the given predicate, return an Optional
        // describing the value, otherwise return an empty Optional.
        Student student3 =
                op.filter(s -> s.getAddress() != null).filter(s -> s.getAge() > 0).filter(s -> s.getName() != null).orElseGet(Student::new);
        System.out.println("Case 4 : " + student3.toString());

        // Sample #5
        System.out.println("Case 5 : " + op.flatMap(s -> Optional.of(s.getName() + "," + s.getAddress())).orElse(""));

        // Sample #6
        op.orElseThrow(() -> new NullPointerException("Student is null"));
    }

    public Optional<Student> getStudent() {
        // return Optional.of(new Student("Benjamin", 19, null));
        return Optional.empty();
    }
}
