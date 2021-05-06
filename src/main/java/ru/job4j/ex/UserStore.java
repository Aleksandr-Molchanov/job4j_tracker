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
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException();
        }
        return true;
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