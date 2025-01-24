package com.hasandag;

/**
 * Created by dev on 11/10/2015.
 */
public interface NodeList<T> {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);

    void traverseWithoutOutput(ListItem root);
}
