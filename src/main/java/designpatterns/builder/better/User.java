package designpatterns.builder.better;

public class User {
    private final String name;
    private final Integer age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User(UserBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    static class UserBuilder {
        private String name;
        private Integer age;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
