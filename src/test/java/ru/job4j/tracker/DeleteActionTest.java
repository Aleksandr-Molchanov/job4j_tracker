package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DeleteActionTest {

    @Test
    public void whenDeleteCompleted() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Delete item");
        tracker.add(item);

        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Заявка удалена успешно." + ln));
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenDeleteNotCompleted() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Delete item");
        tracker.add(item);

        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Ошибка удаления заявки." + ln));
        assertThat(tracker.findAll().get(0).getName(), is("Delete item"));
    }
}