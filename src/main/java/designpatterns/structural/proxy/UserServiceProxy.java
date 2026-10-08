package designpatterns.structural.proxy;

public class UserServiceProxy implements UserService {

    private final RealUserService userService;

    public UserServiceProxy(RealUserService userService) {
        this.userService = userService;
    }

    @Override
    public void deleteUser(Long userId) {
        System.out.print("Checking authorization");
        try {
            for (int i = 1; i <= 5; i++) {
                Thread.sleep(800);
                System.out.print(".");
            }
            Thread.sleep(1000);
            System.out.println();
            System.out.println("Authorized!");
            userService.deleteUser(userId);
            System.out.println("User successfully deleted!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
