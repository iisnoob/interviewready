package designpatterns.builder;

public class UserMigrationService {
    public void migrateUser() {
        UserBuilder builder = new UserBuilder();
        builder.setName("Amber Mustafa")
                .setAge(30)
                .setAddress("Lucknow")
                .setGender("Male")
                .setEmail("hello@ambermustafa.com");

        User user = new User(builder);
        String userInfo = user.toString();
        System.out.println(userInfo);

    }
}
