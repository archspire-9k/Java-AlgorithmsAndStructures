public class DNA extends DoubleLinkedList<DNA.Base>{
  
  // list of nuclobases
  public enum Base{
    A,C,G,T
  }
  
  /**
   * return the presentation in the form of String
   * @param list the DNA that we want to convert into String
   * @return String that represent the DNA in the form of String
   */
  public String toString(DNA list){
    
    // the string that stores the dna after conversion
    StringBuilder str = new StringBuilder();
    
    for(Base x : list){
      str.append(x.toString());
    }
    
    return str.toString();
  }
  
  /** 
   * change the string to the DNA type
   * @param s the string that we want to convert
   * @return the DNA that has been converted from input string
   */
  public static DNA string2DNA(String s){
    
    if(s.length() == 0){
      throw new IllegalArgumentException();
    }
    else{
    // gene is the DNA after string S is converted
    DNA gene = new DNA();
    
    for(int i = 0; i<= s.length()-1; i++){
      if(s.charAt(i) == 'A'){
        gene.addToBack(DNA.Base.A);
      }
      if(s.charAt(i) == 'C'){
        gene.addToBack(DNA.Base.C);
      }
      if(s.charAt(i) == 'G'){
        gene.addToBack(DNA.Base.G);
      }
      if(s.charAt(i) == 'T'){
        gene.addToBack(DNA.Base.T);
      }
      if(s.charAt(i) != 'A' && s.charAt(i) != 'T' && s.charAt(i) != 'G' && s.charAt(i) != 'C'){
        throw new IllegalArgumentException();
      }
    }
    return gene;
    }
  }
  
  /**
   * append the remaining of the dna after removal numbases elements from front input to this dna
   * @param dna the dna that will be cut
   * @param numbases number of elements that will be cut from the dna
   */
  public void splice(DNA dna, int numbases){
    
    if(dna.toString(dna).length() > numbases){
      for(int i = 0; i < numbases; i++){
        dna.removeFromFront();
      }
      this.append(dna);
    }
    else
      this.append(null);
  }
  
  /**
   * return true if the 2 dna overlap in the last n elements of dna1 and first n elements of dna2
   * return false if the 2 dna does not overlap in the last n elements of dna1 and first n elements of dna2
   * @param dna1 dna1
   * @param dna2 dna2
   * @param n the number of elements that will take into consideration
   * @return the true/false result according to the correctness of their overlap
   */
  public static boolean overlaps(DNA dna1, DNA dna2, int n){
    DLNode dna1ptr = dna1.getBack();
    DLNode dna2ptr = dna2.getFront();
    
    for(int i = 0; i < n-1; i++){
      dna1ptr = dna1ptr.getPrevious();
    }
    
    for(int i = 0; i < n; i++){
      if(!(dna1ptr.getElement() == dna2ptr.getElement())){
        return false;
      }
      else {
        dna1ptr = dna1ptr.getNext();
        dna2ptr = dna2ptr.getNext();
      }
    }
    return true;
  }
  
  public static void main(String[] args){
    
    DNA dna1 = DNA.string2DNA(args[0]);
    DNA dna2 = DNA.string2DNA(args[1]);
     
    int max1 = 0; // field that stores the maximum overlap between dna1 and dna2 by splicing dna2 into dna1
    int max2 = 0; // field that stores the maximum overlap between dna1 and dna2 by splicing dna1 into dna2
    
    for(int i = 0; i < Math.min(args[0].length() , args[1].length()) ;i++){
      if(DNA.overlaps(dna1, dna2, i) == true){
        if(i > max1){
          max1 = i; 
        }
      }
    }
    
    for(int i = 0; i < Math.min(args[0].length() , args[0].length()) ;i++){
      if(DNA.overlaps(dna2, dna1, i) == true){
        if(i > max2){
          max2 = i; 
        }
      }
    }
    
    if(max2 > max1){
      dna2.splice(dna1 , max2);
      System.out.println(dna1.toString(dna2));
    }
    else{
      dna1.splice(dna2 , max1);
      System.out.println(dna1.toString(dna1));
    }
  }
}