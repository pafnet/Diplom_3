package userapi;

import net.datafaker.Faker;

public class UserFaker {

    private static Faker faker = new Faker();

    public static User getRandomUser() {
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = generateRandomPassword();

        return new User(email, password, name);
    }

    private static String generateRandomPassword() {
        return "Random*Password#1234567890";
    }

    public static void main(String[] args) {
        User randomUser = getRandomUser();
        System.out.println(randomUser);
    }
}
