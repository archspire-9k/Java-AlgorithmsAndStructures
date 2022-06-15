public class MergeSort {
  
  public static void main(String[] args) {
    int numToSort = Integer.parseInt(args[0]);
    
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < numToSort; i++) {
      list.addToFront((int)(Math.random() * numToSort));
    }
    
    LinkedList.mergeSort(list);
    System.out.println("Done!");
    if (args.length > 1 && args[1].equals("-print"))
      LinkedList.printList(list);
  }
}