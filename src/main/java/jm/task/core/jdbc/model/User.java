package jm.task.core.jdbc.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

@Entity //класс будет отображен в базе данных
@Table (name = "Users") // к какой именно таблице привязывается класс
public class User {
    @Id // говорит о том что столбец связанный с полем явл. primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//признание стартегии увеличения автоинкрементирования на
    // стороне базы данных
    @Column (name = "id")
    private Long id;

    @Column (name = "name") //какой именно столбец из таблицы привязан к полю класса
    private String name;

    @Column (name = "lastName")
    private String lastName;

    @Column (name = "age")
    private Byte age;

    public User() {

    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User {" +
                "name= " + this.name + '\'' +
                "surname" + this.lastName + '\'' +
                "age =" + this.age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, age);
    }
}

