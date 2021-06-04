package ru.job4j.bank;

import ru.job4j.map.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
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
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport паспорт, по которому находится пользователь
     * @param requisite реквизиты счета, который нужно найти
     * @return возвращает найденный счет или null, если он не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(a -> a.getRequisite().contains(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
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
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}