package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FindByIdActionTest {

    @Test
    public void whenFindByIdCompleted() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("FindById item");
        tracker.add(item);
        int findId = item.getId();
        FindByIdAction FBId = new FindByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        FBId.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + item + ln));
        assertThat(tracker.findById(findId), is(item));
    }

    @Test
    public void whenFindByIdNotCompleted() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("FindById item");
        tracker.add(item);
        int findId = item.getId();
        FindByIdAction FBId = new FindByIdAction(out);

        Input input = mock(Input.class);

        FBId.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + "Заявка с введенным id не найдена." + ln));
        assertThat(tracker.findById(findId), is(item));
    }
}