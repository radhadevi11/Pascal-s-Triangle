import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {

    public static void main(String[] args) {
       /* Algorithm(Pascal):
        Step1:Create an ArrayList<Integer> called pascalList.
        Step2:Create another ArrayList<Integer> called previousList and insert element 1 and insert previousList into pascalList.(ie, pascalList.add(previousList))
        Step3:for i=1 to n-1  do(calculate ith row)
                  i)for j=0 to i do
                       a)create an ArrayList<Integer> called currentList
                       b)if j=0 then insert element 1 into the currentList(j,1)
                       c)if j=i then insert element 1 into the currentList(j,1) and assaign currentList to previousList and insert the previousList into pascalList
                       d)otherwise add previousList[j-1]+previousList[j] and insert the element into the currentList(j)
        Step4:Print the PascalList.*/




        pascalTriangle(10);


    }
        public static void pascalTriangle(int n) {

            List<List<Integer>> pascalList = new ArrayList<>();
            List<Integer> previousList;
            List<Integer> initialList = new ArrayList<>();
            initialList.add(0, 1);
            pascalList.add(initialList);
            previousList = initialList;
            for (int i = 1; i <= n - 1; i++) {

               previousList = getCurrentList(previousList,pascalList,i);
            }
            print(pascalList);

        }
        public static List<Integer> getCurrentList(List<Integer> previousList,List<List<Integer>> pascalList,int rowNumber){
            List<Integer> currentList = new ArrayList<>();
            for (int j = 0; j <= rowNumber; j++) {
                if (j == 0) {
                    currentList.add(j,1);

                } else if (j == rowNumber) {
                    currentList.add(j, 1);
                    pascalList.add(rowNumber, currentList);

                } else {

                    currentList.add(previousList.get(j - 1) + previousList.get(j));
                }
            }
            return currentList;
        }

        public static void print(List<List<Integer>> pascalList){
            for (List<Integer> pascal : pascalList) {
                for (int result : pascal) {
                    System.out.print(result + "\t");
                }
                System.out.println();

            }
        }






}
