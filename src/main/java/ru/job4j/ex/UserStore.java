package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User us : users) {
            if ((us.getUsername()).equals(login)) {
                rsl = us;
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException();
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl = true;
        if (!user.isValid()) {
            throw new UserInvalidException();
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            System.out.println("Пользователь не валидный.");
        } catch (UserNotFoundException unf) {
            System.out.println("Пользователь не найден.");
        }
    }
}