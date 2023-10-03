import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void matchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean expected = true;
        boolean actual = simpleTask.matches("звонить");
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void noMatchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean expected = false;
        boolean actual = simpleTask.matches("телефон");

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void matchesMeetingInTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("приложения");

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void matchesMeetingInProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("НетоБанк");

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void noMatchesMeetingInStart() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = false;
        boolean actual = meeting.matches("вторник");

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void noMatchesMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = false;
        boolean actual = meeting.matches("завтрак");

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void matchesEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean expected = true;
        boolean actual = epic.matches("Яйца");

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void noMatchesEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean expected = false;
        boolean actual = epic.matches("Кефир");

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void shouldGetIdFromTask() {
        Task task = new Task(7);
        task.getId();

        int expected = 7;
        int actual = task.getId();

        Assertions.assertEquals(expected, actual);

    }
}