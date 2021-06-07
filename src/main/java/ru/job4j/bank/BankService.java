package ru.job4j.bank;

import ru.job4j.map.Student;

import java.util.*;

/**
 * Класс описывает работу простейшей банковской системы
 * @author Aleksandr Molchanov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение информации о пользователях осуществляется в коллекции типа HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и
     * если такого пользователя еще нет, добавляет его
     * @param user пользователь, которого нужно добавить в систему
     */
    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<>());
        }
    }

    /**
     * Метод добавляет новый счет к пользователю.
     * Счета пользователя находится по его паспорту и к ним
     * добавляется новый счет, которого еще нет в системе
     * @param passport паспорт, по которому находится пользователь
     * @param account счет пользователя, который нужно добавить
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод находит пользователя по паспорту
     * @param passport паспорт, по которому находится пользователь
     * @return возвращает найденного пользователя или null, если он не найден
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport паспорт, по которому находится пользователь
     * @param requisite реквизиты счета, который нужно найти
     * @return возвращает найденный счет или null, если он не найден
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(a -> a.getRequisite().contains(requisite))
                .findFirst());
    }

    /**
     * Метод перечисляет деньги с одного счета на другой.
     * Для осуществления перевода проверяется, существуют ли счета пользователе
     * между которыми должен быть совершен перевод и достаточно ли
     * средств для перевода на счете пользователя, осуществляющего перевод
     * @param srcPassport паспорт пользователя, осуществляющего перевод
     * @param srcRequisite реквизиты счета с которого будет сделан перевод
     * @param destPassport паспорт пользователя, которому делают перевод
     * @param destRequisite реквизиты счета, куда будет сделан перевод
     * @param amount сумма перевода
     * @return возвращает true, если перевод был осуществлен или false, если нет.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dest.isPresent() && src.get().getBalance() >= amount) {
            src.get().setBalance(src.get().getBalance() - amount);
            dest.get().setBalance(dest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}