package designpatterns.builder.better;

public class Main {
    public static void main(String[] args) {
        User user = new User
                .UserBuilder()
                .setName("Amber Mustafa")
                .setAge(30)
                .build();

        System.out.println(user.toString());
    }
}
