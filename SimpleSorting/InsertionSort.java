public class InsertionSort {
  
  public static void main(String[] args) {
    int numToSort = Integer.parseInt(args[0]);
    int printRate = Integer.parseInt(args[1]);
    
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < numToSort; i++) {
      LinkedList.insertInOrder((int)(Math.random() * numToSort), list);
      if ((i + 1) % printRate == 0)
        System.out.println("We have sorted " + (i+1) + " values so far");
    }
    System.out.println("Done sorting!");
    if (args.length > 2 && args[2].equals("-print"))
      LinkedList.printList(list);
  }
}