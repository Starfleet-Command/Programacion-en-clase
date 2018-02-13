public class Moda
{
public static int mode(int[] list) {

    //Initialize max and min value variable as first value of list
    int maxValue = list[0];
    int minValue = list[0];

    //Finds maximum and minimum values in list
    for (int i = 1; i < list.length; i++) {
        if (list[i] > maxValue) {
            maxValue = list[i];
        }

        if (list[i] < minValue) {
            minValue = list[i];
        }
    }

    //Initialize count array with (maxValue - minValue + 1) elements
    int[] count = new int[maxValue - minValue + 1];

    //Tally counts of values from list, store in array count
    for (int i = 0; i < list.length; i++) {
        count[list[i] - minValue]++; //Increment counter index for current value of list[i] - minValue
    }

    //Find max value in count array
    int max = count[0]; //Initialize max variable as first value of count

    for (int i = 1; i < count.length; i++) {
        if (count[i] > max) {
            max = count[i];
        }
    }

    //Find first instance where max occurs in count array
    for (int i = 0; i < count.length; i++) {
        if (count[i] == max) {
            return i + minValue; //Returns index of count adjusted for min/max list values - this is the mode value in list
        }
    }
    return -1; //Only here to force compilation, never actually used
}
}
