package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                rsl = index;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementAbuseException();
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            String[] value = new String[] {"a", "b", "c"};
            int index = indexOf(value, "asdf");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}