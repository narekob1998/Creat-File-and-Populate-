//Student Name: Narek Bayramyan
//LSU ID: 893511902
//Lab Section:
//Assignment: #1
//Submission Time: 5:20
package NarekB;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Random;
import java.io.File;

public class FilesProject {
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        System.out.println("Enter a file name:");
        Scanner sysin = new Scanner(System.in); 
        
        String fileName = sysin.nextLine();
        
        System.out.println("Enter Your File Size:");  
        int size = sysin.nextInt();

        populateFile(fileName, size);
        
        System.out.printf("Java:%s\t Mean: %.2f\t Min: %d\n",fileName ,getMean(fileName), getMin(fileName)); 
        
    }
    public static void populateFile(String FileName, int FileSize) throws FileNotFoundException
    {
        PrintWriter out = new PrintWriter(FileName);
        Random random = new Random();
        for(int i = 0; i < FileSize; i++)
        {
            int num = random.nextInt((2100 - 1500)+1) + 1500;
            out.println(num);
        }
        out.close();
   }
    public static double getMean(String FileName) throws FileNotFoundException
    {
        File in = new File(FileName);
        Scanner inFile = new Scanner(in);
        
        int sum = 0;
        int count = 0;
        
        while(inFile.hasNextInt())
        {
            sum += inFile.nextInt();
            count++;
        }
        inFile.close();
        
        return sum/count;
    }
    public static int getMin(String FileName) throws FileNotFoundException
    {
        File in = new File(FileName);
        Scanner inFile = new Scanner(in);
        int min = 2100;
       
        while(inFile.hasNextInt())
        {
           int num = inFile.nextInt();
            if(num < min)
               min = num;
        }
        inFile.close();
        return min;   
    } 
}
