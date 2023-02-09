package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in =
                     SqlTrackerTest.class.getClassLoader()
                             .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        item.setCreated(item.getCreated().withNano(0));
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSearchingForAnElementByANonExistentIdTheElementShouldNotBeFound() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertNull(tracker.findById(10));
    }

    @Test
    public void whenSavingAnItemAndReplacingItTheItemMustBeReplaced() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Item newItem = new Item("newItem");
        assertTrue(tracker.replace(item.getId(), newItem));
        Item expected = tracker.findById(item.getId());
        assertNotEquals(expected, is(item));
    }

    @Test
    public void whenDeletingAnElementTheElementMustBeDeleted() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertTrue(tracker.delete(item.getId()));
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenAddingElementsAllElementsMustBeFound() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        item1.setCreated(item1.getCreated().withNano(0));
        item2.setCreated(item2.getCreated().withNano(0));
        item3.setCreated(item3.getCreated().withNano(0));
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> items = tracker.findAll();
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        expected.add(item3);
        assertEquals(3, items.size());
        assertThat(expected, is(items));
    }

    @Test
    public void whenSearchingForElementsByNameAllElementsWithThisNameShouldBeFound() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item");
        Item item2 = new Item("item");
        Item item3 = new Item("item3");
        item1.setCreated(item1.getCreated().withNano(0));
        item2.setCreated(item2.getCreated().withNano(0));
        item3.setCreated(item3.getCreated().withNano(0));
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> items = tracker.findByName("item");
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        assertEquals(2, items.size());
        assertThat(expected, is(items));
    }

    @Test
    public void whenSearchingForAnElementByANonExistentNameTheElementShouldNotBeFound() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> items = tracker.findByName("item5");
        List<Item> expected = new ArrayList<>();
        assertEquals(0, items.size());
        assertThat(expected, is(items));
    }
}