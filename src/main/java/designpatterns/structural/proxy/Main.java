package designpatterns.structural.proxy;

public class Main {
    public static void main(String[] args) {
        UserService userService =
                new UserServiceProxy(
                        new RealUserService()
                );

        userService.deleteUser(1232131231201L);
    }
}
