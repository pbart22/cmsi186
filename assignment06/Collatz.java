 public class Collatz{


   public static void main(String[] args){

     System.out.println("\n Welcome to The Collatz Program!:");
     System.out.println("********************************");

   int i = 0;
   BrobInt arg = new BrobInt(args[0]);
   System.out.println("\nInput: " + arg.toString());

   while(arg.equals(BrobInt.ONE) == false) {

     if(arg.remainder(BrobInt.TWO).equals(BrobInt.ZERO)){
       System.out.println(arg = arg.divide(BrobInt.TWO));
       i++;

     } else if (arg.remainder(BrobInt.TWO).equals(BrobInt.ONE)) {
       arg = arg.add(arg).add(arg);
       System.out.println(arg = arg.add(BrobInt.ONE));
       i++;
     }
   }

   System.out.println("\nIt took " + i +  " iterations" + " to reach one\n");
  }
}