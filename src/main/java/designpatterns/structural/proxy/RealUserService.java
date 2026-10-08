package designpatterns.structural.proxy;

public class RealUserService implements UserService {
    @Override
    public void deleteUser(Long userId) {
        System.out.println("Deleted User: " + userId);
    }
}
