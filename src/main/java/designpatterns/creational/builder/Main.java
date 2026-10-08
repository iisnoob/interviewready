package designpatterns.creational.builder;

public class Main {
    public static void main(String[] args) {
        UserMigrationService userMigrationService = new UserMigrationService();
        userMigrationService.migrateUser();
    }
}
