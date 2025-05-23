public class ArrayUebungen {


    //Aufgabe 1
    public static int getSum(int[] elements){
        int sum = 0;
        for(int i=0; i<elements.length; i++){
            sum += elements[i];
        }
        return sum;
    }

    //Aufgabe 2
    /*public static int getSum(int[][] elements){
        int sum = 0;
        for(int row=0; row<elements.length;row++){
            for(int col=0;col<elements[row].length;col++){
                sum+=elements[row][col];
            }
        }
        return sum;
    }
*/

    //Aufgabe 2 Methoden Aufruf
    public static int getSum(int[][] elements){
        int sum = 0;
        for(int row=0;row<elements.length;row++){
            sum+=getSum(elements[row]);
        }
        return sum;
    }

    //Aufgabe 3
    public static int[] concatenate(int[] arr1, int[] arr2){
        int[] result=new int[arr1.length+arr2.length];
        for(int i=0;i<arr1.length;i++){
            result[i]=arr1[i];
        }
        for(int j=0;j<arr2.length;j++){
            result[arr1.length+j]=arr2[j];
        }
        return result;
    }


    //Aufgabe 4
    public static int[] filter(int[] arr, int min, int max) {
        // 1. Zählen, wie viele Elemente im Bereich liegen
        int count = 0;
        for (int value : arr) {
            if (value >= min && value <= max) {
                count++;
            }
        }

        // 2. Ergebnis-Array in genau dieser Länge anlegen
        int[] result = new int[count];

        // 3. Elemente kopieren
        int index = 0;
        for (int value : arr) {
            if (value >= min && value <= max) {
                result[index] = value;
                index++;
            }
        }

        return result;
    }

}
