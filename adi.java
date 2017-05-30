import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.lang.*;
import static java.lang.System.*;
import static java.lang.Math.*;
/*created by aditya76*/
public class adi {
        static int maxx=Integer.MAX_VALUE;
        public static void main(String[] args) throws IOException {
        InputReader sc = new InputReader(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> pizza=new ArrayList<Integer>();
        ArrayList<Integer> taxi=new ArrayList<Integer>();
        ArrayList<Integer> girls=new ArrayList<Integer>();
        String[] arr=new String[n];
        for(int i=0;i<n;i++){
          int pizzas=0,taxis=0,girlss=0;
          int num=sc.nextInt();
          arr[i]=sc.readString();
          for(int j=0;j<num;j++){
            String str=sc.readString();
            long number = str.chars().distinct().count();
            if((int)number==2){
              taxis++;
              continue;
            }
            ArrayList<Integer> al=new ArrayList<Integer>();
            for(int k=0;k<str.length();k++){
              if(Character.getNumericValue(str.charAt(k))!=-1){
                al.add(Character.getNumericValue(str.charAt(k)));
              }
            }
            //out.println(al);
            boolean adi=true;
            for(int m=1;m<al.size();m++){
              if(al.get(m)>=al.get(m-1))
                adi=false;
            }
            if(adi)
              pizzas++;
            else
              girlss++;

          }
          pizza.add(pizzas);
          taxi.add(taxis);
          girls.add(girlss);

        }

        int tmax=Collections.max(taxi);
        ArrayList<String> tax=new ArrayList<String>();
        for(int p=0;p<n;p++){
          if(taxi.get(p)==tmax)
            tax.add(arr[p]);
        }
        out.print("If you want to call a taxi, you should call: ");
        for(int z=0;z<tax.size();z++){
          out.print(tax.get(z));
        if(z==tax.size()-1)
          out.print(".");
        else
          out.print(","+" ");
        }
        out.println();

        int pmax=Collections.max(pizza);
        ArrayList<String> piz=new ArrayList<String>();
        for(int p=0;p<n;p++){
          if(pizza.get(p)==pmax)
            piz.add(arr[p]);
        }
        out.print("If you want to order a pizza, you should call: ");
        for(int z=0;z<piz.size();z++){
          out.print(piz.get(z));
        if(z==piz.size()-1)
          out.print(".");
        else
          out.print(","+" ");
        }
        out.println();

        int gmax=Collections.max(girls);
        ArrayList<String> gir=new ArrayList<String>();
        for(int p=0;p<n;p++){
          if(girls.get(p)==gmax)
            gir.add(arr[p]);
        }
        out.print("If you want to go to a cafe with a wonderful girl, you should call: ");
        for(int z=0;z<gir.size();z++){
          out.print(gir.get(z));
        if(z==gir.size()-1)
          out.print(".");
        else
          out.print(","+" ");
        }
        out.println();
    }

public static long bxp(long a,long b){
        long res=1;
        while(b>0){
          if(b%2!=0)
            res=res*a;
          a=(a*a);
          b>>=1;
      }
  return res;
}

public static long gcd(long p, long q) {
        if (q == 0)
          return p;
        return gcd(q, p % q);
      }

public static boolean isprime(long number){
        for(int i=2;i<=sqrt(number); i++){
          if(number % i == 0){
            return false;
          }
      }
        return true;
}

public static String rev(String s){
    StringBuilder sb=new StringBuilder(s);
	  sb.reverse();
	  return sb.toString();
}

public static long lcm(long a, long b){
    return a * (b / gcd(a, b));
}

public static void dfs(ArrayList<ArrayList<Integer>> adjLists,boolean[] neha,int v){
      neha[v]=true;
    //System.out.print(v+" ");
      for(int w:adjLists.get(v)){
        if(!neha[w]){
          dfs(adjLists,neha,w);
      }
    }
}

public static ArrayList<Integer> sieve(int n,int m){
      boolean[] isPrime = new boolean[n+1];
      ArrayList<Integer> al=new ArrayList<Integer>();
        for (int i = 2; i <= n; i++)
            isPrime[i] = true;
        for (int factor = 2; factor*factor <=n; factor++) {
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= n; j++)
                    isPrime[factor*j] = false;
            }
        }
        int primes = 0;
        for (int i = m; i <= n; i++) {
            if (isPrime[i])
              al.add(i);
            }
        return al;
        }

static class InputReader {
      private final InputStream stream;
      private final byte[] buf = new byte[8192];
      private int curChar, snumChars;
      public InputReader(InputStream st) {
            this.stream = st;
        }
      public int read() {
          if (snumChars == -1)
              throw new InputMismatchException();
          if (curChar >= snumChars) {
              curChar = 0;
              try {
                  snumChars = stream.read(buf);
                } catch (IOException e) {
                  throw new InputMismatchException();
              }
              if (snumChars <= 0)
                  return -1;
            }
              return buf[curChar++];
          }
      public int nextInt() {
          int c = read();
          while (isSpaceChar(c)) {
              c = read();
            }
          int sgn = 1;
            if (c == '-') {
              sgn = -1;
              c = read();
            }
          int res = 0;
          do{
            res *= 10;
            res += c - '0';
            c = read();
          } while (!isSpaceChar(c));
            return res * sgn;
          }
      public long nextLong() {
          int c = read();
          while (isSpaceChar(c)) {
              c = read();
            }
          int sgn = 1;
          if (c == '-') {
              sgn = -1;
              c = read();
            }
          long res = 0;
          do {
            res *= 10;
            res += c - '0';
            c = read();
          } while (!isSpaceChar(c));
              return res * sgn;
          }
      public int[] nextIntArray(int n) {
              int a[] = new int[n];
              for (int i = 0; i < n; i++) {
                a[i] = nextInt();
              }
              return a;
            }

      public String readString() {
              int c = read();
              while (isSpaceChar(c)) {
                c = read();
              }
              StringBuilder res = new StringBuilder();
              do {
                res.appendCodePoint(c);
                c = read();
              } while (!isSpaceChar(c));
              return res.toString();
            }

      public String readLine() {
              int c = read();
              while (isSpaceChar(c))
                c = read();
              StringBuilder res = new StringBuilder();
              do {
                res.appendCodePoint(c);
                c = read();
              } while (!isEndOfLine(c));
              return res.toString();
            }

            public boolean isSpaceChar(int c) {
              return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }

            private boolean isEndOfLine(int c) {
              return c == '\n' || c == '\r' || c == -1;
            }
      }
}
