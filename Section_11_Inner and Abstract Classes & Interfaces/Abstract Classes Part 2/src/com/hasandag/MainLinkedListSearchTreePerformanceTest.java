package com.hasandag;

import java.lang.reflect.Constructor;

public class MainLinkedListSearchTreePerformanceTest {

    public static void main(String[] args) {


        // For this challenge, create an abstract class to define items that can be stored in a list.
        // The class should contain 2 references to items which will represent the next and previous
        // items (in the case of a linked list).
        // I.e., if you call your abstract class ListItem, then it would have 2 member variables of
        // type ListItem that will hold references to the next/right and previous/left ListItems.
        //
        // The abstract class will also need to hold a value - try to be as flexible as possible
        // when defining the type of this value.
        //
        // The class will also need methods to move to the next item and back to the previous item,
        // and methods to set the next and previous items.
        //
        // You should also specify a compareTo() method that takes a parameter of the same type as the
        // class and returns 0 if the values are equal, greater than zero if the value sorts greater than
        // the parameter and less than zero if it sorts less than the parameter.
        //
        // Create a concrete class from your abstract list item class and use this in a MyLinkedList
        // class to implement a linked list that will add items in order (so that they are sorted
        // alphabetically). Duplicate values are not added.
        //
        // Note that you are creating your own MyLinkedList class here, not using the built-in Java one..
        //
        // The rules for adding an item to the linked list are:
        //  If the head of the list is null, make the head refer to the item to be added.
        //  If the item to be added is less than the current item in the list, add the item before the
        //      current item (i.e., make the previous item's "next" refer to the new item, and the new item's
        //      "next" refer to the current item).
        //  If the item to be added is greater than the current item, move onto the next item and compare
        //      again (if there is no next item then that is where the new item belongs).
        //
        // Care will be needed when inserting before the first item in the list (as it will not have a previous
        // item).
        //
        // You will also need a method to remove an item from the list.
        //
        // Hint: If you are creating classes with names such as List, MyLinkedList, Node etc, make sure that
        // you create your classes before referring to them. In previous videos we have often referred to
        // classes that we create later, but if you use names that IntelliJ recognises as Java classes (such
        // as MyLinkedList) then it will create imports for them and possibly cause you problems later.
        //
        // Optional: create a class to use your concrete class to implement a Binary Search Tree:
        // When adding items to a Binary Search Tree, if the item to be added is less than the current item
        // then move to the left, if it is greater than the current item then move to the right.
        //
        // The new item is added when an attempt to move in the required direction would involve following a
        // null reference.
        // Once again, duplicates are not allowed.
        //
        // Hint: to avoid typing loads of "addItem" lines, split a string into an array and create your list in
        // a loop as in the example below.
        //
        // Create a string data array to avoid typing loads of addItem instructions:


        int itemCount = 20000;

        // inefficiant way :(
/*        try {
            NodeList myLinkedList = getNodeList(itemCount, MyLinkedList.class);

            NodeList mySearchTree = getNodeList(itemCount, SearchTree.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        try {
            NodeList myLinkedList = getNodeList(itemCount, new MyLinkedList(new Node("5")));

            NodeList mySearchTree = getNodeList(itemCount, new SearchTree(new Node("5")));
        } catch (Exception e) {
            e.printStackTrace();
        }



/*        NodeList myLinkedList2 = getNodeList(10, MyLinkedList.class);

        NodeList mySearchTree2 = getNodeList(10, SearchTree.class);

        System.out.println("myLinkedList2: ");
        myLinkedList2.traverse(myLinkedList2.getRoot());

        System.out.println("mySearchTree2: ");
        mySearchTree2.traverse(mySearchTree2.getRoot());*/

       /* String alphaNumericString = RandomString.getAlphaNumericString(500000);    // 500.000.000 or 500.000

        System.out.println("alphaNumericString size:" + alphaNumericString.length());
        
        //long startTime = System.currentTimeMillis();
        long startTime = System.nanoTime();

        MyLinkedList myLinkedList = new MyLinkedList(new Node("5"));
        for (char ch : alphaNumericString.toCharArray()) {
            myLinkedList.addItem(new Node("" + ch));
        }



        myLinkedList.traverse(myLinkedList.getRoot());

       // long endTime = System.currentTimeMillis();
        long endTime = System.nanoTime();

        System.out.println("Elapsed time: " + (endTime - startTime));*/


        /*
        //String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        String stringData = "2 8 6 4 7 3 5 0 1";

        MyLinkedList myLinkedList = new MyLinkedList(new Node("5"));
        String[] data = stringData.split(" ");
        for (String s : data) {
            myLinkedList.addItem(new Node(s));
        }
        myLinkedList.traverse(myLinkedList.getRoot());


        SearchTree mySearchTree = new SearchTree(new Node("5"));

        for (String s : data) {
            mySearchTree.addItem(new Node(s));
        }
        mySearchTree.traverse(mySearchTree.getRoot());
        */

    }


    private static NodeList getNodeList(int itemCount, NodeList myList) throws Exception {
           long addingMyLinkedListStartTime = System.currentTimeMillis();

           int i = 0;
           while (i < itemCount) {
               int randomBetweenRange = (int) RandomIntGenerator.getRandomDoubleBetweenRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
               myList.addItem(new Node("" + randomBetweenRange));

               i++;
           }

           long addingMyLinkedListEndTime = System.currentTimeMillis();

           System.out.println("Elapsed time in adding: " + (addingMyLinkedListEndTime - addingMyLinkedListStartTime));

           long traversingMyLinkedListStartTime = System.currentTimeMillis();

           myList.traverseWithoutOutput(myList.getRoot());

           long traversingMyLinkedListEndTime = System.currentTimeMillis();

           System.out.println("Elapsed time in traversing: " + (traversingMyLinkedListEndTime - traversingMyLinkedListStartTime));

           System.out.println(myList.getClass().getName() + " tested with " + itemCount + " elements!");
           return myList;
       }


       // inefficiant way :(
    private static NodeList getNodeList(int itemCount, Class<? extends NodeList> cls) throws Exception {
        Constructor<? extends NodeList> construct = cls.getDeclaredConstructor(ListItem.class);
        NodeList myList = construct.newInstance(new Node("5"));

       return getNodeList(itemCount, myList);
    }
}
