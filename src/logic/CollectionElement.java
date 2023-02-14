package logic;

import java.io.InputStream;

public interface CollectionElement {
    CollectionElement getElementFromConsole(InputStream is);
    CollectionElement getElementFromFile(InputStream is);
}
