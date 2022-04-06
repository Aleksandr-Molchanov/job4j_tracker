package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FindByNameActionTest {

    @Test
    public void whenFindByNameCompleted() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("FindByName item");
        tracker.add(item);
        String findName = item.getName();
        FindByNameAction FBN = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(findName);

        FBN.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===" + ln + item + ln));
        assertThat(tracker.findByName(findName), is(List.of(item)));
    }

    @Test
    public void whenFindByNameNotCompleted() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("FindByName item");
        tracker.add(item);
        String findName = item.getName();
        FindByNameAction FBN = new FindByNameAction(out);

        Input input = mock(Input.class);

        FBN.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===" + ln + "Заявки не найдены." + ln));
        assertThat(tracker.findByName(findName), is(List.of(item)));
    }
}