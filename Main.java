import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random=new Random();
        Scanner input=new Scanner(System.in);
        int randomNumber=random.nextInt(100);
        //int randomNumber=(int)(Math.random()*100);
        System.out.println("Programın rastgele seçtiği sayı: "+randomNumber);
        int right=0;
        int predictedNumber;
        boolean isWin=false;
        boolean isWrong=false;
        int[] wrongs=new int[5];
        while(right<5){
            System.out.println("Lütfen tahmininizi giriniz: ");
            predictedNumber=input.nextInt();

            if(predictedNumber<0 || predictedNumber>99){
                System.out.println("Lütfen 0-100 arasında bir değer giriniz...");
                if(!isWrong){
                    isWrong=true;
                    System.out.println("Bir sonraki hatalı giriş yaptığınızda canınızdan düşülecektir...");
                }else{
                    System.out.println("Çok fazla hatalı giriş yaptınız...");
                    System.out.println("Kalan hakkınız: "+ (5- (++right)));
                }
                continue;
            }

            if(predictedNumber==randomNumber){
                System.out.println("Tebrikler! Oyunu kazandınız, doğru tahmin... Tahmininiz: "+randomNumber);
                isWin=true;
                break;
            }else{
                wrongs[right]=predictedNumber;
                right++;
                System.out.println("Hatalı bir sayı girdiniz...");
                if(predictedNumber<randomNumber){
                    System.out.println(predictedNumber+" sayısı gizli sayıdan küçüktür...");
                }else{
                    System.out.println(predictedNumber+" sayısı gizli sayıdan büyüktür...");
                }
                System.out.println("Kalan hakkınız: "+ (5-right));
            }
        }

        if(!isWin){
            System.out.println("Kaybettiniz...");
            System.out.println("Tahminleriniz: ");
            for(int i=0;i< wrongs.length;i++){
                if(wrongs[i]!=0){
                    System.out.print(wrongs[i]+" ");
                }
            }
        }
    }
}
