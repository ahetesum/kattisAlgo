import java.util.Scanner;
public class Copurnicus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        while(sc.hasNext()){
            int earthDay = sc.nextInt(), marsDay = sc.nextInt();
            if(earthDay == 0 && marsDay == 0){
                System.out.println("Case " + i + ": 0");
            }
            else{
                int resultValue = 365 - earthDay;
                marsDay = (marsDay + (365 - earthDay)) % 687;
                earthDay = 0;
                while(!(earthDay == 0 && marsDay == 0)){
                    resultValue += 365;
                    marsDay = (marsDay + 365) % 687;
                }
                System.out.printf("Case %d: %d%n", i, resultValue);
            }
            i++;
        }
    }
}