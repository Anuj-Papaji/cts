import java.util.Scanner;



public class Program1{



  public static boolean isPrime(int n) {

    int c=0;

    for(int i=2;i<n;i++) {

      if(n%i==0) {

        c= 1;

        break;

      }

    }

    return (c==0);

  }





public static void main(String args[]){

  Scanner sc=new Scanner(System.in);

  System.out.println("Enter the first number");

  int n1 = sc.nextInt();

  System.out.println("Enter the last number");

  int n2 = sc.nextInt();

  while(n1%10!=1) {

    n1++;

  }

  int x = n1;

  for(int i=n1;i<n2;i+=10) {

    if(isPrime(i)){

      System.out.print(i+",");

    }

    x = i;

  }

  x+=10;

  if(isPrime(n2) && n2%10==1) {

    System.out.print(n2);

  }

  else {

    while(isPrime(x)==false){

      x+=10;

    }

    System.out.print(x);

  }

 }

}