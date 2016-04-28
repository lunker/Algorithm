public class love{


	public static void main(String[] args) {
  int numA = 6;
  int numB = 8;
  while(numA > 0){
  for (int i = 0; i < numA; i++) {System.out.printf(" ");}
  for (int j = 0; j < numB; j++) {System.out.printf("*");}
  for (int j = 0; j < (numA*2+1); j++) {System.out.printf(" ");}
  for (int i = 0; i < numB; i++) {System.out.printf("*");}
  System.out.println();
  numA=numA-2;
  numB=numB+4;
  }
  numA=0;
  numB=41;
  while(numB > 0){
  for (int i = 0; i < numA; i++) {System.out.printf(" ");}
  for (int i = 0; i < numB; i++) {System.out.printf("*");}
  numA=numA+2;
  numB=numB-4;
  System.out.println();
  }
   }

   
}