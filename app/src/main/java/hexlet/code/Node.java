package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Node {
    private OperationType type;
    private Object oldValue;
    private Object newValue;
}
