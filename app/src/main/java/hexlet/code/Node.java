package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Node {
    OperationType type;
    Object oldValue;
    Object newValue;
}
