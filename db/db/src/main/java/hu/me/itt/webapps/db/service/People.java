package hu.me.itt.webapps.db.service;

public class People {
	private Long id;

    private int age;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People() {
    }

    public People(hu.me.itt.webapps.db.repository.People people) {
        this.id = people.getId();
        this.age = people.getAge();
        this.name = people.getName();
    }

    public People(Long id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public hu.me.itt.webapps.db.repository.People toEntity(){
        return new hu.me.itt.webapps.db.repository.People(id, age, name);
    }
}
